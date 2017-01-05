package classes;
public class Point extends FigureElement 
{ // version 1
	private int x = 0, y = 0;
	public  int getX() { return x; }
	public int getY() { return y; }
	public Point setX(int x) { this.x = x;return this; }
	public Point setY(int y) { this.y = y;return this; } 
	
}