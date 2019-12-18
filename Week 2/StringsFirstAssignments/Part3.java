
/**
 * Part3 of the Finding a Gene in DNA module of Java Programming:
 * Solving Problems with Software through Coursera
 * 
 * @author Zachary Carter
 * @version 20191217
 */
public class Part3 {
    public boolean twoOccurances(String stringa, String stringb) {
        // Return True if String stringa appears at least twice in String stringb.
        
        // Check first occurance
        int startIndex = stringb.indexOf(stringa);
        if (startIndex != -1){
            // Check second occurance
            if (stringb.indexOf(stringa, startIndex + stringa.length()) != -1) {
                return true;
            }
        }
        
        // Return false if either previous condition fails. 
        return false;
    
    }
    
    public void testingHelper(String stringa, String stringb){
        System.out.println("Input strings: " + stringa + " and " + stringb)
        print
    }
    
    public void testing() {
        System
    }
}
