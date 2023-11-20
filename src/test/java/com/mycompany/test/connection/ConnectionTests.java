/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.test.connection;

import com.mycompany.login.connection.MySqlDbConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTests {

    private MySqlDbConnection dbConnection;

    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        dbConnection = MySqlDbConnection.getInstance();
    }

    @AfterEach
    public void tearDown() throws Exception {
        dbConnection.close();
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        Connection conn = dbConnection.getConnection();
        assertTrue(conn.isValid(1), "Connection should be valid");
    }

    @Test
    public void testCanExecuteQuery() throws SQLException {
        ResultSet rs = dbConnection.executeQuery("SELECT 1");
        assertNotNull(rs, "ResultSet should not be null");

        rs.close();
    }

    @Test
    public void testSingletonInstance() throws SQLException, ClassNotFoundException {
        MySqlDbConnection anotherDbConnection = MySqlDbConnection.getInstance();
        assertSame(dbConnection, anotherDbConnection, "Instances should be the same");
    }
}