package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene escena;

        escena = new Scene(FXMLLoader.load(App.class.getResource("view/PaletaColoresFXML.fxml")));

        stage.setScene(escena);
        stage.setTitle("Paleta de colores");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}