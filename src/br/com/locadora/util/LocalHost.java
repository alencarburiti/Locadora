/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import java.net.*;  
/**
 *
 * @author alencarburiti
 */
public class LocalHost {

   public String hostAddress()  
   {  
      try  
      {  
         return InetAddress.getLocalHost().getHostAddress();  
      }  
      catch(UnknownHostException e)  
      {  
         return new String("127.0.0.1");     
      }  
   } 
   
   public String hostName()  
   {  
      try  
      {  
         return InetAddress.getLocalHost().getHostName();  
      }  
      catch(UnknownHostException e)  
      {  
         return new String("Null");     
      }  
   } 
    
}
