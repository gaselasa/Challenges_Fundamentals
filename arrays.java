

import java.util.Arrays;
import java.util.Collections;

public class arrays {

    public static  void main(String [] g){
    Integer [] myArray=new Integer[11];

Integer [] i=getRandomArray(myArray);

   /* for(int u:getRandomArray(myArray))
         System.out.println(u);
*/
for (Integer o:getSotterdArray(i))
    System.out.println(o);



    }


    public static Integer [] getSotterdArray(Integer [] array){
        Arrays.sort(array);

        return array;
    }

    public static Integer [] getRandomArray(Integer [] array){

        for(int i=0;i<array.length;i++)
             array[i]=(int)(Math.random()*150);




   return array;



    }



}
