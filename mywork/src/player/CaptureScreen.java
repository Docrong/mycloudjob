package player;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class CaptureScreen {
	public static void captureScreen(String fileName, String folder) throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		System.out.println(screenSize+","+screenRectangle);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		Rectangle ractangle = new Rectangle(0,0,600,900);
		System.out.println("ractangle-->"+ractangle);

		// 保存路径
		File screenFile = new File(fileName);
		if (!screenFile.exists()) {
			screenFile.mkdir();
		}
		File f = new File(screenFile, folder);
		ImageIO.write(image, "png", f);
		// 自动打开
//		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
//			Desktop.getDesktop().open(f);
		System.out.println(f);
		f.delete();
	}

	public static void main(String[] args) {
		try {
			String time=String.valueOf(System.currentTimeMillis());
			captureScreen("pic", time+".png");
//			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
//			String inputValue = JOptionPane.showInputDialog("Please input a value"); 
//			System.out.println(inputValue);
//			Object[] possibleValues = { "First", "Second", "Third" }; 
//			Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "Input", 
//			JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
//			System.out.println(selectedValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}