package ohtu.verkkokauppa;

public class Pankki implements PankkiIO {

    public KirjanpitoIO kirjanpito;

    public Pankki(KirjanpitoIO kirjanpitoIO) {
        kirjanpito = kirjanpitoIO;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
