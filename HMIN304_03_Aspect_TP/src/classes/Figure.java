package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Figure 
{
	List<Point> points;
	List<Line> lines;

	Figure()
	{
		points = new ArrayList<Point>();
		lines = new ArrayList<Line>();
	}
	
	public Point makePoint()
	{
		return new Point();
	}
	
	public Line makeLine()
	{
		return new Line();
	}

}
