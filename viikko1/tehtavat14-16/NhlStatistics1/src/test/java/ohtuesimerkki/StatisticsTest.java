
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  

    @Test
    public void lisattyPelaajaLoytyy() {
        assertNotNull(stats.search("Kurri"));
    }

    @Test
    public void eiLisattyaPelaajaEiLoydy() {
        assertNull(stats.search("Ankka"));
    } 
    
    @Test
    public void lisattyPelaajanNimiTasmaa() {
        Player pelaaja = stats.search("Kurri");
        assertEquals("Kurri", pelaaja.getName());
    }
    
    @Test
    public void lisattyPelaajanSeuraTasmaa() {
        Player pelaaja = stats.search("Yzerman");
        assertEquals("DET", pelaaja.getTeam());
    }
    
    @Test
    public void tiiminPelaajatLoytyyJaMaaraTasmaa() {
        List<Player> pelaajat = stats.team("EDM");
        assertEquals(3, pelaajat.size());
    }
    
    @Test
    public void olemattomanTiiminPelaajalistaTyhja() {
        List<Player> pelaajat = stats.team("Ankkalandia");
        assertEquals(0, pelaajat.size());
    }
    
    @Test
    public void josEtsiiYhtaHuipputulostaSaaYhdenHuipputuloksen() {
        List<Player> pelaajat = stats.topScorers(0);
        assertEquals(1, pelaajat.size());
    }
    
    @Test
    public void josEtsiiYhtaHuippuaLoytaaGretszkyn() {
        List<Player> pelaajat = stats.topScorers(0);
        assertEquals("Gretzky", pelaajat.get(0).getName());
    }
}
