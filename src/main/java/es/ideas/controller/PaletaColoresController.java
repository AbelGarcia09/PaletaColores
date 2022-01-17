package es.ideas.controller;

import es.ideas.model.Rgb;
import es.ideas.utils.DatosRgb;
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
public class PaletaColoresController implements javafx.fxml.Initializable {

    @javafx.fxml.FXML
    private javafx.scene.control.Slider sliderRojo;
    @javafx.fxml.FXML
    private javafx.scene.control.Slider sliderVerde;
    @javafx.fxml.FXML
    private javafx.scene.control.Slider sliderAzul;
    @javafx.fxml.FXML
    private javafx.scene.shape.Circle circulo;
    @javafx.fxml.FXML
    private javafx.scene.control.Label textoRojo;
    @javafx.fxml.FXML
    private javafx.scene.control.Label textoVerde;
    @javafx.fxml.FXML
    private javafx.scene.control.Label textoAzul;
    @javafx.fxml.FXML
    private javafx.scene.text.Text hexColor;
    @javafx.fxml.FXML
    private javafx.scene.control.Button boton;
    @javafx.fxml.FXML
    private javafx.scene.control.ListView<Rgb> lista;
    private DatosRgb datos = new DatosRgb();
    private javafx.collections.ObservableList<Rgb> listaRgb = datos.getDatosRgb();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cambiaColor();
        
        boton.disableProperty().bind(lista.getSelectionModel().selectedItemProperty().isNotNull());
                
    }

    private void cambiaColor() {
        lista.setItems(listaRgb);
        
        sliderRojo.valueProperty().addListener(new javafx.beans.value.ChangeListener<Number>() {
            @Override
            public void changed(javafx.beans.value.ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoRojo.setText("Rojo: " + (int) sliderRojo.getValue());
                codigoHex();
            } 
        });
        
        sliderVerde.valueProperty().addListener(new javafx.beans.value.ChangeListener<Number>() {
            @Override
            public void changed(javafx.beans.value.ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoVerde.setText("Verde: " + (int) sliderVerde.getValue());
                codigoHex();
            } 
        });
        
        sliderAzul.valueProperty().addListener(new javafx.beans.value.ChangeListener<Number>() {
            @Override
            public void changed(javafx.beans.value.ObservableValue<? extends Number> ov, Number t, Number t1) {
                circulo.setFill(creaColor());
                textoAzul.setText("Azul: " + (int) sliderAzul.getValue());
                codigoHex();
            } 
        });
    }
    
    private javafx.scene.paint.Color creaColor() {
        int rojo = (int) sliderRojo.getValue();
        int verde = (int) sliderVerde.getValue();
        int azul = (int) sliderAzul.getValue();
        
        javafx.scene.paint.Color color = javafx.scene.paint.Color.rgb(rojo, verde, azul);
        
        return color;
    }
    
    private void codigoHex() {
        hexColor.setText(String.format("#%02X%02X%02X", 
                        (int) sliderRojo.getValue(),
                        (int) sliderVerde.getValue(),
                        (int) sliderAzul.getValue()));
    }

    @javafx.fxml.FXML
    private void accionNuevo(javafx.event.ActionEvent event) {
        Rgb rgb = new Rgb((int) sliderRojo.getValue(), 
                (int) sliderVerde.getValue(), 
                (int) sliderAzul.getValue(),
                hexColor.getText());
        
        listaRgb.add(rgb);
        lista.getSelectionModel().select(rgb);
    }

}
