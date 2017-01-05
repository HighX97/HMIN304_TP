package classes;
public class Line extends FigureElement { // version 1
	private Point p1, p2;
	public Point getP1() { 
		return p1; 
		}
	public Point getP2() { 
		return p2; 
		}
	public Line setP1(Point p1) { 
		p1 = p1; 
		return this; 
		}
	public Line setP2(Point p2) { 
		p2 = p2; 
		return this; 
		} 
	}