import java.util.ArrayList;
import java.util.Arrays; 

public class BasicJavaTest{

public static void main(String[] args){
    /*printOneTo255();

    printOddOneTo255();

    printSum();*/

    //int[] x = {1,3,5,7,9,13};
    //iterateArray(x);//
    int[] test = {-1,2,-5,7,9,4,-6};
   // int numb = 4;
    //findMax(y);

    //System.out.println(oddArr());

    //System.out.println(greaterThanY(y, numb));

//squareTheValues(test);

//eliminateNegNums(test);

//System.out.println(maxMinAvg(test));

shiftValues(test);








        }
    
    public static void printOneTo255(){
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
            }

        }
        public static void printOddOneTo255(){
            for(int i = 1; i <= 255; i++){
                if(i % 2 == 1){
                    System.out.println(i);
                }
            }
        }
        public static void printSum(){
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
            public static void findAvg(int[] arr){
                int sum = 0;
                for(int i = 0; i < arr.length; i++){
                    sum = sum + arr[i];
                }  
                System.out.println(sum / arr.length); 
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
                System.out.println(Arrays.toString(x));
            }
            public static void eliminateNegNums(int[]x){
                for(int i = 0; i < x.length; i++){
                    if(x[i] < 0){
                        x[i] = 0;
                    }
                }
                System.out.println(Arrays.toString(x));
            }
            public static ArrayList<Integer> maxMinAvg(int[]x){
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
                    
                    return newArr;
                }

                public static int[] shiftValues(int[] x){
                    for(int i = 1;i < x.length; i++){
                        x[i - 1] = x[i];
                        
                    }
                    x[x.length - 1] = 0;
                        System.out.println(Arrays.toString(x));
                    return x; 
                }
            
}






