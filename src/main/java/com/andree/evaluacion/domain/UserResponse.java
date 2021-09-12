package com.andree.evaluacion.domain;

import com.andree.evaluacion.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String token;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private boolean isActive;
    private UserRequest user;

    public UserResponse(User user, UserRequest userRequest){
        userRequest.setPassword("*************");
        this.id = user.getId();
        this.token = user.getToken();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.lastLogin = user.getLastLogin();
        this.isActive = user.isActive();
        this.user = userRequest;
    }
}
