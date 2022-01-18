package es.ideas.model;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Callback;

/**
 *
 * @author Abel & Narciso
 */
public class Rgb {
    private final SimpleIntegerProperty red = new SimpleIntegerProperty(this, "red", 0);
    private final SimpleIntegerProperty green = new SimpleIntegerProperty(this, "green", 0);
    private final SimpleIntegerProperty blue = new SimpleIntegerProperty(this, "blue", 0);
    private final SimpleStringProperty hex = new SimpleStringProperty(this, "hex", "");
    
    public Rgb() {
        
    }
    
    public Rgb(int red, int green, int blue, String hex) {
        this.red.set(red);
        this.green.set(green);
        this.blue.set(blue);
        this.hex.set(hex);
    }

    
    public SimpleIntegerProperty getRed() {
        return red;
    }

    public SimpleIntegerProperty getGreen() {
        return green;
    }

    public SimpleIntegerProperty getBlue() {
        return blue;
    }
    
    public SimpleStringProperty getHex() {
        return hex;
    }
    
    @Override
    public String toString() {
        return "RGB: " + red.get() + " " + green.get() + " " + blue.get() + " - HEX: " + hex.get();
    }
    
    public static Callback<Rgb, Observable[]> extractor =
            p-> new Observable[]{
                p.getRed(),p.getGreen(),p.getBlue(),p.getHex()
            };
}
