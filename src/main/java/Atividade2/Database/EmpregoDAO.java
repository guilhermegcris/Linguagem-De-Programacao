package Atividade2.DAO;

import Atividade2.Models.Emprego;
import Atividade2.Database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpregoDAO {

    public static boolean salvar(Emprego e) {
        String sql = "INSERT INTO emprego (empresa, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, e.getEmpresa());
            stmt.setString(2, e.getCargo());
            stmt.setDouble(3, e.getSalario());

            stmt.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
