/**
 *
 * @author lortole
 */

package Converter;

import javax.ejb.Remote;

@Remote
public interface IConverter {
    
    public double euroToOtherCurrency(double amount , String currencyCode) ;
    
}
