package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnError;
import java.security.Principal;

@Controller
public class WebController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public String index()
    {
        return "external";
    }

    @GetMapping(path = "/user")
    public String users(Principal principal, Model model) {
        return "users";
        /*addUsers();
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("username", principal.getName());
        return "users";*/
    }

    @GetMapping(path = "/error")
    @OnError
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

    // add users for demonstration
    public void addUsers() {
        /*
        User user1 = new User();
        user1.setAddress("1111 foo blvd");
        user1.setName("Foo Industries");
        user1.setServiceRendered("Important services");
        userRepository.save(user1);

        User user2 = new User();
        user2.setAddress("2222 bar street");
        user2.setName("Bar LLP");
        user2.setServiceRendered("Important services");
        userRepository.save(user2);

        User user3 = new User();
        user3.setAddress("33 main street");
        user3.setName("Big LLC");
        user3.setServiceRendered("Important services");
        userRepository.save(user3);
        */
    }
}
