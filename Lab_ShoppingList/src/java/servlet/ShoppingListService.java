/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JosiahGabrielTarecte
 */
public class ShoppingListService extends HttpServlet {

       
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
             
              HttpSession session = request.getSession();
              String username = (String)session.getAttribute("username");
              
              if(username == null){
                     
                   this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);  
                     
              }
              
              else{ 
              
              
              String rQuery = request.getQueryString();
                     
                     if(rQuery != null && rQuery.contains("logout")){
                            session.invalidate();
                            
                            this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                            
                     } 
                     else {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                     }
              }

              
              
       }

       
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              
        HttpSession session = request.getSession();
        
        String action = (String) request.getParameter("action");
        
        List<String> shopList = (ArrayList<String>) session.getAttribute("items");

        if (action.equals("register")) {
            session.setAttribute("username", request.getParameter("username"));
            shopList = new ArrayList<>();
            session.setAttribute("items", shopList);

        }

        if (action.equals("add")) {
            String items = request.getParameter("item");
            shopList.add(items);

        }

        if (action.equals("delete")) {
            String del = request.getParameter("itemDelete");
            if (del != null) {
                shopList.remove(del);
            }

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
             
       }

       
}
