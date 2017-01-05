package visitors;

import stockage.Directory;
import stockage.File;
import stockage.Link;

public class RazVisitor implements Visitor {
	
	public RazVisitor() {
		System.out.println(this.getClass());
	}

	@Override
	public void visitDirectory(Directory directory) 
	{
		//System.out.println("Directory : RazVisitor");
	}

	@Override
	public void visitDirectoryAfter(Directory directory) 
	{
		//System.out.println("Directory : RazVisitor_After");
	}

	@Override
	public void visitFile(File file) {
		//System.out.println("File : RazVisitor");
		file.setContenu("");
		
	}

	@Override
	public void visitLink(Link link) 
	{
		//System.out.println("Link : RazVisitor");
		link.setContenu("");
		
	}

}
