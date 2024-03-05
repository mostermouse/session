package com.session.session.service;

import com.session.session.db.UserRepository;
import com.session.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //login logic
    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);
        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();
            if (userDto.getPassword().equals(pw)) {
                //세션에 정보저장
                httpSession.setAttribute("USER", userDto);

            } else {
                throw new RuntimeException("Password Not Match");
            }
        } else {
            //user 없는경우
            throw new RuntimeException("User Not Found");
        }

    }
}
