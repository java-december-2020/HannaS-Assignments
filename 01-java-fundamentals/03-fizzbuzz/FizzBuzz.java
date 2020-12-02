public class FizzBuzz {

    public static String fizzBuzz(int val){
        if(val % 3 == 0 && val % 5 == 0) {
            return "FizzBuzz";
        } else if (val % 3 == 0){
            return "Fizz";
        } else if (val % 5 == 0){
            return "Buzz";
        } else {
            return Integer.toString(val);
        }
    }
    public static void FizzBuzzCounter(){
        for(int i = 0; i <= 100; i++){
            String result = fizzBuzz(i);
            System.out.println("number" + i + "=" + "Result: " + result);
        }
    }
}