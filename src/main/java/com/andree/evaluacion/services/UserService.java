package com.andree.evaluacion.services;

import com.andree.evaluacion.domain.LoginRequest;
import com.andree.evaluacion.domain.UserRequest;
import com.andree.evaluacion.domain.UserResponse;
import com.andree.evaluacion.entity.User;
import com.andree.evaluacion.repositories.IUserRepository;
import com.andree.evaluacion.utils.JWTUtils;
import com.andree.evaluacion.utils.Messages;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @SneakyThrows
    public UserResponse saveUser(UserRequest userRequest, String token) {
        if(userRepository.findByEmail(userRequest.getEmail())!=null)
            throw new Exception(Messages.ErrorUserExistEmail);

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userRequest, User.class);

        user.setCreated(new Date());
        user.setLastLogin(user.getCreated());
        user.setActive(true);
        user.setToken(token);
        userRepository.save(user);
        return new UserResponse(user, userRequest);
    }

    @SneakyThrows
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUserName());
        if(user==null)
            throw new Exception(Messages.ErrorLogin);

        if( !user.getPassword().equals( loginRequest.getUserPassword() ))
            throw new Exception(Messages.ErrorLogin);

        user.setLastLogin(new Date());
        userRepository.save(user);
        return JWTUtils.createJWT(user.getId(), user.getName(), user.getEmail());
    }

    @SneakyThrows
    public User getUser(int id){
        User user = userRepository.findById(id).orElse(null);
        if(user==null)
            throw new NotFoundException(Messages.ErrorUserNoFound);

        user.setPassword("**********");
        return user;
    }
}
