package org.example;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Create Objects
        Course course1 = new Course("Backend Programming", DateTime.parse("2022-09-05T00:00:00.000Z"), DateTime.parse("2022-12-10T00:00:00.000Z"));
        Course course2 = new Course("FrontEnd Programming",DateTime.parse("2022-10-02T00:00:00.000Z"), DateTime.parse("2022-12-10T00:00:00.000Z"));
        List<Course> allCourses = Arrays.asList(course1,course2);

        Lecturer lecturer1 = new Lecturer("John Smith", 50, DateTime.parse("1972-01-01T00:00:00.000Z"),1);
        Lecturer lecturer2 = new Lecturer("Michelle McJava", 50, DateTime.parse("1972-01-01T00:00:00.000Z"),2);
        Lecturer lecturer3 = new Lecturer("Steve Fasttyper", 50, DateTime.parse("1972-01-01T00:00:00.000Z"),3);

        Module module1 = new Module("Introduction to Java", lecturer2);
        Module module2 = new Module("Advanced Java",lecturer2);
        Module module3 = new Module("React Basics", lecturer1);
        Module module4 = new Module("JavaScript 101", lecturer3);

        Student student1 = new Student("Iarlaith", 21, DateTime.parse("2001-01-01T00:00:00.000Z"),1);
        Student student2 = new Student("Sean", 20, DateTime.parse("2002-01-08T00:00:00.000Z"),2);
        Student student3 = new Student("Michael", 21, DateTime.parse("2001-04-01T00:00:00.000Z"),3);
        Student student4 = new Student("Stephen", 22, DateTime.parse("2000-03-06T00:00:00.000Z"),4);
        Student student5 = new Student("Mark", 21, DateTime.parse("2001-01-02T00:00:00.000Z"),5);

        //Add modules to courses
        course1.setModules(Arrays.asList(module1,module2));
        course2.setModules(Arrays.asList(module3,module4));

        //Add students to courses
        course1.setStudents(Arrays.asList(student1,student2,student3));
        course2.setStudents(Arrays.asList(student4,student5));

        //Add students to modules
        module1.setStudents(Arrays.asList(student1,student2,student3));
        module2.setStudents(Arrays.asList(student1,student2,student3));
        module3.setStudents(Arrays.asList(student4,student5));
        module4.setStudents(Arrays.asList(student4,student5));

        //Add courses to modules
        module1.setCourses(Arrays.asList(course1));
        module2.setCourses(Arrays.asList(course1));
        module3.setCourses(Arrays.asList(course2));
        module4.setCourses(Arrays.asList(course2));

        //Add courses to students
        student1.setCourses(Arrays.asList(course1));
        student2.setCourses(Arrays.asList(course1));
        student3.setCourses(Arrays.asList(course1));
        student4.setCourses(Arrays.asList(course2));
        student5.setCourses(Arrays.asList(course2));

        //Add modules to students
        student1.setModules(Arrays.asList(module1,module2));
        student2.setModules(Arrays.asList(module1,module2));
        student3.setModules(Arrays.asList(module1,module2));
        student4.setModules(Arrays.asList(module3,module4));
        student5.setModules(Arrays.asList(module3,module4));

        //Add modules to lecturer
        lecturer1.setModules(Arrays.asList(module3));
        lecturer2.setModules(Arrays.asList(module1,module2));
        lecturer3.setModules(Arrays.asList(module4));

        System.out.println("####################");
        for(Course course : allCourses) {
            System.out.println("COURSE: " + course.getCourseName());
                for(Module module : course.getModules()){
                    System.out.println("\n  ↪" + "MODULE: " + module.getModuleName());
                    for(Student student : module.getStudents()) {
                        System.out.println("\n      ↪" + "STUDENT NAME: " + student.getName());
                        System.out.println("\n          ↪" + "USERNAME: " + student.getUsername());
                        for(Course studentCourse : student.getCourses()){
                            System.out.println("\n              ↪" + "COURSES ENROLLED: " + studentCourse.getCourseName());
                        }
                        for(Module studentModule : student.getModules()){
                            System.out.println("\n                  ↪" + "MODULES ENROLLED: " + studentModule.getModuleName());
                        }
                    }
                }
        }
        System.out.println("####################");
    }
}