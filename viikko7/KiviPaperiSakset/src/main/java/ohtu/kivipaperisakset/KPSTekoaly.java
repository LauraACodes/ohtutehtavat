package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {
  
    @Override
    protected String toisenSiirto() {
        Tekoaly tekoaly = new Tekoaly();        
        String tokanSiirto = tekoaly.annaSiirto();
        return ("Tietokone valitsi: " + tokanSiirto);          
    }

}