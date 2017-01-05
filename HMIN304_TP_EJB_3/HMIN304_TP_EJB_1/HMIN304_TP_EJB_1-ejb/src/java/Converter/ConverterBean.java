/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import org.jdom2.Attribute;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author lortole
 */
@Stateless
//@Stateless(mappedName="ejb/ConverterBean")
@Remote(IConverter.class)
public class ConverterBean implements IConverter 
{

    @Override
    public double euroToOtherCurrency(double amount, String currencyCode) 
    {
        try {
            return amount * exploreXml(currencyCode);
        } catch (JDOMException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount ;
    }
    
        @Override
    public Map<Monnaie, Double> euroToOtherCurrencies(double amount) 
    {
        Map<Monnaie, Double> resultat = new HashMap<Monnaie, Double>();
        try {
            
            List currencies = getAllCurrencies();
            for (int i=0 ; i< currencies.size() ; i++)
            {
                Monnaie m =  new Monnaie();
                String currency = currencies.get(i).toString();
                m.setCode_monnaie(currency);
                resultat.put(m, euroToOtherCurrency(amount,currency));
            }
            return resultat;
        } catch (JDOMException ex) {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
    }
    
    static double exploreXml(String currencyCode) throws JDOMException
    {
        SAXBuilder sxb;
        sxb = new SAXBuilder();
        URL url = null;
        try {
            url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
                   
        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("url = new URL(\"http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml\");");
        }
        Document document = null;
        try {
                document = sxb.build(url);
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("document = sxb.build(url)Exception");
            }
        Element racine = document.getRootElement();
        Namespace ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
        Element elem = racine.getChild("Cube", ns );
        Element elem1 = elem.getChild("Cube", ns );
        for (Element e : elem1.getChildren())
        {
            if (e.getAttribute("currency") != null && e.getAttribute("rate") != null)
            {
                if (e.getAttribute("currency").getValue().equalsIgnoreCase(currencyCode))
                {
                    return e.getAttribute("rate").getFloatValue();
                }
            }
        }
        return 1;
    }
    
    public List<String> getAllCurrencies() throws JDOMException
    {
        List<String> currencies = new ArrayList<String>();
        SAXBuilder sxb;
        sxb = new SAXBuilder();
        URL url = null;
        try {
            url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
                   
        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("url = new URL(\"http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml\");");
        }
        Document document = null;
        try {
                document = sxb.build(url);
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(ConverterBean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("document = sxb.build(url)Exception");
            }
        Element racine = document.getRootElement();
        Namespace ns = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
        Element elem = racine.getChild("Cube", ns );
        Element elem1 = elem.getChild("Cube", ns );
        for (Element e : elem1.getChildren())
        {
            if (e.getAttribute("currency") != null && e.getAttribute("rate") != null)
            {
                currencies.add(e.getAttribute("currency").getValue());
            }
        }
        return currencies;
    }






}
