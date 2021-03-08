package com.it.academy.controllers;

import com.it.academy.api.dto.UserEntityDto;
import com.it.academy.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(name="/signup")
public class SignUpController {
    @Autowired
    IUserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping
    public ModelAndView signupUser() {
        ModelAndView model=new ModelAndView();
        model.setViewName("signinup");
        model.addObject("dto", new UserEntityDto());
        return model;
    }

    @PostMapping
    public String signUp(@ModelAttribute UserEntityDto dto, Model model, HttpServletRequest http){
        try {
            model.addAttribute("dto", dto);
            UserEntityDto dtoNew = userService.createUser(dto);
            authWithAuthManager(http, dto.getName(), dtoNew.getPassword());
        } catch (Exception e) {
            return "/403";
        }
        return "signupres";
    }
    private void authWithAuthManager(HttpServletRequest request, String username, String password) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));

        Authentication authentication = authenticationManager.authenticate(authToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
