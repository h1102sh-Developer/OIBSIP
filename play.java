import java.util.Scanner; // here we take the scanner class to take user input

import java.util.Random;  //  here we take random class in which random no. generate as high     
// now class play takes with public access modifier
public class play {    
    // initialized variables         
     int num , a ;    
     public int guessesno = 0; // guessesno=0  because user no. start with more then -1
    
    public int getguessesno() //get method
    {
        return guessesno;
    }

    public void setGuessesno(int Guessesno) //set method with one parameter
    {
        this.guessesno = Guessesno; //reference variable or instance variable
    }
     play()
    {
        // invoking the random class
        Random rand = new Random(); 
        this.num= rand.nextInt(100); //reference variable with define varibale of oject
    }
        void takeUserInput(){
        System.out.println("lets Guess a number"); //printing function
        Scanner sc = new Scanner(System.in);           // taking user input
        a = sc.nextInt();
    }
    boolean isCorrectNum() //boolean operators
    {
        guessesno++;
        // conditional statement if and elseif
        if (a==num){
            System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts", num, guessesno);
            return true;
        }
        else if(a<num){
            System.out.println("Too low...");
        }
        else if(a>num){
            System.out.println("Too high...");
        }
        return false;  // return the value if user value!=correct num
    }

    public int getNum() { //get num method
        return num;
    }

    public void setNum(int num) {  //set num method with one paarameter
        this.num = num;
    }

    public int getInputNum() {  
        return a;
    }

    public void setInputNum(int inputNum) 
    {   // if the value will correct it get direct to main class
        this.a= inputNum;
    }

}