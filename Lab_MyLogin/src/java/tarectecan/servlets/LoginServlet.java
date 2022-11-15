/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarectecan.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tarectecan.classes.AccountService;
import tarectecan.classes.AccountUser;

/**
 *
 * @author JosiahGabrielTarecte
 */
public class LoginServlet extends HttpServlet {


      
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
             
             
             String msg = "You have successfully logged out!";
             HttpSession session  = request.getSession();
             
             if(session.getAttribute("username") != null){
                    String queryString = request.getQueryString();
             
                   if(queryString != null && queryString.contains("logout")) {
                          session.invalidate();
                          
                    request.setAttribute("message", msg);
                    
              } 
                   else{
                   response.sendRedirect("home"); 
              }
     
              }
             this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
       }

       
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              
              
              String username = request.getParameter("username");
              String password = request.getParameter("password");
              
              AccountService account = new AccountService();
              AccountUser user = account.login(username, password);
              
              if(user != null){
                     
                   request.getSession().setAttribute("username", username);
                   
                   response.sendRedirect("home");
                   return;
              }
              else{
                     String msg = "Sorry, Invalid account. Try again!";
                     
                     request.setAttribute("message", msg);
              }
            

              
              this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             
              
              
           
       }

     
}
