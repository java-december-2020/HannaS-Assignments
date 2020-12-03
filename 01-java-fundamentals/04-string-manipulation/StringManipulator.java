public class StringManipulator{
    public static String trimAndConcat(String stringOne, String stringTwo){
        return stringOne.trim() + stringTwo.trim();
    }
    public static Integer getIndexOrNull(String str, char x){
        if(str.indexOf(x) == -1){
            return null; 
        }
        return str.indexOf(x);
    }
    public static Integer getIndexOrNull(String str1, String str2){
        if(str1.indexOf(str2) == -1){
            return null; 
        }
        return str1.indexOf(str2);
    }

    public static String concatSubstring(String str3, int val, int val2, String str4){
        String newStr = str3.substring(val, val2);
        return newStr.concat(str4);

    }
}