package player.ocr;

import java.io.File;
import java.io.IOException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	public static void main(String[] args) throws TesseractException, IOException {
		
		File imageFile=new File("pic");
		System.out.println(imageFile.getCanonicalPath());
		if(!imageFile.exists()){
		System.out.println("图片不存在"); 
		}
		Tesseract instance=Tesseract.getInstance();
		instance.setDatapath("C:\\ProgramFiles(x86)\\Tesseract-OCR\\tessdata");//设置训练库的位置
		instance.setLanguage("chi_sim");//中文识别
		String result=instance.doOCR(imageFile);
		System.out.println(result);
	}
}
