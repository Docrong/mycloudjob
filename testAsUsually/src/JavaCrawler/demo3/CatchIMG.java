package JavaCrawler.demo3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/** 
 * @ClassName: CatchIMG 
 * @Description: 爬取一个指定地址的网络图片
 * @author penny
 * @date 2017年12月3日 下午9:00:05 
 * 
 */
public class CatchIMG {

    /**
     * 
     * @Title: getImg 
     * @Description: 通过一个url 去获取图片
     * @param @param url 图片的连接地址
     * @param @throws IOException    
     * @throws
     */
    public static void getImg(String url) throws IOException{
        long startTime = System.currentTimeMillis();
        URL imgURL = new URL(url.trim());//转换URL
        HttpURLConnection urlConn = (HttpURLConnection) imgURL.openConnection();//构造连接
        urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36");
        urlConn.connect();
        System.out.println(CatchIMG.class.toString()+":获取连接="+urlConn.getResponseMessage());
        if(urlConn.getResponseCode()==200){//返回的状态码是200 表示成功
            InputStream ins = urlConn.getInputStream(); //获取输入流,从网站读取数据到 内存中
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("TEST.jpg")));
            int len=0;
            byte[] buff = new byte[1024*10];//10k缓冲流 视你内存大小而定咯
            
            while(-1!=(len=(new BufferedInputStream(ins)).read(buff))){//长度保存到len,内容放入到 buff
                out.write(buff, 0, len);//将图片数组内容写入到图片文件
//              System.out.println(CatchIMG.class.toString()+":"+len+"byte已经写入到文件中，内容:  "+new String(buff));
            }
            urlConn.disconnect();
            ins.close();
            out.close();
            System.out.println(CatchIMG.class.toString()+"：获取图片完成,耗时="+((System.currentTimeMillis()-startTime)/1000)+"s");
        }
    }
    /**
     * @throws IOException  
     * @Title: main 
     * @Description: 测试方法
     * @throws 
     */
    public static void main(String[] args) throws IOException {
        CatchIMG.getImg("https://files.cnblogs.com/files/humi/wc.bmp");//
    }

}