
package proj2;
/**
 *
 * @author rafiul
 */

public class ScoreList {  
    private ScoreNode firstNode;
    
    
    public ScoreList(){
        firstNode = null;
    }
    
    public ScoreList (ScoreList other) {        
        ScoreNode walker = other.firstNode;
        
        while (walker != null){            
            add(walker.getName(), walker.getScore());           
            walker = walker.getNext();          
        } 
    }
    
    public void add(String name, int score) {
        //check name already exist
        ScoreNode temp = firstNode;
        while (temp != null) {
            if (temp.getName().equalsIgnoreCase(name)) {
                remove(name);
            }
            temp = temp.getNext();
        }
        
        //sort and the new node
         ScoreNode newNode = new ScoreNode(name, score , null);

         if (firstNode == null) {
            firstNode = newNode;
        } else {
            ScoreNode ptr = firstNode;
            while (ptr.getNext() != null && ptr.getNext().getScore() > newNode.getScore()) {
                ptr = ptr.getNext();
            }
            if (ptr == firstNode && ptr.getScore() < newNode.getScore()) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                newNode.setNext(ptr.getNext());
                ptr.setNext(newNode);
            }
        }
    }
    
    public void remove(String name){  
        ScoreNode temp = firstNode, prev = null;

        if (temp != null && temp.getName().equalsIgnoreCase(name)) {
            firstNode = temp.getNext();
            return;
        }

        while (temp != null && !temp.getName().equalsIgnoreCase(name)) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            System.out.println("\nName not found!");
            return;
        }

        prev.setNext(temp.getNext());
      
    }//end remove
    
    
    public void print(){
      System.out.println("\n******The list below are the following members: *******");
        ScoreNode walker = firstNode;
        while (walker != null) {
            System.out.println(walker.getName() + " has a score of " + walker.getScore() + " in the Score List.");
             walker = walker.getNext();
        }//end print
        System.out.println();
    }

}
