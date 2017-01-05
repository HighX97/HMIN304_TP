package client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import Converter.*;

public class Client {
	
	public static void main(String [] args)
	{
		InitialContext context=null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			IConverter converter = (IConverter) context.lookup(
					"java:global/HMIN304_TP_EJB_1/HMIN304_TP_EJB_1-ejb/ConverterBean");
					//"ejb/ConverterBean");
			System.out.println(converter.euroToOtherCurrency(200, "RON"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello World");
	}

}
