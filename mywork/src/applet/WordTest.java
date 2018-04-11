package applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class WordTest extends Applet implements Runnable {

	private Image image;
	private Graphics graphics;
	private Font font;
	private String str;
	private Thread thread;
	private int fontSize;
	
	public void init(){
		this.setSize(400,400);
		image=createImage(400,400);
		graphics=image.getGraphics();
		str="这是一个小程序";
		font=new Font("TimesRoman",Font.BOLD,8);
	}
	
	public void start(){
		if(thread==null){
			thread=new Thread(this);
			thread.start();
		}
	}

	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getSize().width, getSize().height);
		font=new Font("TimesRoman",Font.BOLD,fontSize);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		FontMetrics fm=graphics.getFontMetrics(font);
		int fontHeight=fm.getHeight();
		int w;
		int baseLine=getSize().height/2+fontHeight/2;
		w=fm.stringWidth(str);
		w=(getSize().width-w)/2;
		graphics.drawString(str, w, baseLine-=20);
		g.drawImage(image, 0, 0, this);
		fontSize++;
	}
	
	@Override
	public void run() {
		while(true){
			repaint();
			if(fontSize>getSize().height){
				fontSize=0;
				try{
					thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
}
