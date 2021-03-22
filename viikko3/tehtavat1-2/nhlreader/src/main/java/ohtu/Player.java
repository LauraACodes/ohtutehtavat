
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;
    private int points;

    public String getName() {
        return name;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void countPoints() {
        this.points = goals + assists;
        
    }
    @Override
    public String toString() {
        return name + ", " + team + ", " + goals + " + " + assists + " = " + points;
    }

    @Override
    public int compareTo(Player player) {
        return player.points - this.points;
    }
      
}
