public class StringManipulator{
    public String trimAndConcat(String str1, String str2 ){
        String newString = str1.trim()+ str2.trim();
        return newString;
    }
    public Integer getIndexOrNull(String someStr, char someChar ){
        Integer value = someStr.indexOf(someChar);
        return value; 
    }
    public Integer getIndexOrNull( String randStr1, String subStr ){
        Integer val2 = randStr1.indexOf(subStr);
        return val2;
    }
    public String concatSubstring(String word1, int num1, int num2, String word2){
        String word3 = word1.substring(num1, num2);
        String actualWord = word3 + word2;
        return actualWord;
    }
}