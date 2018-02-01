package test;

/**
 * @author lauryanncoralie
 *
 */
public class Dimension {
	private int lenght;
	private int width;
	
	public Dimension (int lenght, int width){
		this.lenght = lenght;
		this.width = width;
	}
	
	public Dimension () {
		this.lenght = 0;
		this.width = 0;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
