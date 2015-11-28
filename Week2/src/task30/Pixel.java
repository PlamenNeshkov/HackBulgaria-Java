package task30;

public class Pixel {
	private short red;
	private short green;
	private short blue;
	
	public Pixel() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}
	
	public Pixel(short red, short green, short blue) {
		if (red < 0 || red > 255) {
			//throw exception
		}
		if (green < 0 || green > 255) {
			//throw exception
		}
		if (blue < 0 || blue > 255) {
			//throw exception
		}
		
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public short[] getRGB() {
		short[] result = new short[3];
		result[0] = getRed();
		result[1] = getBlue();
		result[2] = getGreen();
		return result;
	}
	
	public short getRed() {
		return red;
	}
	
	public short getBlue() {
		return blue;
	}
	
	public short getGreen() {
		return green;
	}
}
