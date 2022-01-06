

public class Arrays7
{

    public  static void main(String []  u){
        Integer []  myArray [] =new Integer[30][100];
        getRandomArray(myArray);



    }




    public static void getRandomArray(Integer [][] array){

        for(int i=0;i<array.length;i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = (int) (Math.random() * 150);

                if (array[i][j] % 2 == 0 && array[i][j] % 11 == 0)
                    System.out.print(array[i][j]+" ");
            }

        }




        System.out.println("******************************************\n");



        for(int i=0;i<array.length;i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = array[i][j] + 1;
                if (array[i][j] % 2 == 0 && array[i][j] % 11 == 0)
                    System.out.print(array[i][j]+" ");


            }

        }







    }


}
