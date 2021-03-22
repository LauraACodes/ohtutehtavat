
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;

    // Setterit
    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
 
    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }    

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }   

    public void setTeam(String team) {
        this.team = team;
    }

    public void setGames(int games) {
        this.games = games;
    }  
    */
    // Getterit
    public String getName() {
        return name;
    }
    
    public String getNationality() {
        return nationality;
    }
    /*
    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }    

    public int getPenalties() {
        return penalties;
    }    

    public String getTeam() {
        return team;
    }    
    
    public int getGames() {
        return games;
    }    
    */
    @Override
    public String toString() {
        return name + ", team: " + team + ", goals: " + goals + ", assists: " + assists;
    }
      
}
