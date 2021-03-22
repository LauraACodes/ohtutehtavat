
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {
    
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        List<Player> playerList = new ArrayList<>();
        
        for (Player player : players) {
            player.countPoints();
            
            if (player.getNationality().equals("FIN")) {
                playerList.add(player);
            }
        }
        
        playerList.stream().sorted().forEach(p -> System.out.println(p));

    }
}
