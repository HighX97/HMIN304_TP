
public class PrettyPrintVisitor
{

	private String print ="";

	public void visitDirectory(Directory directory)
	{
		print += directory.getName();
		print +="\n";

		for (ElementStockage e : directory.elements)
		{
			print +="\t";
			e.accept(this);
		}
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
