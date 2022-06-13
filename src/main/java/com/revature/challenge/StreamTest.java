package com.revature.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code above (lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
             If "Bob" does not exist, print "No student found".
     	     HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        boolean DEBUG = true;
        
        // Code your Solution here
        Optional<Student> possiblyBob = students.stream() 
        		                        .filter(s -> s.getName().equals("Bob"))
        		                        .findFirst();
        if(DEBUG) System.out.println("============Answer to 1 done as a cohort ==========");
        System.out.println(possiblyBob.isPresent() ? possiblyBob.get().getName() : "No student found");
        
        
        
        /***************************************************************************
         (2) Get the student with matching address "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        // Code your Solution here
        Optional<Student> s1 = students.stream()
        		                       .filter(s-> s.getAddress().getZipcode().equals("1235"))
        		                       .findFirst();
        
        if(DEBUG) System.out.println("============Answer to 2 done as a cohort ==========");
        System.out.println(s1.isPresent() ? s1.get().getName() : "No student found");
        
        
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/
        if(DEBUG) System.out.println("============ Answer to Question 3 ===========");
        
        List<Student> studentsWith3333 = 
        students.stream()
                .filter(s -> s.getMobileNumbers()
                		.stream()
                		.anyMatch(num -> num.getNumber().equals("3333")))
                		.collect(Collectors.toList());
  
        studentsWith3333.forEach(s-> System.out.println(s.getName()));
        
        // Code your Solution here

        
        
        
        
        /***************************************************************************
         (4) Get all student having mobile number "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/
         if(DEBUG) {
         System.out.println("=============Solution to #4 ==============");
         }
        // Code your Solution here
        List<Student> studentsWith1233And1234 = students.stream()
        		           .filter(s -> s.getMobileNumbers()
        		           .stream()
        		           .anyMatch(num -> num.getNumber().equals("1233")))
        		           .filter(s-> s.getMobileNumbers()
        		           .stream()
        		           .anyMatch(num -> num.getNumber().equals("1234")))
        		           .collect(Collectors.toList());
        		        		   
        studentsWith1233And1234.forEach(s-> System.out.println(s.getName()));
        
        
        
        
        /***************************************************************************
	     (5) Create a List<Student> from the tmpStudents List. Call it studentList.
	         Hint: Use Collectors.toList(). Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Code your Solution here, don't touch the code above
       
        //based on stack over flow 
        //stackoverflow.com/questions/35650974/create-list-of-object-from-another-using-java-8-streams
        
        // Create a new Student for each student in the strea list to resolve type...then collect them and then
        // push them to a list
        
       List<Student> studentList = tmpStudents.stream()
    		                                  .map(s -> new Student(s.name, s.age, s.address, s.mobileNumbers))
    		                                  .collect(Collectors.toList());
       
        if(DEBUG) System.out.println("==================Answer to Number 5 with help from stack overflow =======");
        System.out.println(studentList);
       
       
        
        
        
        
 
        /***************************************************************************
         (6) Convert the List<Student> called studentList that you made in question (5) to 
             List<String> of just their names. Call this new list "studentNames". 
             Print it to the console.
        ****************************************************************************/

        
        // Code your Solution here
        List<String> studentNames = studentList.stream()
        		                               .map(s -> new String(s.getName()))
        		                               .collect(Collectors.toList());
        if(DEBUG) System.out.println("================ Answer to Number 6 ==========");
        System.out.println(studentNames);
        
        
        
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/
       if(DEBUG) System.out.println("==============Answer to Number 7 assist from techiedelight.com/convert-list-to-string===============");
      
        //joining method on collectors will concat results with a specified delimiter
        String name = studentList.stream().map(s -> s.getName()).collect(Collectors.joining(" "));
        		                          
      
        System.out.print(name);
        // Code your Solution here

        
        
        
        
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above
        	if(DEBUG) System.out.println("==========Answer to number 8 ======");
       
        	System.out.println(nameList.stream().map(String::toUpperCase).collect(Collectors.toList()));
        	
        
        
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        
        // Code your Solution here, don't touch the code above
 
        List<String> sortedNamesList =
        		namesList.stream().sorted().collect(Collectors.toList());
        
        if(DEBUG) System.out.println("==================Answer to Number 9 ==========");
        sortedNamesList.stream().forEach(System.out::println);
        
 
    }
    
    
}






