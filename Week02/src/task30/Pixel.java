package task30;

public class Pixel {
	
	private int red;
	private int green;
	private int blue;
	
	public Pixel() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}
	
	public Pixel(int red, int green, int blue) {
		try {
			if (red < 0 || red > 255) {
				throw new InvalidRGBValueException();
			}
			if (green < 0 || green > 255) {
				throw new InvalidRGBValueException();
			}
			if (blue < 0 || blue > 255) {
				throw new InvalidRGBValueException();
			}
		} catch (InvalidRGBValueException e) {
			e.printStackTrace();
		}
		
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int[] getRGB() {
		int[] result = new int[3];
		result[0] = getRed();
		result[1] = getBlue();
		result[2] = getGreen();
		return result;
	}
	
	public int getRed() {
		return red;
	}
	
	public void setRed(int newValue) throws InvalidRGBValueException {
		if (newValue < 0 || newValue > 255) {
			throw new InvalidRGBValueException();
		}
		
		red = newValue;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public void setBlue(int newValue) throws InvalidRGBValueException {
		if (newValue < 0 || newValue > 255) {
			throw new InvalidRGBValueException();
		}
		
		blue = newValue;
	}
	
	public int getGreen() {
		return green;
	}
	
	public void setGreen(int newValue) throws InvalidRGBValueException {
		if (newValue < 0 || newValue > 255) {
			throw new InvalidRGBValueException();
		}
		
		green = newValue;
	}
	
	@Override
	public String toString() {
		String result = String.format("[%03d,%03d,%03d]", red, green, blue);
		return result;
	}
}

class InvalidRGBValueException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidRGBValueException() {}
	public InvalidRGBValueException(String message) {
		super(message);
	}
};
