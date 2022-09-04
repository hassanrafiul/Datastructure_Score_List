
package proj2;
/**
 *
 * @author rafiul
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ScoreDemo {
    
    public static void main(String[] args) {
       
        System.out.println("****************Welcome to the Score Board List!!!!**************");
                
        ScoreList list = new ScoreList();
        
        Scanner scanScore = new Scanner(System.in);
        
        
        try{
            File Scores = new File("scores.txt");
            
            Scanner score = new Scanner(Scores);    
            
            while(score.hasNextLine()){
                
                String scoreInfo = score.nextLine();                
                String[] arrayInfo = scoreInfo.split(" ");
                list.add(arrayInfo[0],Integer.parseInt(arrayInfo[1]));
                
            }
            
            score.close();
            list.print();
             
        } catch (FileNotFoundException e )  {
            System.out.println(" Error Input not recognised");
            
        }
        boolean scoreInfoStatement = true;
        
        while(scoreInfoStatement) {
            String saveScoreLine = "";
            
            System.out.println("Would you like to add another (1), remove (2), or quit the program (3)? ");
            
            int ScoreInfoChoice = scanScore.nextInt();
            
            if (ScoreInfoChoice == 1){
                System.out.println("Write the name followed by score: ");
                scanScore.nextLine();
                saveScoreLine = scanScore.nextLine();
                String[] scoreInfoScore = saveScoreLine.split(" ");
                list.add(scoreInfoScore[0],Integer.parseInt(scoreInfoScore[1]));
                 list.print();
                
            } else if (ScoreInfoChoice == 2){
                System.out.println("Write the name of the person you'd like to remove: ");
                scanScore.nextLine();
                String saveLine2 = scanScore.nextLine();
                list.remove(saveLine2);
                 list.print();
                
            } else if (ScoreInfoChoice == 3) {
                System.out.println("Thank you for using the program! Good Bye!");
                scoreInfoStatement=false;
            }
            
        }

        scanScore.close();
    }
    
}