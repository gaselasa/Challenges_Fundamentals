/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author User
 */
//import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Runner {

    private   List<User> myUserData = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
   


    /*private final*/ KeyboardInput keyboardInput=new KeyboardInput();
    

    User user;

    static {

       // keyboardInput = new KeyboardInput();

    }
   
    public  static  void main(String [] o)
    {

        Runner run = new Runner();
        run.selectChoice();

    }

    private void selectChoice()
    {

        int userInput;

        while(true) {

            try {
                System.out.println("""
                        USER MENU\s
                        PLEASE ENTER NUMBER\s

                        1==ADD A NEW USER
                        2==UPDATE EXISTING USER
                        3==DELETE A USER
                        4==DISPLAY ALL USERS
                        5==TO EXIT THE PROGRAM""");

                userInput =Integer.parseInt(sc.nextLine());



                if(userInput==5) break;


                switch (userInput)
                {
                    case 1 -> addNewUser();
                    case 2 -> updateUser();
                    case 3 -> deleteUser();
                    case 4 -> displayAllUser();
                    default -> System.out.print("BAD CHOICE TRY AGAIN");
                }


            } catch (NumberFormatException er)

            {

                System.out.println("THAT NOT A NUMBER PLEASE TRY AGAIN");

            }

        }


    }


    public void addNewUser()
            
    {
      myUserData=(List<User>)JsonUtil.convertJsonToJava();    

        user = new User();

        user.setName(keyboardInput.readNameAndSurname("WHAT IS YOUR FIRST NAME:"));

        user.setSurname(keyboardInput.readNameAndSurname("WHAT IS YOUR SURNAME:"));

        user.setEmail(keyboardInput.readEmail("ENTER YOUR EMAIL :"));

       LocalDate date = keyboardInput.getValidDate("ENTER YOUR DATE OF BIRTH");
      
      

        user.setAge(Period.between(date, LocalDate.now()).getYears());

        if(myUserData.contains(user))
        {
            System.out.println("THE USER ALREADY EXIST" + user);

        }else
        {
            myUserData.add(user);
            System.out.println("YOUR AGE IS"+user.getAge()+"\n"+"HELLO "+user.getName()
                    +" "+user.getSurname()+"\n"+"YOUR DETAILS HAS BEEN SAVE TO DATABASE\n"
                    +"================================================================== ");
             JsonUtil.convertJavaToJson(myUserData);
        }


      
       

    }

    

    
    public void deleteUser() {
    
      myUserData=(List<User>)JsonUtil.convertJsonToJava();
      

        if (myUserData.isEmpty()) {
            System.out.println("PLEASE ENTER USER FIRST BEFORE YOU CAN DELETE");
            addNewUser();

        }
        System.out.println("YOU WANT TO DELETE USER");
        String email = keyboardInput.readEmail("ENTER THE EMAIL SO WE SEARCH OUR DATABASE:");

        User currentUser = searchUserByEmail(email);

        if (currentUser != null) {
            myUserData.remove(currentUser);
            System.out.println("THE USER WITH EMAIL HAS BEEN DELETED\n"
                    + "==================================================\n");
               JsonUtil.convertJavaToJson(myUserData);

        } else {


            System.out.println("NO PERSON ASSOCIATED WITH THAT EMAIL " + email + "\n"
                    + "==========================================================");
        }

    }
    public void displayAllUser()
    {
    
     myUserData=(ArrayList<User>)JsonUtil.convertJsonToJava();
       System.out.println(myUserData.size());
    
    

        if(myUserData.isEmpty())
        {
            System.out.println("PLEASE ENTER USERS FIRST, BEFORE WE CAN DISPLAY LIST OF USERS");
            addNewUser();

        }


        for(User userdata: myUserData)
            System.out.println(userdata);
          
            
        
            
        }

    


    


    public void updateUser()
    {

         myUserData=(List<User>)JsonUtil.convertJsonToJava();
         
                 
        if(myUserData.isEmpty())
        {
            System.out.println("PLEASE ENTER USER FIRST BEFORE YOU CAN UPDATE");
            addNewUser();

        }

        System.out.println("YOU WANT TO UPDATE DETAILS OF USER");
        String email=keyboardInput.readEmail("ENTER THE EMAIL SO WE SEARCH OUR DATABASE:");

        User currentUser = searchUserByEmail(email);

        myUserData.remove(currentUser);

        if(currentUser!=null)
        {
            currentUser.setName(keyboardInput.readNameAndSurname("WHAT IS YOUR FIRST NAME:"));

            currentUser.setSurname(keyboardInput.readNameAndSurname("WHAT IS YOUR SURNAME:"));

            currentUser.setEmail(keyboardInput.readEmail("ENTER YOUR EMAIL :"));
          LocalDate date = keyboardInput.getValidDate("ENTER YOUR DATE OF BIRTH");
            

     
            currentUser.setAge(Period.between(date, LocalDate.now()).getYears());

            myUserData.add(currentUser);

            System.out.print("UPDATED INFORMATION\n"+myUserData);
            
              JsonUtil.convertJavaToJson(myUserData);

        }
        else
        {
            System.out.println("NO PERSON ASSOCIATED WITH THAT EMAIL "+ email);

        }
      
    }

    private   User  searchUserByEmail(String email){

        User currentUser = null;
        for (User myUserDatum : myUserData) {
            if (email.equals(myUserDatum.getEmail())) {
                currentUser = myUserDatum;
                break;
            }
        }

        return  currentUser;



    }


}
