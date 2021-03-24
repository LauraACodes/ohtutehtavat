
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int mitenPaljonJoukkoaKasvatetaan;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukonLuvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int joukonLukujenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukonLuvut = new int[KAPASITEETTI];
        alustaLukutaulukko();
        this.mitenPaljonJoukkoaKasvatetaan = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        joukonLuvut = new int[kapasiteetti];
        alustaLukutaulukko();
        this.mitenPaljonJoukkoaKasvatetaan = OLETUSKASVATUS;

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasititeetin oltava positiivinen");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasiteettia voi vain kasvattaa, luvun oltava positiivinen");//heitin vaan jotain :D
        }
        joukonLuvut = new int[kapasiteetti];
        alustaLukutaulukko();
        this.mitenPaljonJoukkoaKasvatetaan = kasvatuskoko;

    }
    
    public void alustaLukutaulukko() {
        for (int i = 0; i < joukonLuvut.length; i++) {
            joukonLuvut[i] = 0;
        }
        joukonLukujenLkm = 0;        
    }
    
    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            joukonLuvut[joukonLukujenLkm] = luku;
            joukonLukujenLkm++;
            if (joukonLukujenLkm == joukonLuvut.length ) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }
    
    public void kasvataTaulukkoa() {
        int[] taulukkoOld = new int[joukonLuvut.length];
        taulukkoOld = joukonLuvut;
        joukonLuvut = new int[joukonLukujenLkm + mitenPaljonJoukkoaKasvatetaan];
        kopioiTaulukko(taulukkoOld, joukonLuvut);     
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }
    
    public boolean kuuluu(int luku) {
        
        for (int i = 0; i < joukonLukujenLkm; i++) {
            if (luku == joukonLuvut[i]) {
                return true;
            }
        }
        
        return false;
        
    }

    public boolean poista(int luku) {
        
        for (int i = 0; i < joukonLukujenLkm; i++) {
            if (luku == joukonLuvut[i]) {
                int poistettavanIndeksi = i; 
                joukonLuvut[poistettavanIndeksi] = 0;
                
                for (int j = poistettavanIndeksi; j < joukonLukujenLkm - 1; j++) {
                    joukonLuvut[j] = joukonLuvut[j + 1];
                }   
                
                joukonLukujenLkm--;
                return true;
            }
        }
       
        return false;
    }



    public int getJoukonLukujenLkm() {
        return joukonLukujenLkm;
    }


    @Override
    public String toString() {
        if (joukonLukujenLkm == 0) {
            return "{}";
        } 
        String tuotos = "{";
        for (int i = 0; i < joukonLukujenLkm - 1; i++) {
            tuotos += joukonLuvut[i];
            tuotos += ", ";
        }
        tuotos += joukonLuvut[joukonLukujenLkm - 1];
        tuotos += "}";
        return tuotos;
        
    }

    public int[] joukonLuvutUuteenTaulukkoon() {
        int[] taulu = new int[joukonLukujenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukonLuvut[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();

        for (int i = 0; i < a.joukonLukujenLkm; i++) {
            yhdisteJoukko.lisaa(a.joukonLuvut[i]);
        }
        for (int i = 0; i < b.joukonLukujenLkm; i++) {
            yhdisteJoukko.lisaa(b.joukonLuvut[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        
        for (int i = 0; i < a.joukonLukujenLkm; i++) {
            for (int j = 0; j < b.joukonLukujenLkm; j++) {
                if (a.joukonLuvut[i] == b.joukonLuvut[j]) {
                    leikkausJoukko.lisaa(a.joukonLuvut[i]);
                }
            }
        }

        return leikkausJoukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        
        for (int i = 0; i < a.joukonLukujenLkm; i++) {
            erotusJoukko.lisaa(a.joukonLuvut[i]);
        }
        for (int i = 0; i < b.joukonLukujenLkm; i++) {
            if (a.kuuluu(b.joukonLuvut[i]))
            erotusJoukko.poista(b.joukonLuvut[i]);
        }
 
        return erotusJoukko;
    }
        
}
