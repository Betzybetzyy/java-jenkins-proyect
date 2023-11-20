/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.login.servlet;

import com.mycompany.login.user.model.UserEntity;
import com.mycompany.login.user.repository.UserRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nico_
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;

    public LoginServlet() {
        this.userRepository = new UserRepository();
    }

    // Constructor para pruebas
    public LoginServlet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRepository userRepositoryDoPost = new UserRepository();

        UserEntity userEntity = null;
        try {
            userEntity = userRepositoryDoPost.getByLogin(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (userEntity == null || userEntity.getUsername() == null) {
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("/").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", userEntity);
        response.sendRedirect("home.jsp");
    }
}
