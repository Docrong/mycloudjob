package robotqq;

import java.awt.AWTException;
import java.awt.KeyEventPostProcessor;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class JavaScanner {

	public static void main(String[] args) throws AWTException, IOException {
		Robot robot=new Robot();
		
		robot.delay(5000);
		for(int i=0;i<100;i++){
			
		keyPress(robot,KeyEvent.VK_W);
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_N);
		keyPress(robot,KeyEvent.VK_SPACE);
		 //输入回车
//        setSysClipboardText("不玩!滚!!"+(i+1));
//        keyPressWithCtrl(robot,KeyEvent.VK_V );
//        keyPress(robot, KeyEvent.VK_ENTER);
		}
//       keyPressWithCtrl(robot, KeyEvent.VK_SPACE);
	}
	

	public static void keyPress(Robot r,int key){
		  //按下键
        r.keyPress(key);
        //释放键
        r.keyRelease(key);

        r.delay(100);
	}

	public static void keyPressWithCtrl(Robot r,int key){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(key);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(key);
		r.delay(100);
	}
	
	/** 
     * 将字符串复制到剪切板。 
     */  
    public static void setSysClipboardText(String writeMe) {  
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();  
        Transferable tText = new StringSelection(writeMe);  
        clip.setContents(tText, null);  
    }  
    
    /** 
     * 从剪切板获得文字。 
     */  
    public static String getSysClipboardText() {  
        String ret = "";  
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();  
        // 获取剪切板中的内容  
        Transferable clipTf = sysClip.getContents(null);  
  
        if (clipTf != null) {  
            // 检查内容是否是文本类型  
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {  
                try {  
                    ret = (String) clipTf  
                            .getTransferData(DataFlavor.stringFlavor);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
  
        return ret;  
    }  
}
