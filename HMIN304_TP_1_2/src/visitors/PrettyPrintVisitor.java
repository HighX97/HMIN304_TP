
public class PrettyPrintVisitor
{

	private String print ="";
	private int indent=0;

	public void visitDirectory(Directory directory)
	{
		//Indentation
		String tabulation="";
		for (int i = 0 ; i < indent ; i++ )
		{
			tabulation+="\t";
		}

		print += directory.getName();
		print +="\n";

		indent++;
		tabulation+="\t";
		for (ElementStockage e : directory.elements)
		{
			print +=tabulation;
			e.accept(this);
		}

		indent--;
	}

	public void visitFile(File file)
	{
		print += file.getName();
		print +="\n";
	}

	public void visitLink(Link link)
	{
		print += link.getName();
		print +="\n";
	}

}
