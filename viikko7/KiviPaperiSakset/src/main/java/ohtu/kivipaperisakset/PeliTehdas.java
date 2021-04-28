
package ohtu.kivipaperisakset;

import java.util.HashMap;

public class PeliTehdas {
    private HashMap<String, KiviPaperiSakset> peliTyypit;
   
    public PeliTehdas() {
        peliTyypit = new HashMap<String, KiviPaperiSakset>();
        peliTyypit.put("a", new KPSPelaajaVsPelaaja());
        peliTyypit.put("b", new KPSTekoaly());
        peliTyypit.put("c", new KPSParempiTekoaly());

    }
    
    public KiviPaperiSakset haePeli(String peliTyyppi) {
        return peliTyypit.get(peliTyyppi);
    }
    
}
