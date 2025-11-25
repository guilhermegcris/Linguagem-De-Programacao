package Atividade2.Database;

import Atividade2.Models.Dinheiro;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DinheiroDAO {

    public static boolean salvar(Dinheiro dinheiro) {
        String sql = "INSERT INTO dinheiro (salario, poder_aquisitivo, moeda) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, dinheiro.getSalario());
            stmt.setString(2, dinheiro.getPoderAquisitivo());
            stmt.setString(3, dinheiro.getMoeda());

            stmt.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao inserir Dinheiro: " + ex.getMessage());
            return false;
        }
    }
}
