/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author User
 */
public class JsonUtil {
    
    private static final ObjectMapper  mapper;
   private static final String FILEPATH="C:/Users/User/Desktop/filedata.txt";
   private static FileOutputStream fos;
   private static File file;
static{
    mapper=new ObjectMapper();
    
}
public static List<User> convertJsonToJava(){
    
 //   T
List<User> objectjava =null;
   
 
    try{
    
        file=new File(FILEPATH);
        objectjava=mapper.readValue(file,new TypeReference<List<User>>(){} );
        
        
    
    
    
     }catch(JsonParseException e){
        e.printStackTrace();
        
    }catch(JsonMappingException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
   // System.out.println(objectjava);
    
   return objectjava;
}


public static void convertJavaToJson(Object object){
    
   // String jsonResult=null;
    try{
        fos=new FileOutputStream(FILEPATH);
        
         mapper.writeValue(fos, object);
         
        // fos.flush();
         //fos.close();
         
   
    }catch(JsonGenerationException e){
        e.printStackTrace();
        
    }catch(JsonMappingException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
    
   
    
    
}
    
}
