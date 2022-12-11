import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        man m=new man("kalabalk");      
        m.play();
    }
}
class man{
    String word;
    private int size;
    private String[] board;
    String[] expected; 
    int count=6;

    man(String w){
        this.word=w.trim(); //remove empty spaces in the beginning and at the end of the word
        this.size=word.length();  
        board = new String[this.size]; 
        expected = word.split("");
        if(word.contains(" ")){     //if there is more than 1 word
            for(int i =0; i<size; i++){                 
                if(expected[i].equals(" ")){
                    board[i] = " /";
                }
                else
                    board[i] = "_";
            } 
        }
        else{
            for(int i=0; i<size; i++){
                board[i] = "_";
            } 
        }     
    }
    boolean isAvailablePlace(){
        for (String c : board) {
            if(c.equals("_")){
                return true;
            }
        }
        return false;   
    }

    public void play(){
        printMan(count);
        printBoard();
 
        while(isAvailablePlace() && count>0){ //while there is a remaining letter and guess  
            System.out.println("Please enter a letter or make a guess.");
            Scanner s=new Scanner(System.in);
            String guess = s.nextLine();
            /* if(guess.substring(0,1) == " "){
                throw new IllegalArgumentException();
            }
            */
           
            if(guess.trim().length()>1){ //if user wants to make a guess
                if(wordGuess(guess))
                    return;
            }
            boolean isTrue = false;
            for (int i=0 ; i<this.expected.length;i++) { //is the entried letter matching?
                if(expected[i].equals(guess)){
                    this.board[i] = guess;
                    isTrue=true;
                }
                else 
                    continue;
            } 
            printMan(count);
            printBoard();
            if(!isTrue){
                System.out.println("Not match :( Remaining guess: " + count);
                count--;
            }
            else{
                System.out.println("Match!");
            }    
        }   
        for(int i =0; i<size; i++){
            if(!board[i].equals(expected[i])){
                System.out.println(board[i]);
                System.out.println(expected[i]);
                System.out.println("You lose the game!");
                printBoard(expected);
                return;
            }         
        }
        System.out.println("You win the game!");  
    }
     boolean wordGuess(String s){
        if(s.equals(word.toLowerCase().formatted())){
            System.out.println("That's right. You win the game!");  
            return true;
        }
        return false;
    }
    void printMan(int c){   
        if(c==0){
            return;
        }    
        switch(c){
            case 6:
                System.out.println("-----"); 
            case 5:
                System.out.println("    O    "); 
            case 4:
                System.out.println("    |    " ) ; 
            case 3:
                System.out.print("   | " ) ; 
            case 2:
                System.out.println("|");      
            case 1:
                System.out.println("  dead  ");                 
        }
        //printMan(c-1);
    }
    void printBoard(String[] b){
        for(int i =0; i<size; i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }
    void printBoard(){
        printBoard(board);
    }
}
