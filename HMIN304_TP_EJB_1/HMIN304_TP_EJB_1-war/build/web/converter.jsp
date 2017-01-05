<%-- 
    Document   : converter
    Created on : 12 oct. 2016, 10:58:16
    Author     : lortole
--%>

<%@page import="Converter.*"%>
<%@page import="java.util.Map.Entry"%>>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converter</title>
    </head>
    <body>
        <jsp:useBean class="Converter.ConverterBean" id="beanConv"/>
        <% 
        String amount = request.getParameter("amount");
        String money = request.getParameter("money");
        if ( amount != null && amount.length() > 0 && money != null && money.length() > 0 ) 
        {
            String m = money;
            // Convertir le montant en double ...
            Double d = new Double (amount);
            // Effectuer la conversion du montant dans la monnaie cible
            // en sollicitant le bean session, puis afficher le résultat
            Double rslt = beanConv.euroToOtherCurrency(d.doubleValue(),m) ;%> 
            <p>
            <%= amount %> Euros  = <%= rslt %> <%= money %>.
            </p>
        <% 
           String email = request.getParameter("email");
if(email != null && email.length() != 0) {
// Demander au MDB de déclencher la demande de conversion
// dans toutes les monnaies par le bean session
// le MDB va ensuite envoyer un email avec toutes
// ces informations au format HTML (dans un tableau HTML)
// (voir plus loin ce que doivent faire les beans) ...
}
           %>
           Mail : <%= email %>
        <%
        Map<Monnaie,Double> list_rslt = beanConv.euroToOtherCurrencies(d.doubleValue());                         
        %>
         <table style="width:100%">
  <caption>Currency - Amount</caption>
  <tr>
    <th>Currency</th>
    <th>Amount</th>
  </tr>
    <% 
          for(Entry<Monnaie,Double> entry : list_rslt.entrySet()) 
          {
    String key = entry.getKey().getCode_monnaie();
    Double value = entry.getValue();
%>
    <tr>
    <td><%=key%></td>
    <td><%=value%></td>
    </tr>
    <% 
    // do what you have to do here
    // In your case, an other loop.
            }
          }
        %>
</table>
    </body>
</html>



