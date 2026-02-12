/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.dao;

import java.sql.*;

/**
 *
 * @author svitorz
 */
public class ConexaoDAO {
    public static Connection conn = null;
    
    public ConexaoDAO(){}
    
    public static void ConnectDB() {
        try {
            String dsn = "projeto_1", user = "postgres", password = "postdba";

            DriverManager.registerDriver(new org,postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;

            conn = DriverManager.getConnection(url, user, password);

            conn.setAutoCommit(false);

            if(conn == null) {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        }
        catch (Exception e) {
            System.out.println("Problema ao abrir base de dados:" + e.getMessage());
        }
    }
    
    public static void closeDB() {
        try {
            conn.close();
        } catch (Exception e) {
             System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
