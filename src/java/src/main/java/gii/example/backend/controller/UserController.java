package gii.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gii.example.backend.constant.UserResponse;
import gii.example.backend.entity.UserEntity;
import gii.example.backend.repo.UserRepository;
import gii.example.backend.service.UserSecretScrubService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    // get all users
    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUsers() {
        List<UserEntity> users = userRepo.findAllByOrderByUserCreatedAtAscUserIdAsc();
        List<UserEntity> scrubbedUsers = UserSecretScrubService.ScrubSecrets(users, true);
        return new ResponseEntity<>(new UserResponse(scrubbedUsers), HttpStatus.OK);
    }

    // get one user by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepo.findByUserId(id);
        if (user.isPresent()) {
            UserEntity scrubbedUser = UserSecretScrubService.ScrubSecrets(user.get(), true);
            return new ResponseEntity<>(scrubbedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
