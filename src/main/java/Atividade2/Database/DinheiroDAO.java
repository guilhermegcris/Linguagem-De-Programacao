package Atividade2.DAO;

import Atividade2.Database.ConnectionFactory;
import Atividade2.Models.Dinheiro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DinheiroDAO {

    public static boolean salvar(Dinheiro d) {
        String sql = "INSERT INTO dinheiro (salario, poder_aquisitivo, moeda) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, d.getSalario());
            stmt.setString(2, d.getPoderAquisitivo());
            stmt.setString(3, d.getMoeda());

            stmt.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
