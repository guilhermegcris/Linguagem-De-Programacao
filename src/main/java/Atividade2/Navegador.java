package Atividade2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegador {

    public static void trocarTela(Stage stage, String nomeFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Executavel.class.getResource("/Telas/" + nomeFXML)
            );

            Scene cena = new Scene(loader.load());
            stage.setScene(cena);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar tela: " + nomeFXML);
        }
    }
}
