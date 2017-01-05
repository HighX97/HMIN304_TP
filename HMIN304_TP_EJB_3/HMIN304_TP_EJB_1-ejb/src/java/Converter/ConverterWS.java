/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author lortole
 */
@WebService(serviceName = "ConverterWS")
@Stateless()
public class ConverterWS {
    @EJB
    private IConverter ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "euroToOtherCurrency")
    public double euroToOtherCurrency(@WebParam(name = "amount") double amount, @WebParam(name = "currencyCode") String currencyCode) {
        return ejbRef.euroToOtherCurrency(amount, currencyCode);
    }

    @WebMethod(operationName = "euroToOtherCurrencies")
    public Map<Monnaie, Double> euroToOtherCurrencies(@WebParam(name = "amount") double amount) {
        return ejbRef.euroToOtherCurrencies(amount);
    }
    
}
