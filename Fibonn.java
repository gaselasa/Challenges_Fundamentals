/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mysort;

/**
 *
 * @author User
 */
public class Fibonn {

    public static void main(String [] aar){
        
        int c=0;
      
        
        
        int n=9,n1=0,n2=1,n3=0;
        
        
        
        while(c<n){
            
             if(c==1|| c==0)
                 System.out.print(c+" ");
             else{
                 n3=n1+n2;
                 System.out.print(n3+" ");
                 
                 n1=n2;
                 n2=n3;
                 
                 
                 
                 
                 
             }
            c++;
            
        }
        
        
        
        
        
        
    }
    
}
