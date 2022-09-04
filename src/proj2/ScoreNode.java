
package proj2;

/**
 *
 * @author rafiul
 */
public class ScoreNode {
    private String name;
    private int score;
    private ScoreNode next ;
    
    
    
    
    public ScoreNode(String name, int score, ScoreNode next) {
        this.name = name;
        this.score = score;
        this.next = next;
    }//endctor

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public ScoreNode getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNext(ScoreNode next) {
        this.next = next;
    }

    
    
}// end cl1ass