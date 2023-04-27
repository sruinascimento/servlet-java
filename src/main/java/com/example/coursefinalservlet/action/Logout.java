package com.example.coursefinalservlet.action;

import com.example.coursefinalservlet.model.ActionServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements ActionServlet {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
//        session.removeAttribute("usuarioLogado");
        session.invalidate();
        return "redirect:root?acao=LoginForm";
    }
}
