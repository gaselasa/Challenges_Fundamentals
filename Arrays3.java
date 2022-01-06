

public class Arrays3
{

    public  static void main(String []  u){
        Integer [] myArray=new Integer[50];
        getRandomArray(myArray);

    }

    public static void getRandomArray(Integer [] array){

        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*150);
           if(array[i]%2==0 && array[i]%11==0)
               System.out.println(array[i]);
       
             
        }       
    }


}
