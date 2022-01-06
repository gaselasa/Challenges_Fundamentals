public class Arrays10 {

    public static  void main(String [] g){
    int [] myArray=new int[50];


    for(int index:getRandomArray(myArray))
         System.out.println(index);





    }

    public static int [] getRandomArray(int [] array){

        for(int i=0;i<array.length;i++)
             array[i]=(int)(Math.random()*150);



   array[20]=60;
array[61]=61;

   return array;


    }



}
