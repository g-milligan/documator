package gii.example.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gii.example.backend.entity.UserEntity;

@Service
public class UserSecretScrubService {

    private final static String obfuscateChars = "****";
    private final static String atSymbol = "@";

    public static UserEntity ScrubSecrets(UserEntity user, boolean doObfuscateEmail) {
        user.setUserPwd(obfuscateChars);
        if (!doObfuscateEmail) {
            return user;
        }
        String email = user.getUserEmail();
        if (email.contains(atSymbol)) {
            email = email.substring(0, 1) 
                + obfuscateChars
                + email.substring(email.indexOf(atSymbol));
        } else {
            email = obfuscateChars;
        }
        user.setUserEmail(email);
        return user;
    }

    public static List<UserEntity> ScrubSecrets(List<UserEntity> users, boolean doObfuscateEmail) {
        return users.stream()
            .map((user) -> ScrubSecrets(user, doObfuscateEmail))
            .collect(Collectors.toList());
    }
}
