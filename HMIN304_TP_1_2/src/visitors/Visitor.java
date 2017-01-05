package visitors;

import stockage.Directory;
import stockage.File;
import stockage.Link;

public interface Visitor 
{

	public void visitDirectory(Directory directory);
	
	public void visitDirectoryAfter(Directory directory);

	public void visitFile(File file);

	public void visitLink(Link link);

}
