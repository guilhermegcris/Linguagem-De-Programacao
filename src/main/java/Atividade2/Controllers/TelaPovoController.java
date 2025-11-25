package Atividade2.Controllers;

import Atividade2.Database.PovoDAO;
import Atividade2.Models.Povo;
import Atividade2.Executavel;
import Atividade2.Navegador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaPovoController {

    @FXML private TextField nomeField;
    @FXML private TextField origemField;
    @FXML private TextField qtdField;
    @FXML private Label mensagemLabel;

    @FXML
    private void initialize() {
        mensagemLabel.setText("");
    }

    @FXML
    private void onVoltar() {
        Navegador.trocarTela(Executavel.janela, "TelaPrincipal.fxml");
    }

    @FXML
    private void onSalvar() {
        mensagemLabel.setStyle("-fx-text-fill: red;");

        String nome = nomeField.getText().trim();
        String origem = origemField.getText().trim();
        String qtdText = qtdField.getText().trim();

        if (nome.isEmpty()) { mensagemLabel.setText("Informe o nome."); return; }
        if (origem.isEmpty()) { mensagemLabel.setText("Informe a origem."); return; }

        int quantidade;
        try {
            quantidade = Integer.parseInt(qtdText);
            if (quantidade < 0) throw new NumberFormatException();
        } catch (Exception e) {
            mensagemLabel.setText("Quantidade inválida.");
            return;
        }

        // Criar objeto
        Povo povo = new Povo(nome, origem, quantidade);

        // Salvar no banco
        boolean sucesso = PovoDAO.inserir(povo);

        if (sucesso) {
            mensagemLabel.setStyle("-fx-text-fill: green;");
            mensagemLabel.setText("Registro salvo com sucesso!");

            nomeField.clear();
            origemField.clear();
            qtdField.clear();

        } else {
            mensagemLabel.setText("Erro ao salvar no banco.");
        }
    }
}
