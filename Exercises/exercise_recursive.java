import java.util.*;

public class exercise_recursive {
    public static void main(String[] args) {
        String s = "daddy";
        char[] st = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        vowels.add('i');
        System.out.println(vowel(st,  vowels,  0, 0,  0));

        //String[] arr = {"data","structure","structure", "data"};
       // int[] arr1= {1,2,3,4,5};
       // System.out.println(contains(arr1,5,4));
       //int arr[] = {1,2,3,4,5};
       //System.out.println(arrMax(arr));
//
//       for (int i : shuffle(arr1)) {
//        System.out.println(i);
//       }
    
    }
    public static boolean vowel(char[] string, ArrayList<Character> vowels, int index, int countVowel, int countConsonant){
        if(index==string.length){
            if(countVowel > countConsonant)
                return true;
            return false;

            if(vowels.contains(string[index]))
                return vowel(string,vowels,index+1,countVowel+1,countConsonant);
            return vowel(string,vowels,index+1,countVowel,countConsonant+1);
        }

    }

    public static boolean rec(int[] array,int high,int mid,int low)
    {
        if(high<2)
            return false;

        if(mid!=low && array[high] == array[mid]*array[low])
            return true;

        if(mid==0 && low==0)
        {
            return rec(array,high-1,high-2,high-3);
        }
        else
        {
            if (low == 0)
                return rec(array, high, mid-1, mid-2);
            return rec(array, high, mid, low-1);
        }
}
    public static boolean contains(int[] arr, int number, int index){
        if (arr.length<3)
            return false;
        ArrayList<Integer> newArr = new ArrayList<>();
        newArr = createList(arr,newArr,0);
        if (newArr.contains(number / arr[index-1])){
            return true;
        }
        else
            return contains(arr,number,index-1);
    }
    public static ArrayList<Integer> createList(int[] arr, ArrayList<Integer> newArr, int index){
        if (index == arr.length) {
            return newArr;
        }
        else{
            newArr.add(arr[index]);
            return createList(arr, newArr, index+1);
        }
    }
    public static int arrMax(int arr[]){
        int max = arr[0];    
        for (int i : arr) {
            if(i>max)
                max=i;
        }
        return max;
     }

    public static int arrMaxRecursive(int[] arr, int max, int counter){
        if(counter == arr.length)
            return max;
        else {
            max = Math.max(max, arr[counter++]);
            return arrMaxRecursive(arr,max,counter);
        }      
     }

    public static int binarySearch(int low, int high, int target){
        int mid = (low+high) /2;
        if(mid<target){
            binarySearch(mid+1, high, target);
        }
        if(mid>target){
            binarySearch(low, mid-1, target);
        }
        return mid;
    }

    public int binarySum(int[] data, int low, int high) {
        if(low>high)
            return 0;
        if(low==high)
            return low;
        else{
            int mid=(high-low)/2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }

    public static int findMax(int[] a, int index) {
        if (index > 0) 
            return Math.max(a[index], findMax(a, index-1)) ;  
        return a[0];
    }

    public int linearSum(int[] A, int n){
        if (n == 0)
            return 0;
        else
            return linearSum(A, n - 1) + A[n - 1];
    }
    
    public static int power(int x, int p){    
        if(p==0){
            return 1;
        }
        else{
            return x*power(x, p-1);
        }
    }

    public String puzzleSolve(int k, Stack<Integer> s, List<Integer> u){
        for (int e : u) {
            u.remove(e);
            s.push(e);
            if(k==1){
                //
                return "solution found";
            }
            else{
                puzzleSolve(k-1,s,u);
            }
            u.add(e);
            s.pop();
        }
        return "s";
    }
    
    public static int[] reverseArray(int[] data, int low, int high) {
        if (low < high) { // if at least two elements in subarray
            int temp = data[low]; 
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1); 
        }
        return data;
    }

    static int[] shuffle(int[] arr){
        Random r= new Random();
        for(int i=0;i<arr.length;i++){
            int index = r.nextInt(arr.length);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    static int sumofDoubleArray(int[][] a, int n) {
        if (n == 1)
          return a[0][0];     
                //start edges number at zero
        int edges = 0;       
                               //sum up edges
        for (int i = 0; i < n; i++)
            edges += a[i][n - 1] + a[n - 1][i];       
            edges -= a[n - 1][n - 1];   //bottom right corner was added twice, needs to be subtracted
                                        //inclusion-exclusion principal
        return edges + sumofDoubleArray(a, n - 1);
      }

    static int sum5(int high,int low){
        if(high>low){
            if(low%5==0)
                return low + sum5(high,low+4);
        return sum5(high,low+1);    
        }
        return 0;  
      }

///////////STACKS//////////////

    public static boolean isParanthesisMatched(String expression) {
        final String opening = "({["; 
        final String closing = ")}]"; 
        Stack<Character> buffer = new Stack<>( );

        for (char c : expression.toCharArray( )) {
            if (opening.indexOf(c) != -1)   //if this is a left delimiter
                buffer.push(c);
            else if (closing.indexOf(c) != -1) { //if this is a right delimiter
                if (buffer.isEmpty( ))       //nothing to match with
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false; // mismatched delimiter
            }
        }
        return buffer.isEmpty(); // were all opening delimiters matched?
    }

    public static int eliminate(String[] array) {
        Stack<String> myStack = new Stack<>();
        myStack.push(array[0]);
        for(int i = 1; i < array.length; i++) {
            if(myStack.size()!=0){
                if(myStack.peek().equals(array[i]))
                    myStack.pop();
                else
                    myStack.push(array[i]);
            }		
        }		
        return myStack.size();
    }

    static void remove(Stack<Integer> S){
        if (S.size() > 0) {
            S.pop();
            remove(S);
        }
    }

     public static int[] reverseArraywithStack(int[] arr){
        Stack<Integer> s = new Stack<>();    
        for (int i : arr) {
            s.push(i);
        }
        for (int i : arr) {
           i=s.pop();
           System.out.println(i);
        }
        return arr;
     }

    public static List<Integer> shiftLeft(int d, List<Integer> arr) {
        int[] temp=new int[arr.size()];
        if(d<1 || arr.size()==1 || arr.size()==d)
            return arr;
        else{
            if(d>arr.size()){
                d=d%arr.size();
            }
            for (int i=0 ; i<d; i++) {
                temp[i] = arr.get(0);
                arr.remove(0);
            }
            for (int i=0 ; i<d; i++) {
                arr.add(temp[i]);
            }
        }     
        return arr;
    }

    public static void removeListElements(List l){
        if(l.size()==0){
                return;
        }
        l.remove(l.get(l.size()-1));
        removeListElements(l);
    }
}
