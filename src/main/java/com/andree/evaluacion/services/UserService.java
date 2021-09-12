package com.andree.evaluacion.services;

import com.andree.evaluacion.domain.LoginRequest;
import com.andree.evaluacion.domain.UserRequest;
import com.andree.evaluacion.domain.UserResponse;
import com.andree.evaluacion.entity.User;
import com.andree.evaluacion.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public UserResponse saveUser(UserRequest userRequest, String token) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userRequest, User.class);

        user.setCreated(new Date());
        user.setLastLogin(user.getCreated());
        user.setActive(true);
        user.setToken(token);
        userRepository.save(user);
        return new UserResponse(user, userRequest);
    }

    public boolean validateExistEmail(String email){
        User user = userRepository.findByEmail(email);
        return (user==null)? false:true;
    }

    public String login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getUserName());
        if(user==null) return null;
        if(user.getPassword().equals( loginRequest.getUserPassword() )) {
            user.setLastLogin(new Date());
            userRepository.save(user);
            return JWTService.createJWT(user.getId(), user.getName(), user.getEmail());
        }else
            return null;
    }

    public User getUser(int id){
        User user = userRepository.findById(id).orElse(null);
        if(user!=null) user.setPassword("**********");
        return user;
    }
}
