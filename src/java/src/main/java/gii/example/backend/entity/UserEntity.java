package gii.example.backend.entity;

import java.time.LocalDateTime;

import gii.example.backend.constant.UserGroupEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usr", schema = "public")
public class UserEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="usr_id", unique = true, nullable = false)
    private Long userId;

    @Column(name="usr_name", nullable = true)
    private String userName;

    @Column(name="usr_email", nullable = false)
    private String userEmail;

    @Column(name="usr_secret", nullable = false)
    private String userPwd;

    @Column(name="usr_active", nullable = false)
    private boolean userIsActive;

    @Column(name="usr_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGroupEnum userGroup;

    @Column(name="usr_created", nullable = false)
    private LocalDateTime userCreatedAt;

    @Column(name="usr_modified", nullable = false)
    private LocalDateTime userModifiedAt;
}
