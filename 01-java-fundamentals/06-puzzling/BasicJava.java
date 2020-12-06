import java.util.ArrayList;


public class BasicJava{

public void printOneTo255(){
    for(int i = 1; i <= 255; i++){
        System.out.println(i);
        }
    }
public void printOddOneTo255(){
    for(int i = 1; i <= 255; i++){
        if(i % 2 == 1){
            System.out.println(i);
        }
    }
}
public void printSum(){
    for(int i = 0; i <= 255; i++){
        int sum = 0;
        System.out.println("New number: " + i);
        System.out.println("Sum: " + sum + i);
    }
}
public static void iterateArray(int[] x){
    for(int i: x){
    System.out.println(i);
    }
}
public static int findMax(int[] input){
int max = input[0];
for(int i = 0; i < input.length; i++){
    if(input[i] > max){
        max = input[i]; 
        }
    }
    return max;
}
public int findAvg(int[] arr){
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
        sum = sum + arr[i];
    }  
    return sum / arr.length; 
}
public static ArrayList<Integer> oddArr(){
    ArrayList<Integer> y = new ArrayList<Integer>(); 
    for(int i = 1;i <= 255; i++){
        if(i % 2 != 0){
            y.add(i);
        }
    }
    return y; 
}
public static Integer greaterThanY(int[] arr, int y){
    int num = 0;
    for(int i = 0; i < arr.length; i++){
        if(arr[i] > y){
            num++;
        }
    }
return num; 
}
public static void squareTheValues(int[]x){
    for(int i = 0;i < x.length; i++){
        x[i] = x[i] * x[i];
    }
}
public static void eliminateNegNums(int[]x){
    for(int i = 0; i < x.length; i++){
        if(x[i] < 0){
            x[i] = 0;
        }
    }
}
public static void maxMinAvg(int[]x){
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    int max = findMax(x);
    int min = x[0];
    int sum = 0;
    for(int j = 0;j <x.length; j++){
        if(x[j] < min){
            min = x[j];
        }
    }

    for (int i : x){
        sum += i;
        }
        newArr.add(min);
        newArr.add(max);
        newArr.add(sum / x.length);
        
        System.out.println(newArr);
    }

public static void shiftValues(int[] x){
    for(int i = 1;i < x.length; i++){
        x[i - 1] = x[i];
        
    }
    x[x.length - 1] = 0;
    
    }
}