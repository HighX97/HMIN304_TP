package visitors;

import stockage.Directory;
import stockage.ElementStockage;
import stockage.File;
import stockage.Link;

/*
 * CountVisitor : 
 * Une des questions que pose le sch ́ema “visiteur” est de savoir comment rendre des r ́esultats. 
 * Pour travailler cet exercice, on se propose d’ ́ecrire un visiteur capable de donner le nombre
 * de fichiers dans un r ́epertoire dont la taille d ́epasse la taille de 10 caract`eres.
 * Pour cela, r ́ealiser un visiteur `a qui l’on puisse demander en premier lieu de visiter
 * r ́ecursivement un r ́epertoire pour faire le comptage et auquel on puisse ensuite envoyer
 * le message getCount() qui rende le nombre calcul ́e.
 */
public class CountVisitor implements Visitor 
{
	protected int count;
	public CountVisitor()
	{
		count=0;
	}
	
	@Override
	public void visitDirectory(Directory directory) 
	{
		count++;
	}

	@Override
	public void visitDirectoryAfter(Directory directory) 
	{
	}

	@Override
	public void visitFile(File file) 
	{
		if (file.getContenu().length() < 10)
		{
			count++;
		}
	}

	@Override
	public void visitLink(Link link) 
	{
	}
	
	public int getCount() 
	{
		int rslt = count;
		count =0;
		return rslt;
	}

}
