
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    
    public Komento(TextField tulosk, TextField syotek, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tulosk;
        this.syotekentta = syotek;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    
    public abstract void suorita();
    public abstract void peru();
}

