public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Its     ","     Lit    ");
        System.out.println(str); // HelloWorld      
        
        StringManipulator newStr = new StringManipulator();
        Integer finalValue = newStr.getIndexOrNull("I could go for several beers right now", 'v');
        System.out.println(finalValue);

        StringManipulator newManip = new StringManipulator();
        Integer resultVal = newManip.getIndexOrNull("I could go for several beers right now", "ver");
        System.out.println(resultVal);

        StringManipulator newConcat = new StringManipulator();
        String theWord = newConcat.concatSubstring("Arrowhead", 3,5, "Streak");
        System.out.println(theWord);
        
    }
}