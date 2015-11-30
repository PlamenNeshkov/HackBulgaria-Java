package task30;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Matrix {
	String path;
	private Pixel[][] matrix;
	
	public Matrix(String path) {
		this.path = path;
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		matrix = new Pixel[image.getWidth()][image.getHeight()];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Color currPixel = new Color(image.getRGB(i, j));
				
				int red = currPixel.getRed();
				int green = currPixel.getGreen();
				int blue = currPixel.getBlue();
				
				matrix[i][j] = new Pixel(red, green, blue);
			}
		}
	}
	
	public void operate(MatrixOperation op) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = op.withPixel(i, j, matrix);
			}
		}
	}
	
	public void write(String newPath) {
		String extension = path.substring(path.lastIndexOf(".")).toUpperCase();
		String newExtension = newPath.substring(newPath.lastIndexOf(".")).toUpperCase();
		if (!extension.equals(newExtension)) {
			try {
				throw new Exception("Extension mismatch");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		BufferedImage output = new BufferedImage(matrix.length, matrix[0].length, 
				                                 BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < output.getWidth(); i++) {
			for (int j = 0; j < output.getHeight(); j++) {
				Pixel current = matrix[i][j];
				
				int red = current.getRed();
				int green = current.getGreen();
				int blue = current.getBlue();
				
				output.setRGB(i, j, new Color(red, green, blue).getRGB());
			}
		}
		
		File newImage = new File(newPath);
		try {
			ImageIO.write(output, extension, newImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		this.write(path);
	}
	
	@Override
	public String toString() {
		StringBuilder imageStr = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				imageStr.append(matrix[i][j]);
			}
			imageStr.append(System.lineSeparator());
		}
		return imageStr.toString();
	}
}
