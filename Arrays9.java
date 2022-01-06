

public class Arrays9
{

    public  static void main(String []  u){
        Integer []  myArray [] =new Integer[100][30];
        getRandomArray(myArray);



    }

    public static void displayContent(Integer [] [] array){
        int count=1;

        for(Integer [] o : array) {


            for (int k : o) {
            
                  if(k%3==0&& k%8==0)
                    System.out.print(k+" ");

                count++;

            }
   System.out.println();

        }

    }


    public static void getRandomArray(Integer [][] array){

        for(int i=0;i<array.length;i++)
            for (int j = 0; j < array[i].length;j++)
                array[i][j] = (int) (Math.random() * 150);



        displayContent(array);
        System.out.println("******************************************\n");



        for(int i=0;i<array.length;i++)
            for (int j = 0; j < array[i].length;j++)
                array[i][j]=array[i][j]+1;

        displayContent(array);




    }


}
