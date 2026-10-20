package atritutoStatic;

public class MainClassroom {
    public static void main(String[] args){
        Classroom student1 =  new Classroom("Miguel : ");
        Classroom student2 = new Classroom("Angel : ");


        Classroom.setSchoolName(" SENA ");

        student1.showInfo();
        student2.showInfo();

    }
}
