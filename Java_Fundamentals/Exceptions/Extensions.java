import java.util.ArrayList;

public class Extensions{
    public static void testing(){
        ArrayList<Object> newObj = new ArrayList<Object>();
        newObj.add(22);
        newObj.add("I need this to work");
        newObj.add("Cooler weather nowadays");
        newObj.add(03);

        for(int i = 0; i< newObj.size(); i++){
            try{
                Integer castedValue = (Integer) newObj.get(i);
                System.out.println(castedValue);
            }catch(ClassCastException e){
                System.out.println("Error on index: " + i);
            }
        }
    }
}