package Atividade2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Executavel extends Application {

    public static Stage janela;

    @Override
    public void start(Stage stage) throws Exception {
        janela = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Executavel.class.getResource("/Telas/TelaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Menu Principal");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
