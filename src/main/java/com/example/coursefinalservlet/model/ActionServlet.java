package com.example.coursefinalservlet.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionServlet {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
