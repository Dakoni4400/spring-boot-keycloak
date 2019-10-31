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

    @GetMapping(path = "/secret")
    public String users(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "secret";
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
}
