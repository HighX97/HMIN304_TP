package stockage;

public class DictionaryExaminer {
	
	public int getCount(Directory d){
		System.out.println("surcharge1");
		int count = 0;
		for (ElementStockage s : d.getElements()){
			count = count + 1;
			// count = count + this.getCount(s); // invoque syst�matiquement l'autre
			if (s instanceof Directory)
				count = count + this.getCount((Directory)s);
		}
		return count;
	}
	
	public int getCount(File f){
		System.out.println("surcharge2" + f);
		return(0);
	}

}
