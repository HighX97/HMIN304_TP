/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author lortole
 */
@Remote
public interface IConverter {
    
    public double euroToOtherCurrency(double amount , String currencyCode);

    public Map<Monnaie, Double>  euroToOtherCurrencies(double amount);
    
}
