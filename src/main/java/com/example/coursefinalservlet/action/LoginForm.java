package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.model.ActionServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "forward:login-usuario.jsp";
    }
}
