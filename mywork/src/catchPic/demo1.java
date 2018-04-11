package catchPic;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class demo1 {

	public static void main(String[] args) {
		
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// 获取当前屏幕大小  
	    Rectangle rectangle = new Rectangle(screenSize);// 指定捕获屏幕区域大小，这里使用全屏捕获  
	    //做好自己!--eguid，eguid的博客是:blog.csdn.net/eguid_1  
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//本地环境  
	    GraphicsDevice[] gs = ge.getScreenDevices();//获取本地屏幕设备列表  
	    System.out.println("rectangle:"+rectangle+"\nge:"+ge+rectangle.height+rectangle.width);
	    for(int i=0;i<gs.length;i++){
	    	System.out.println("gs:"+gs[i]);
	    }

	    int width = 800;  
	    int height = 600;  
	    Frame frame=new Frame("屏幕截取");
	    frame.setBounds((int) (screenSize.getWidth() - width) / 2, (int) (screenSize.getHeight() - height) / 2, width,  
	            height);// 窗口居中
//	    frame.show();
	    Timer timer=new Timer();
	    timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Point point = MouseInfo.getPointerInfo().getLocation();//获取鼠标坐标
				System.out.println("Location:x=" + point.x + ", y=" + point.y);
			}
		}, 1000, 1000);
	}
}
