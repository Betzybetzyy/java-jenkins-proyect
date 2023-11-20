/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.user.repository;

import com.mycompany.login.connection.MySqlDbConnection;
import com.mycompany.login.user.model.UserEntity;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico_
 */
public class UserRepository implements IUserRepository {
    
    private final static String QUERY_LOGIN = "SELECT rut, username, password FROM user WHERE username = ? AND password = ?";

    @Override
    public UserEntity getByLogin(String username, String password) throws SQLException {
        UserEntity response = null;
        try (MySqlDbConnection db = MySqlDbConnection.getInstance();
             PreparedStatement stmt = db.getConnection().prepareStatement(QUERY_LOGIN)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    response = new UserEntity();
                    response.setRut(result.getString("rut"));
                    response.setUsername(result.getString("username"));
                    response.setPassword(result.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
