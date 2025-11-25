package Atividade2.Controllers;

import Atividade2.Executavel;
import Atividade2.Navegador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPrincipalController {

    @FXML
    private Button btnPovo;

    @FXML
    private Button btnEmprego;

    @FXML
    private Button btnDinheiro;

    @FXML
    public void initialize() {
    }

    @FXML
    private void onPovoClick() {
        Navegador.trocarTela(Executavel.janela, "TelaPovo.fxml");
    }

    @FXML
    private void onEmpregoClick() {
        Navegador.trocarTela(Executavel.janela, "TelaEmprego.fxml");
    }

    @FXML
    private void onDinheiroClick() {
        Navegador.trocarTela(Executavel.janela, "TelaDinheiro.fxml");
    }
}
