package visitors;

import java.util.ArrayList;
import java.util.List;

import stockage.Directory;
import stockage.File;
import stockage.Link;

public class FindVisitor implements Visitor
{
	protected String find;
	protected List<String> found;
	
	public List<String> getFound()
	{
		return found;
	}
	
	public FindVisitor(String find) 
	{
		this.find = find;
		found = new ArrayList<String>();
	}

	@Override
	public void visitDirectory(Directory directory) 
	{
		if (directory.getName().equalsIgnoreCase(this.find))
		{
			found.add(directory.getName());
		}
		
	}

	@Override
	public void visitDirectoryAfter(Directory directory) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitFile(File file) 
	{
		if (file.getName().equalsIgnoreCase(this.find))
		{
			found.add(file.getName());
		}
	}

	@Override
	public void visitLink(Link link) 
	{
		if (link.getName().equalsIgnoreCase(this.find))
		{
			found.add(link.getName());
		}
	}

}
