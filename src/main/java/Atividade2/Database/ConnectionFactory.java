package Atividade2.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/ativ2?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "ativ2";
    private static final String PASSWORD = "pass123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao MySQL: " + e.getMessage());
        }
    }
}
