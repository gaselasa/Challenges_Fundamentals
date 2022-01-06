public class  SortArrayAsc
 {

    public static void main(String [] ar){
        int i=0;
        String myString="8,2,3,4";

        String [] array=myString.split(",");
         int [] myarray=new int[array.length];


        for(String a:array)
        {
            myarray[i] =Integer.parseInt(a);

             i++;
        }

        returnSoterdArray(myarray);



    }


    private  static void returnSoterdArray(int [] array){

        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }



                    }
     for(int a:array) System.out.println(a+" ");




                
    
    }



        }





