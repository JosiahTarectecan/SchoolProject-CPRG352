<%-- 
    Document   : shoppingList
    Created on : Oct 15, 2022, 12:10:49 PM
    Author     : JosiahGabrielTarecte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
       <head>
              <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>Shopping List</title>
       </head>
       <body>
              <h1>Shopping List</h1>
        <div>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></div>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
               
            <input type="hidden" name="action" value="add">
              Add item:
            <input type="text" name="item">
            <input type="submit" value="Add">
            
        </form>

        <form action="ShoppingList" method="post">
               
            <input type="hidden" name="action" value="delete">
            <c:forEach var="delete" items="${items}" varStatus="loop">
                <input id="${loop.getIndex()}" type="radio" name="itemDelete" value="${delete}"><label for="${loop.getIndex()}">${delete}</label>
                <br>
            </c:forEach>
            <input type="submit" value="Delete">
            
        </form>
       </body>
</html>
