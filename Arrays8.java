

public class Arrays8
{

    public  static void main(String []  u){
        Integer []  myArray [] =new Integer[30][100];
         getRandomArray(myArray);
         printArrayModified(myArray);




    }




    public static void getRandomArray(Integer [][] array) {
        int i = 0, j = 0;
        while (i < array.length) {
            while (j < array[i].length) {

                array[i][j] = (int) (Math.random() * 150);
                String k = array[i][j] % 2 == 0 && array[i][j] % 11 == 0 ? "0" : "1";

                switch (k) {

                    case "0" -> System.out.print(array[i][j] + " ");
                }

                j++;

            }
            i++;

        }











   //     System.out.println("******************************************\n");


    }
    public static void printArrayModified(Integer [] [] array){
    int i=0,j=0;


        while(i<array.length) {
            while( j < array[i].length) {

                array[i][j] = array[i][j] + 1;
                String k=array[i][j] % 2 == 0 && array[i][j] % 11 == 0?"0":"1";

                switch (k){

                    case "0"->  System.out.print(array[i][j]+" ");
                }

                j++;

            }
       i++;

        }
    }


}
