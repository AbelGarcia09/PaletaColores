package es.ideas.controller;

import es.ideas.model.Rgb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *
 * @author Abel & Narciso
 */
public class PaletaColoresController implements Initializable {

    @FXML
    private Slider sliderRojo;
    @FXML
    private Slider sliderVerde;
    @FXML
    private Slider sliderAzul;
    @FXML
    private Circle circulo;
    @FXML
    private Label textoRojo;
    @FXML
    private Label textoVerde;
    @FXML
    private Label textoAzul;
    @FXML
    private Text hexColor;
    @FXML
    private Button boton;
    @FXML
    private ListView<Rgb> lista;
    private Rgb datos = new Rgb();
    private ObservableList<Rgb> listaRgb = datos.getRgb();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cambiaColor();
        
        boton.disableProperty().bind(lista.getSelectionModel().selectedItemProperty().isNotNull());
                
    }

    private void cambiaColor() {
        lista.setItems(listaRgb);
        
        sliderRojo.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoRojo.setText("Rojo: " + (int) sliderRojo.getValue());
                codigoHex();
            } 
        });
        
        sliderVerde.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoVerde.setText("Verde: " + (int) sliderVerde.getValue());
                codigoHex();
            } 
        });
        
        sliderAzul.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoAzul.setText("Azul: " + (int) sliderAzul.getValue());
                codigoHex();
            } 
        });
    }
    
    private Color creaColor() {
        int rojo = (int) sliderRojo.getValue();
        int verde = (int) sliderVerde.getValue();
        int azul = (int) sliderAzul.getValue();
        
        Color color = Color.rgb(rojo, verde, azul);
        
        return color;
    }
    
    private void codigoHex() {
        hexColor.setText(String.format("#%02X%02X%02X", 
                        (int) sliderRojo.getValue(),
                        (int) sliderVerde.getValue(),
                        (int) sliderAzul.getValue()));
    }

    @FXML
    private void accionNuevo(ActionEvent event) {
        Rgb rgb = new Rgb((int) sliderRojo.getValue(), 
                (int) sliderVerde.getValue(), 
                (int) sliderAzul.getValue(),
                hexColor.getText());
        
        listaRgb.add(rgb);
    }

}

