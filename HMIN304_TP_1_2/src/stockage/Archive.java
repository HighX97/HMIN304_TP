package stockage;
import java.util.HashMap;

public class Archive extends Directory implements IArchive
//classe repr�sentant une archive. (Elle h�rite de Directory car elle poss�de toutes les caract�ristiques d'un dossier : surtout la manipulation de collection qui permet la r�utilisation de m�thodes.
{
	public Archive(String nom)
	{
		super(nom) ;
	}
	
	public HashMap getContent()
	{
		HashMap<String,ElementStockage> map = new HashMap<String,ElementStockage>() ;
		
		for (ElementStockage s : elements)
		{
			map.put(s.absoluteAdress(),s) ;
		}
		
		return map ;
	}
	
	public void extract()
	{
		for (ElementStockage s : elements)
		{
			s.parent.add(s) ;
		}
	}
	
	
}
