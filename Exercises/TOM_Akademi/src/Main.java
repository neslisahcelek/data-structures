import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
    }
    /////////How many digits do we need change to convert a number to a palindrome?
    public static int minPalindrome(int number){
        int counter = 0;
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList=createList(number, numberList);

        int j=numberList.size()-1;
        for (int i=0; i<numberList.size()/2; i++) {
            if (numberList.get(i) != numberList.get(j)){  //compare first and last index
                counter++;
            }
            j--;
        }
        return counter;
    }
    public static ArrayList<Integer> createList(int number, ArrayList<Integer> numberList){
        numberList.add(number%10);
        number=number/10;
        if (number>=1){
            createList(number, numberList);
        }
        return numberList;
    }
    /////////convert a String to double without using existed function
    public static Double stringToDouble(String number){
        Double result=0.0;
        int dotIndex = number.indexOf('.'); //where is the dot
        char[] numberArray = number.toCharArray();

        Double multiplier = 1.0;
        for (int i=dotIndex-1; i>=0; i--){ //from dot-1 to first index(integer part)
            result+=(numberArray[i])*multiplier;
            multiplier*=10;
        }

        multiplier=0.1;
        for (int i=dotIndex+1; i<=numberArray.length-1; i++){ //decimal part
            result+=(numberArray[i])*multiplier;
            multiplier/=10;
        }
        return result;
    }
    public static void FizzBuzz(int number){
        boolean isDividibleByThree = false;
        if (number%3 == 0){
            isDividibleByThree = true;
        }
        if (number%5 == 0){
            if(isDividibleByThree){ //dividible by 15(3 and 5)
                System.out.println("fizzbuzz");
            }
            else { //dividible by only 5
                System.out.println("buzz");
            }
        }
        else { //dividible by only 3
            System.out.println("fizz");
        }
    }
}




