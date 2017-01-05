<%@page import="Converter.Monnaie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <p>Enter an amount to convert:</p>
        <form method="get" action="converter.jsp">
        Amount : <input type="text" name="amount" size="25"> <br>
        Currency : <select name="money">
        <jsp:useBean class="Converter.ConverterBean" id="beanConv"/>
        <% 
        for (String s : beanConv.exploreCurrenicesProvider())
        {
          %>
          <option value= <%=s%> > <%= s %> </option>
        <% 
           } 
        %>
        </select>
        <br>
         Mail : <input type="text" name="email" size="25"> <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
        </form>
    </body>
</html>
