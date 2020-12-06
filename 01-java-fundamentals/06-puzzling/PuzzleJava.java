import java.util.ArrayList; 
public class PuzzleJava{

    public static int[] sumAndMoreThan10(int[] arr){
        int sum = BasicJava.printSum(arr);
        System.out.println(sum);    
        int[] newArr = new int[BasicJava.greaterThanY(arr, 10)];
        int a = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 10){
                newArr[a] = arr[i];
                a++;
            }
        }
        return newArr; 
        }
    
    }