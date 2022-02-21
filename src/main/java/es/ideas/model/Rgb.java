package es.ideas.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Abel & Narciso
 */
public class Rgb {
    //Guarda el valor del slider rojo
    private final IntegerProperty red = new SimpleIntegerProperty(this, "red", 0);
    //Valor del slider verde
    private final IntegerProperty green = new SimpleIntegerProperty(this, "green", 0);
    //Valor del slider azul
    private final IntegerProperty blue = new SimpleIntegerProperty(this, "blue", 0);
    //Código hexadecimal
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
        return hex.getValue();
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
        //Se sobreescribe el método toString() para que escriba en la lista lo que queramos.
        return "RGB: " + red.get() + " " + green.get() + " " + blue.get() + " - HEX: " + hex.get();
    }
}
