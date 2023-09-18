import domain.models.Student;
import domain.models.Teacher;
import repository.impl.StudentRepositoryimpl;
import repository.impl.TeacherRepositoryimpl;
import singledomain.ConexionDB;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try (Connection conn = ConexionDB.getInstance()) {
            TeacherRepositoryimpl teacherRepo = new TeacherRepositoryimpl();
            StudentRepositoryimpl studentRepo = new StudentRepositoryimpl();
            String option = "0";
            do{

                System.out.println("\n Menu:" +
                        "\n1. Teachers" +
                        "\n2. Students" +
                        "\n3. Subjects" +
                        "\n4. Grades" +
                        "\n5. Exit");
                option = scan.next();
                switch(option){
                    case "1": {
                        String optionTeacher = "0";
                        do{
                            System.out.println("\n Menu:" +
                                    "\n1. Teachers List" +
                                    "\n2. Teachers Add" +
                                    "\n3. Teachers Update" +
                                    "\n4. Teachers Delete" +
                                    "\n5. Teachers ById" +
                                    "\n6. Exit");
                            optionTeacher = scan.next();
                            switch(optionTeacher) {
                                case "1": {
                                    teacherRepo.list().forEach(System.out::println);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Add teacher");
                                    System.out.println("Name");
                                    String nameS = scan.next();
                                    System.out.println("Email");
                                    String emailS = scan.next();

                                    Teacher teacher = Teacher.builder()
                                            .name(nameS)
                                            .email(emailS).build();
                                    teacherRepo.save(teacher);
                                    System.out.println("Teacher saved");
                                    break;
                                }
                                case "3": {
                                    System.out.println("Update teacher");
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    System.out.println("Name");
                                    String nameS = scan.next();
                                    System.out.println("Email");
                                    String emailS = scan.next();
                                    Teacher teacher = Teacher.builder()
                                            .id(idS)
                                            .name(nameS)
                                            .email(emailS).build();
                                    teacherRepo.save(teacher);
                                    System.out.println("Teacher updated");
                                    break;
                                }
                                case "4": {
                                    System.out.println("Delete");
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    teacherRepo.delete(idS);
                                    System.out.println("Teacher deleted");
                                    break;
                                }
                                case "5": {
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    System.out.println(teacherRepo.byId(idS));
                                    break;
                                }
                            }
                        }while(!optionTeacher.equals("6"));
                        break;
                    }
                    case "2": {
                        String optionStudent = "0";
                        do{
                            System.out.println("\n Menu:" +
                                    "\n1. Teachers List" +
                                    "\n2. Teachers Add" +
                                    "\n3. Teachers Update" +
                                    "\n4. Teachers Delete" +
                                    "\n5. Teachers ById" +
                                    "\n6. Exit");
                            optionStudent = scan.next();
                            switch(optionStudent) {
                                case "1": {
                                    studentRepo.list().forEach(System.out::println);
                                    break;
                                }
                                case "2": {
                                    System.out.println("Add student");
                                    System.out.println("Name");
                                    String nameS = scan.next();
                                    System.out.println("Email");
                                    String emailS = scan.next();
                                    System.out.println("Semester");
                                    String semesterS = scan.next();
                                    Student student = Student.builder()
                                            .name(nameS)
                                            .email(emailS)
                                            .semester(semesterS).build();
                                    studentRepo.save(student);
                                    System.out.println("Student saved");
                                    break;
                                }
                                case "3": {
                                    System.out.println("Update teacher");
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    System.out.println("Name");
                                    String nameS = scan.next();
                                    System.out.println("Email");
                                    String emailS = scan.next();
                                    Teacher teacher = Teacher.builder()
                                            .id(idS)
                                            .name(nameS)
                                            .email(emailS).build();
                                    teacherRepo.save(teacher);
                                    System.out.println("Teacher updated");
                                    break;
                                }
                                case "4": {
                                    System.out.println("Delete");
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    teacherRepo.delete(idS);
                                    break;
                                }
                                case "5": {
                                    System.out.println("Id");
                                    Long idS = scan.nextLong();
                                    System.out.println(teacherRepo.byId(idS));
                                    break;
                                }
                            }
                        }while(!optionStudent.equals("6"));
                        break;
                    }
                    case "3": {

                        break;
                    }
                    case "4":{

                        break;
                    }
                }
            }while (!option.equals("5"));


        } catch (Exception e) {

        }
    }
}
