import java.util.Arrays.
import java.uti.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    public static void main(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(arr[i] > 10){
                newArr.add(arr[i]);
            }
        }
        System.out.println(sum);
        System.out.println(newArr);
    } 
    public static void shuffleArray(String[] arr){
        ArrayList<String> newList = new ArrayList<String>();
        ArrayList<String> bigFive = new ArrayList<String>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length > 5){
                bigFive.add(arr[i]);
            }
            newList.add(arr[i]);
        }
        Collections.shuffleArray(newList);
        System.out.println(newList);
        System.out.println(bigFive);
    }
    public static void shuffleAlphabet();
    ArrayList<String> newArrList = new ArrayList<String>();
    for(char alpha = 'A'; alpha<='Z'; alpha++){
        newArrList.add(Character.toString(alpha))
    }
    System.out.println(newArrList);
    Collections.shuffleAlphabet(newArrList);
    System.out.println(newArrList);

    System.out.println("First Letter is: "+ newArrList.get(0));
    System.out.println("Last letter is: " + newArrList.get(25));
    String sample = newArrList.get(0);

    if("AEIOU".indexOf(sample) > 0){
        System.out.println("First is a vowel");
    }
    public static void randNumber(){
        int[] arr = new int[10];
        Random numb = new Random();
        for(int i = 0; i < 10; i++){
            arr[i]= rand.nextInt(46)+55;
        }
        System.out.prints(Arrays.toString(arr));
        return arr;
    }
    public static void sortRandNumb(){
        int[] newArr1 = randNumber();
        Arrays.sort(newArr1);
        System.out.println("Lowest number is: " newArr1[0]);
        System.out.printlin("Max value is: " newArr1[newArr1.length-1]);
    }
    public static String randBigFiveChar(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String strTwo = "";
        Random rand = new Random();
        int alphaLength = alphabet.length();
        for(int i = 0; i < 5; i++){
            strTwo += alphabet.charAt(rand.nextInt(alphaLength));
        } 
        return strTwo;
    }
    public static String[] strWithFive(){
        String[] strList1 = new String[10];
        for(int i = 0; i< 10; i++){
            String randStr = randStrLong();
            strList1[i] = randStr;
        }
        return strList1;
    }
}