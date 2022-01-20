package es.ideas.model;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 *
 * @author Abel & Narciso
 */
public class Rgb {
    private ObservableList<Rgb> listaRGB = FXCollections.observableArrayList(Rgb.extractor);
    private final IntegerProperty red = new SimpleIntegerProperty(this, "red", 0);
    private final IntegerProperty green = new SimpleIntegerProperty(this, "green", 0);
    private final IntegerProperty blue = new SimpleIntegerProperty(this, "blue", 0);
    private final StringProperty hex = new SimpleStringProperty(this, "hex", "");
    
    public Rgb() {
        
    }
    
    public Rgb(int red, int green, int blue, String hex) {
        this.red.set(red);
        this.green.set(green);
        this.blue.set(blue);
        this.hex.set(hex);
    }

    public int getRed() {
        return red.getValue();
    }
    
    public int getGreen() {
        return green.getValue();
    }
    
    public int getBlue() {
        return blue.getValue();
    }
    
    public String getHex() {
        return hex.toString();
    }
    
    public IntegerProperty redProperty() {
        return red;
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public IntegerProperty blueProperty() {
        return blue;
    }
    
    public StringProperty hexProperty() {
        return hex;
    }
    
    public void setRed(int nuevoValor) {
        this.red.setValue(nuevoValor);
    }
    
    public void setGreen(int nuevoValor) {
        this.green.setValue(nuevoValor);
    }
    
    public void setBlue(int nuevoValor) {
        this.blue.setValue(nuevoValor);
    }
    
    public void setHex(String nuevoValor) {
        this.hex.setValue(nuevoValor);
    }
    
    @Override
    public String toString() {
        return "RGB: " + red.get() + " " + green.get() + " " + blue.get() + " - HEX: " + hex.get();
    }
    
    public static Callback<Rgb, Observable[]> extractor =
            p-> new Observable[]{
                p.redProperty(),p.greenProperty(),p.blueProperty(),p.hexProperty()
            };

    public ObservableList<Rgb> getRgb() {
        
        return listaRGB;
    }
}
