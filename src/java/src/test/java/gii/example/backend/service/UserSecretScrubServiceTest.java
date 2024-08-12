package gii.example.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import gii.example.backend.entity.UserEntity;

public class UserSecretScrubServiceTest {

    private final String obfuscateChars = "****";

    @Test
    void whenGivenTrueToEmailScrub_thenObfuscatePasswordAndEmail() {
        UserEntity user = new UserEntity();
        user.setUserEmail("verySecretEmail@gmail.com");
        user.setUserPwd("verySecretPassword");

        UserEntity scrubbedUser = UserSecretScrubService.ScrubSecrets(user, true);

        assertEquals(String.format("v%s@gmail.com", obfuscateChars), scrubbedUser.getUserEmail());
        assertEquals(obfuscateChars, scrubbedUser.getUserPwd());
    }

    @Test
    void whenGivenFalseToEmailScrub_thenObfuscatePassword() {
        UserEntity user = new UserEntity();
        String givenEmail = "verySecretEmail@gmail.com";
        user.setUserEmail(givenEmail);
        user.setUserPwd("verySecretPassword");

        UserEntity scrubbedUser = UserSecretScrubService.ScrubSecrets(user, false);

        assertEquals(givenEmail, scrubbedUser.getUserEmail());
        assertEquals(obfuscateChars, scrubbedUser.getUserPwd());
    }

    @Test
    void scrubbsMultipleUsers() {
        UserEntity user1 = new UserEntity();
        UserEntity user2 = new UserEntity();
        user1.setUserEmail("verySecretEmail@gmail.com");
        user1.setUserPwd("verySecretPassword");
        user2.setUserEmail("anotherSecretEmail@gmail.com");
        user2.setUserPwd("anotherSecretPassword");
        List<UserEntity> users = List.of(user1, user2);

        List<UserEntity> scrubbedUsers = UserSecretScrubService.ScrubSecrets(users, true);
        List<String> emails = scrubbedUsers.stream().map((user) -> user.getUserEmail())
                .collect(Collectors.toList());
        List<String> passwords = scrubbedUsers.stream().map((user) -> user.getUserPwd())
                .collect(Collectors.toList());

        assertEquals(List.of(
                String.format("v%s@gmail.com", obfuscateChars),
                String.format("a%s@gmail.com", obfuscateChars)),
                emails);
        assertEquals(List.of(
                obfuscateChars,
                obfuscateChars),
                passwords);
    }
}
