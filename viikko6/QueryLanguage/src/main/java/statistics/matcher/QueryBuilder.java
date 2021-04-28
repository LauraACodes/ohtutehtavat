
package statistics.matcher;


public class QueryBuilder {
    private Matcher matcher;
   
    public QueryBuilder(){   
        this.matcher = new All();
    }
    
    public void luoMatchers(Matcher uusi){
        this.matcher = new And(matcher, uusi);        
    }
    
    public Matcher build(){
        return this.matcher;
    }
    
    public QueryBuilder oneOf(Matcher...matchers){
        this.matcher = new Or(matchers);
        return this;
    }
        
    public QueryBuilder playsIn(String team) {
        luoMatchers(new PlaysIn(team));
        return this;
    } 
    
    public QueryBuilder hasAtLeast(int nr, String what) {
        luoMatchers(new HasAtLeast(nr, what));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int nr, String what) {
        luoMatchers(new HasFewerThan(nr, what));
        return this;
    }
}
