import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private  List<User> myUserData = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private  final String FILEPATH="C:/Users/User/Desktop/file.txt";


    private final KeyboardInput keyboardInput;

    User user;

    {

        keyboardInput = new KeyboardInput();

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


        user = new User();

        user.setName(keyboardInput.readNameAndSurname("WHAT IS YOUR FIRST NAME:"));

        user.setSurname(keyboardInput.readNameAndSurname("WHAT IS YOUR SURNAME:"));

        user.setEmail(keyboardInput.readEmail("ENTER YOUR EMAIL :"));

        user.setDate_of_birth(keyboardInput.getValidDate("ENTER YOUR DATE OF BIRTH"));

        user.setAge(Period.between(user.getDate_of_birth(), LocalDate.now()).getYears());

        if(myUserData.contains(user))
        {
            System.out.println("THE USER ALREADY EXIST" + user);

        }else
        {
            myUserData.add(user);
            System.out.println(user.getAge()+"\n"+"HELLO "+user.getName()
                    +" "+user.getSurname()+"\n"+"YOUR DETAILS HAS BEEN SAVE TO DATABASE\n"
                    +"================================================================== ");
            writeObjectToFile(myUserData);
        }




    }

    public   void writeObjectToFile(Object student) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);




            objectOutputStream.close();



        } catch (IOException e) {
            System.out.print("OBJECT IS NOT SAVED TO FILE");



        }

    }

    public void readObjectFromFile(){

        try {

            FileInputStream fileInputStream = new FileInputStream(FILEPATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


           myUserData=(List<User>)objectInputStream.readObject();










            objectInputStream.close();



        }catch (FileNotFoundException e){
            System.out.print("FILE NOT FOUND "+e.getMessage());
        }catch (IOException e){
            System.out.print("FILE NOT FOUND "+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.print("CLASS NOT FOUND "+e.getMessage());


        }


    }

    public void deleteUser() {
       readObjectFromFile();

        if (myUserData.size() == 0) {
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
            writeObjectToFile(myUserData);

        } else {


            System.out.println("NO PERSON ASSOCIATED WITH THAT EMAIL " + email + "\n"
                    + "==========================================================");
        }

    }
    public void displayAllUser()
    {
        readObjectFromFile();

        if(myUserData.size()==0)
        {
            System.out.println("PLEASE ENTER USERS FIRST, BEFORE WE CAN DISPLAY LIST OF USERS");
            addNewUser();

        }

        for(User user: myUserData)
            System.out.println(user);

    }




    public void updateUser()
    {
     readObjectFromFile();
        if(myUserData.size() == 0)
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

            currentUser.setDate_of_birth(keyboardInput.getValidDate("ENTER YOUR DATE OF BIRTH"));

            currentUser.setAge(Period.between(user.getDate_of_birth(), LocalDate.now()).getYears());

            myUserData.add(currentUser);

            System.out.print("UPDATED INFORMATION\n"+myUserData);
            writeObjectToFile(myUserData);

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
