/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarectecan.classes;
import tarectecan.classes.AccountUser;



/**
 *
 * @author JosiahGabrielTarecte
 */
public class AccountService {
 
      public AccountUser login(String username, String password){
             
             if(username == null){
                    
                    return null;
             
             }
             if("Josiah".equals(username) && "twentyone".equals(password)){
                    
                    return new AccountUser(username, password);
             
             }
             else{
                    return null;
             }
             
      }
       
}
