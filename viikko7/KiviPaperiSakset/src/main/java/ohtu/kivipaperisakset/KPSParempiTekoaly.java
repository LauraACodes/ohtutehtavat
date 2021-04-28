package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KiviPaperiSakset{

  
    @Override
    protected String toisenSiirto() {
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        
        String tokanSiirto = tekoaly.annaSiirto();
        return ("Tietokone valitsi: " + tokanSiirto);          
    }

}
