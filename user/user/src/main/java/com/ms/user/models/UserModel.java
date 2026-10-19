package com.ms.user.models;

import com.ms.user.dtos.UserRecordDto;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    private static final long serialVersionUUID = 1L;

    public UserModel(){}

    public UserModel(UserRecordDto userRecordDto){
        this.name = userRecordDto.name();
        this.email = userRecordDto.email();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    @Column(unique = true)
    private String email;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
