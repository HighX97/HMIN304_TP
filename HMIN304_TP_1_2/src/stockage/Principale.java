package stockage;
import java.util.ArrayList;

import visitors.CountVisitor;
import visitors.FindVisitor;
import visitors.RazVisitor;

public class Principale
{
	public static void main(String[] args)
	{
		/*Directory racine = new Directory("racine") ;
		Directory d1 = new Directory("JAVA") ;
		Directory d2 = new Directory("src") ;

		File f1 = new File("File.java","classe File") ;
		File f2 = new File("Principale.java","classe Principale") ;

		Symlink sl = new Symlink("mon_lien_1",f2) ;
		Symlink s2 = new Symlink("JAVA") ;

		racine.add(d1) ;
		d1.add(d2) ;
		d2.add(f1) ;
		d2.add(f2) ;
		d2.add(s2) ;
		racine.add(sl) ;

		System.out.println(racine.absoluteAdress()) ;
		System.out.println("ls : ") ;
		racine.ls() ;
		System.out.println("taille : "+racine.size()) ;
		System.out.println("\n") ;

		System.out.println(d1.absoluteAdress()) ;
		System.out.println("ls : ") ;
		d1.ls() ;
		System.out.println("taille : "+d1.size()) ;
		System.out.println("\n") ;

		System.out.println(d2.absoluteAdress()) ;
		System.out.println("ls : ") ;
		d2.ls() ;
		System.out.println("taille : "+d2.size()) ;
		System.out.println("\n") ;

		System.out.println(f1.absoluteAdress()) ;
		System.out.println("cat : ") ;
		f1.cat() ;
		System.out.println("taille : "+f1.size()) ;
		System.out.println("\n") ;

		System.out.println(sl.absoluteAdress()) ;
		System.out.println("cat : ") ;
		sl.cat() ;
		System.out.println("taille : "+sl.size()) ;
		System.out.println("\n") ;

		ArrayList<String> rechercheSimple = racine.find("JAVA") ;

		System.out.println("resultat de notre recherche simple sur JAVA dans racine : ") ;
		racine.afficheCollection(rechercheSimple) ;
		System.out.println("\n") ;

		ArrayList<String> rechercheTransitive = racine.findR("JAVA") ;

		System.out.println("resultat de notre recherche transitive sur JAVA dans racine : ") ;
		racine.afficheCollection(rechercheTransitive) ;
		System.out.println("\n") ;

		racine.remove(d1) ;

		System.out.println(racine.absoluteAdress()) ;
		System.out.println("ls : ") ;
		racine.ls() ;
		System.out.println("taille : "+racine.size()) ;
		System.out.println("\n") ;

		*/

		Directory d = new Directory("Pastis") ;
		File f = new File("Martini.class","martini") ;
		File f2 = new File("Ricard","ricard") ;
		Directory d2 = new Directory("Eau") ;
		File f3 = new File("Glaçons.class","glaçons") ;
		Directory d3 = new Directory("Jus") ;
		File f4 = new File("Jocker.class","glaçons") ;
		Directory d4 = new Directory("Blabla") ;
		File f5 = new File("Bloblo.class","bloblo") ;

		d.add(f) ;
		d.add(f2) ;
		d.add(d2) ;
			d2.add(f3) ;
		d.add(d3) ;
			d3.add(f4) ;
			d2.add(d4) ;
			d4.add(f5) ;

		prettyPrint(0, d);
		System.out.println("\n\n");
		RazVisitor vRaz = new RazVisitor();
		d.accept(vRaz);
		prettyPrint(0, d);
		System.out.println("\n\n");
		CountVisitor vCount =  new CountVisitor();
		d.accept(vCount);
		System.out.println("d count :"+vCount.getCount()); 
		FindVisitor vFind =  new FindVisitor("class");
		d.accept(vFind);
		System.out.println("FindVisitor : "+vFind.getFound());
	}

	public static void prettyPrint(int i, Directory d)
	{
		String tab = "";
		for (int j = 0; j<i;j++)
		{
			tab+="\t";
		}
		for(ElementStockage e : d.getElements())
		{
			if (e instanceof Directory)
			{
				System.out.println(tab+e.getName()+"\\");
				prettyPrint(i+1, (Directory) e);
			}
			else
			{
				System.out.println(tab+e+":"+e.getContenu());
			}
		}
	}
}
