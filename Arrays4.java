



public class Arrays4
{

    public  static void main(String []  u){
        Integer [] myArray=new Integer[50];
        getRandomArray(myArray);

    }

    public static void getRandomArray(Integer [] array){
   int i=0;

        while(i<array.length){
            array[i]=(int)(Math.random()*150);

            int  k=(array[i]%2==0)&&(array[i]%11)==0?0:1;



                switch (k){
                       case 0->System.out.println(array[i]);
                }


         i++;

        }
    }


}
