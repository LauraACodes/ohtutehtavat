package ohtu.kivipaperisakset;

import java.util.Scanner;


public abstract class KiviPaperiSakset {
    
    private static final Scanner scanner = new Scanner(System.in);

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto = ensimaisenSiirto();
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            
            System.out.println(tuomari);
            System.out.println();
                     
            ekanSiirto = ensimaisenSiirto();
            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();  
        
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    
    protected String ensimaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    abstract protected String toisenSiirto();

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}    

