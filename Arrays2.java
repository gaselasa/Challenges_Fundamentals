

public class Arrays2
{

    public  static void main(String []  u){
        Integer [] myArray=new Integer[11];
        getRandomArray(myArray);



    }

public static void displayContent(Integer [] array){

        for(int o:array)
            System.out.print(o);


}


    public static void getRandomArray(Integer [] array){

        for(int i=0;i<array.length;i++)
            array[i]=(int)(Math.random()*150);

        displayContent(array);
      System.out.println("\n");



        for(int i=0;i<array.length;i++)
            array[i]=array[i]+1;

         displayContent(array);




    }


}
