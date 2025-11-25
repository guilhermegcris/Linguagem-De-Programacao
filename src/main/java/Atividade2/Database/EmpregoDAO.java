package Atividade2.Database;

import Atividade2.Models.Emprego;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpregoDAO {

    public static boolean salvar(Emprego emprego) {
        String sql = "INSERT INTO emprego (empresa, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emprego.getEmpresa());
            stmt.setString(2, emprego.getCargo());
            stmt.setDouble(3, emprego.getSalario());

            stmt.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
