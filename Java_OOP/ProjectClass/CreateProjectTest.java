public class CreateProjectTest{
    public static void main(String[] args){
       CreateProject proj1 = new CreateProject();
       CreateProject proj2 = new CreateProject();
       CreateProject proj3 = new CreateProject();
    


        proj1.setName("First Project");
        proj1.setDescription("This Is My First Project");
        proj2.setName("Second Project");
        proj2.setDescription("This is second project");
        proj3.setName("Third Project");
        proj3.setDescription("Third Project description here what up");

        System.out.println(proj1.getProjectName());
        System.out.println(proj1.getProjectDescription());
        System.out.println(proj2.getProjectDescription());
        System.out.println(proj3.getProjectName());


        System.out.println(proj1.elevatorPitch());
        System.out.println(proj2.elevatorPitch());
        System.out.println(proj3.elevatorPitch());
    

    }
}