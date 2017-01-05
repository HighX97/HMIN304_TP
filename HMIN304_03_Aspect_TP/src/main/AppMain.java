package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import classes.*;

public class AppMain {
	
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
			lines.add((new Line()).setP1(points.get(2*i)).setP2(points.get(2*i+1)));
			System.out.println(lines);
		}
		

	}

}
