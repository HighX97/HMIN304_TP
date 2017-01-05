package aspects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import classes.*;

aspect MoveTracking 
{
	// Aspect version 1
	private boolean flag = false;
	
	public boolean testAndClear()
	{
		boolean result = flag; 
		flag = false; 
		return result; 
	}
	

	
	pointcut moves():
	    call(Point Point.setX(int))              ||
	    call(Point Point.setY(int))              ||
		call(Line Line.setP1(Point)) || 
		call(Line Line.setP2(Point)); 
	
	before(): moves() {
	    System.out.println("[before(): move() ");
	}
	after(): moves() 
	{
		flag = true; 
		System.out.println("after(): moves()]");
	}
	public static void main (String [] arg)
	{
		List<Point> points = new ArrayList<Point>();
		List<Line> lines = new ArrayList<Line>();
		
		int nbPoints=48;
		for (int i = 0;i<nbPoints;i++)
		{
			Random r = new Random();
			int x = r.nextInt((nbPoints - 2) + 1) + 2;
			int y = r.nextInt((nbPoints - 2) + 1) + 2;
			points.add((new Point()).setX(x).setY(y));
			System.out.println(points);
		}
		
		int nbLines=nbPoints/2;
		for (int i = 0;i<nbLines;i++)
		{
			Random r = new Random();
			lines.add((new Line()).setP1(points.get(2*i)).setP2(points.get(2*i+1)));
			System.out.println(lines);
		}
		

	}
}

