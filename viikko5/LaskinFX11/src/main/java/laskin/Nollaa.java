package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    private int vanhaArvo;
    
    public Nollaa (TextField tulosk, TextField syotek, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tulosk, syotek, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {

        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
            this.vanhaArvo = Integer.parseInt(tuloskentta.getText());      
        } catch (Exception e) {
        }

        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);        
    }
    
    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + vanhaArvo);   
    }
    
}
