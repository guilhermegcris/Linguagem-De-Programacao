package Atividade2.Database;

import Atividade2.Models.Povo;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PovoDAO {

    public static boolean inserir(Povo povo) {
        String sql = "INSERT INTO povo (nome, origem, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, povo.getNome());
            stmt.setString(2, povo.getOrigem());
            stmt.setInt(3, povo.getQuantidade());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir povo: " + e.getMessage());
            return false;
        }
    }
}
