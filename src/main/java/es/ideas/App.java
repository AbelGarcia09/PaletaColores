package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase App es la clase principal que se encarga de cargar la vista
 *
 * @since 1.0
 * @author Abel y Narciso
 * @see <a href="https://github.com/AbelGarcia09">Github Abel</a>
 * @see <a href="https://github.com/NarcisoDAM">Github Narciso</a>
 * @see <a href="https://github.com/AbelGarcia09/PaletaColores">PaletaColores</a>
 */
public class App extends Application {

    /**
     * Carga la escena de la vista, añade un título, y le aplica tamaño fijo.
     * @param stage
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        Scene escena;
        
        //Se carga la escena creada con Scene Builder.
        escena = new Scene(FXMLLoader.load(App.class.getResource("view/PaletaColoresFXML.fxml")));

        stage.setScene(escena);
        stage.setTitle("Paleta de colores");
        
        //Tamaño fijo
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Contiene un launch() heredado de Application que inicia la aplicación.
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}