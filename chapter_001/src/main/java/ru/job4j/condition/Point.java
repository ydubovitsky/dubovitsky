package ru.job4j.condition;

class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        a.distanceTo(b);
		System.out.println("Расстояние до точки = " + a.distanceTo(b));
    }
	
	public double distanceTo(Point that) {
		return Math.sqrt(
				Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
		);
	}
}
