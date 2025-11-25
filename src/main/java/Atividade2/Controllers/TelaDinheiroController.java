package Atividade2.Controllers;

import Atividade2.Executavel;
import Atividade2.Navegador;

import Atividade2.Database.DinheiroDAO;
import Atividade2.Models.Dinheiro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaDinheiroController {

    @FXML private TextField txtSalario;
    @FXML private TextField txtPoderAquisitivo;
    @FXML private TextField txtMoeda;
    @FXML private Label mensagemLabel;

    @FXML
    public void initialize() {
        mensagemLabel.setText("");
    }

    @FXML
    private void onVoltar() {
        Navegador.trocarTela(Executavel.janela, "TelaPrincipal.fxml");
    }

    @FXML
    private void onSalvar() {

        mensagemLabel.setStyle("-fx-text-fill: red;");

        String salarioTxt = txtSalario.getText().trim();
        String poder = txtPoderAquisitivo.getText().trim();
        String moeda = txtMoeda.getText().trim();

        double salario;

        try {
            salario = Double.parseDouble(salarioTxt);
            if (salario < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            mensagemLabel.setText("Salário inválido.");
            return;
        }

        if (poder.isEmpty()) {
            mensagemLabel.setText("Informe o poder aquisitivo.");
            return;
        }

        if (moeda.isEmpty()) {
            mensagemLabel.setText("Informe a moeda.");
            return;
        }

        Dinheiro dinheiro = new Dinheiro(salario, poder, moeda);

        if (DinheiroDAO.salvar(dinheiro)) {
            mensagemLabel.setStyle("-fx-text-fill: green;");
            mensagemLabel.setText("Dados salvos com sucesso!");
        } else {
            mensagemLabel.setText("Erro ao salvar no banco.");
        }
    }
}
