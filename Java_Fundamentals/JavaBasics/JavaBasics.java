import java.util.ArrayList;
import java.util.Collections;

public class JavaBasics{
    public void print1To255(){
        for(int i = 1; i < 256; i++){
            System.out.println(i);
        }
    }
    public void printOddNumbs(){
        for(int i = 1; i < 256; i+2){
            System.out.println(i);
        }
    }
    public void printSum(){
        int total = 0;
        for( int i = 1; i < 256; i++){
            total += i; 
            System.out.println("New Number: "+ i + "Sum: "+ total);
        }
    }
    public void iterateArray(int[] myArray){
        for(int i = 0; i < myArray.size(); i++){
            system.out.println(myArray[i]);
        }
    }
    public void findMax(int[] newArr){
        int max = newArr[0];
        for(int i = 0; i < newArr.size(); i++){
            if(newArr[i] > max){
                max  = newArr[i];
            }
        }
        System.out.println(max);
    }
    public void getAverage(int[] arrAvg){
        int sum = 0;
        for(int i = 0; i < arrAvg.size(); i++){
            sum += arrAvg[i];
        }
        System.out.println(sum/newArr.size);
    }
    public void oddInArr(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 1; i < 256; i+=2){
            y.add(i);
        }
        System.out.println(y);
    }
    public void greaterThanY(int[] thisArr, int y){
        int count = 0;
        for(int i = 0; i < thisArr.size(); i++){
            if(arr[i] > y){
                count++;
            }
        }
        System.out.println(count);
    }
    public void squareValues(int[] x){
        ArrayList<Integer> z = new ArrayList<Integer>();
        for(int i = 0; i < x.size(); i++){
            x[i]= x[i]* x[i];
            z.add(x[i]);
        }
        System.out.println(z);
    }
    public void eliminateNegatives(int[] x){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int i = 0; i < x.size(); i++){
            if(x[i] < 0){
                x[i] = 0;
            }
            newArr.add(x[i]);
        }
        System.out.prinln(newArr);
    }
    public void maxMinAvg(int[] z){
        ArrayList<Integer> secArr = new ArrayList<Integer>();
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for(int i = 1; i < z.size(); i++){
            if(z[i] < min){
                min = z[i];
            }
            if(z[i] > max){
                max = z[i];
            }
            sum += z[i];
        }
        int avg = sum/z.size();
        Collection.addAll(secArr, min, max, avg);
        System.out.println(secArr);
    }
    public void shiftVals(int[] x){
        ArrayList<Integer> newArr2 = new ArrayList<Integer>();
        for(int i = 0; i < x.size(); i++){
            if(i == x.size() - 1){
                newArr2.add(0);
            }
            else{
                newArr2.add(x[i+1]);
            }
        }
        System.out.println(newArr2)
    }
}
