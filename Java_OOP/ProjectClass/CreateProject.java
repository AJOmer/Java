public class CreateProject{
    private String name;
    private String description;

    public String elevatorPitch(){
        return (name +", "+ description);
    }
   ///Constructors 
   public CreateProject (){
   }
   public CreateProject(String name){
       this.name = name;
   }
   public CreateProject(String name, String description){
       this.name = name;
       this.description = description;
   }
   ///setting name
   public void setName(String name){
       this.name = name;
   }
   ///setting description
   public void setDescription(String description){
       this.description = description;
   }
   ///getting name
   public String getProjectName(){
       return this.name;
   }
   ///getting description
   public String getProjectDescription(){
       return this.description;
   }
}

