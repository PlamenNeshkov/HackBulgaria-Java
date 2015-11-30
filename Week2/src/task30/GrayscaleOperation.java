package task30;

public class GrayscaleOperation implements MatrixOperation {

	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		Pixel curr = matrix[x][y];
		
		int red = curr.getRed();
		int green = curr.getGreen();
		int blue = curr.getBlue();
		int average = (red + green + blue) / 3;
		
		Pixel grayscaled = new Pixel(average, average, average);
		return grayscaled;
	}
}
