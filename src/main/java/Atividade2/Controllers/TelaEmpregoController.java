package Atividade2.Controllers;

import Atividade2.Executavel;
import Atividade2.Navegador;
import Atividade2.Database.EmpregoDAO;
import Atividade2.Models.Emprego;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaEmpregoController {

    @FXML
    private TextField txtEmpresa;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtSalario;

    @FXML
    private Label mensagemLabel;

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

        String empresa = txtEmpresa.getText().trim();
        String cargo = txtCargo.getText().trim();
        String salarioText = txtSalario.getText().trim();

        if (empresa.isEmpty()) {
            mensagemLabel.setText("Informe a empresa.");
            return;
        }

        if (cargo.isEmpty()) {
            mensagemLabel.setText("Informe o cargo.");
            return;
        }

        double salario;
        try {
            salario = Double.parseDouble(salarioText);
            if (salario < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            mensagemLabel.setText("Salário inválido.");
            return;
        }

        Emprego emp = new Emprego(empresa, cargo, salario);

        if (EmpregoDAO.salvar(emp)) {
            mensagemLabel.setStyle("-fx-text-fill: green;");
            mensagemLabel.setText("Dados salvos com sucesso!");
        } else {
            mensagemLabel.setText("Erro ao salvar no banco.");
        }
    }
}
