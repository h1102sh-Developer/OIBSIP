
public class NumberGuess // main class
{
    public static void main(String[] args) {

        play g = new play();    //invoking the play class 
        boolean b = false;      
        // decision making of while   
        while (!b) {              // checks the !b=value or not
            g.takeUserInput();
            b = g.isCorrectNum();  // object create
        }
    }
}
