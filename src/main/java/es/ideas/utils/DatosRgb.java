package es.ideas.utils;

import es.ideas.model.Rgb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abel & Narciso
 */
public class DatosRgb {
    private ObservableList<Rgb> listaRGB = FXCollections.observableArrayList(Rgb.extractor);
    
    public DatosRgb() {
        
    }
    

    public ObservableList<Rgb> getDatosRgb(){
        return listaRGB;
    }
}
