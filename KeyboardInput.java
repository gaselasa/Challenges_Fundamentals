

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class KeyboardInput
{

    private boolean valid;

    private final  Scanner input;

    final NamesValidator namesValidatorStrict;

    public KeyboardInput()
    {
        this.input = new Scanner(System.in);
        this.namesValidatorStrict  = new NamesValidator();

    }

    public String readEmail(String message){

        String email = null;

        valid =false;

        while (!valid)
        {


            System.out.println(message);

            email = input.nextLine();

            try
            {
                if (!EmailValidator.isValid(email))
                    throw new IllegalArgumentException("INVALID EMAIL");
                else
                    valid = true;

            } catch (IllegalArgumentException err)
            {
                System.out.println("EXAMPLE OF INVALID EMAIL FORMAT");
                EmailValidator.invalidEmailFormat().forEach(s -> System.out.println(s));

            }

        }


        return email;
    }

    public String readNameAndSurname(String prompMessage)

    {

        String userInput = "";
        valid =false;

        while (!valid)
        {


            System.out.println(prompMessage);

            userInput = input.nextLine();

            try
            {
                if (!NamesValidator.isValid(userInput))
                    throw new IllegalArgumentException("INVALID NAME");
                else
                    valid = true;


            } catch (IllegalArgumentException err)

            {
                System.out.println("CHECK IF YOU ENTER NAME\n" + "NAME DON'T HAVE SPACE\n" + "CHECK THE LENGTH OF THE WORD");
                System.out.println("LIST OF INVALID NAMES FORMAT \n");
                NamesValidator.invalidNamesProvider().forEach(s -> System.out.println(s));
            }


        }

        return userInput;
    }



    public LocalDate getValidDate(String promptMessage)
    {
        valid = false;

        LocalDate date = LocalDate.now();

        String dateString = "";

        while (!valid)
        {

            System.out.println(promptMessage);

            dateString = input.nextLine();

            try
            {

                String[]  userDateOfBirth = dateString.trim().split("/");

                date=LocalDate.parse(userDateOfBirth[2] + "-" + userDateOfBirth[0] + "-" + userDateOfBirth[1]);

                if(!checkYearIsValid(date))
                    throw new IllegalArgumentException("Check following!!");

                valid = true;

            } catch (DateTimeParseException e)
            {
                System.out.println(e.getCause());
                System.out.println("Format of the input [MM/DD/YYYY]\n"+"With two digit for MM and DD");

            } catch (ArrayIndexOutOfBoundsException t)
            {
                System.out.println("Invalid input less than expected input or not In the right Format");

            }catch (IllegalArgumentException error)
            {
                System.out.println(error +"\n" +" >>Your Date Birth is greater Current Date\n"+" >>You are minor play with toys\n"+">>You are old it unluck you still alive");

            }


        }
        return date;
    }

    private boolean checkYearIsValid(LocalDate userDateOfBirth)
    {
        return LocalDate.now().minusYears(10).isAfter(userDateOfBirth) && (LocalDate.now().minusYears(100).isBefore(userDateOfBirth));
    }

}
