package JavaCrawler.demo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderClaws {

	 // 地址
    private static final String URL = "http://www.tooopen.com/view/1439719.html";
    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "[a-zA-z]+://[^\\s]*";
	
	public static void main(String[] args) throws IOException {
		 SpiderClaws sc=new SpiderClaws();
        
		 String HTML = sc.getHTML(URL);
		 List<String> imgUrl = sc.getImageUrl(HTML);
         //获取图片src地址
         List<String> imgSrc = sc.getImageSrc(imgUrl);
         //下载图片
         sc.Download(imgSrc);
	}
	
	
	private String getHTML(String URL) throws IOException {
		URL url=new URL(URL);
		URLConnection conn=url.openConnection();
		InputStream in=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(isr);
		
		String line;
		StringBuffer sb=new StringBuffer();
		while((line=br.readLine())!=null){
			sb.append(line,0,line.length());
			sb.append("\n");
		}
		br.close();
		in.close();
		isr.close();
		return sb.toString();
	}
	
	private List getImageUrl(String html){
		Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(html);
		List imageUrlList=new ArrayList();
		while(matcher.find()){
			imageUrlList.add(matcher.group());
		}
		return imageUrlList;
		
	}
	
	private List getImageSrc(List<String> imageURLList){
		List imageSrcList=new ArrayList<>();
		for (String image:imageURLList){
            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()){
            	imageSrcList.add(matcher.group().substring(0, matcher.group().length()-1));
            }
        }
        return imageSrcList;
    }
	
	 //下载图片
    private void Download(List<String> listImgSrc) {
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc){
            	String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
//                URL uri = new URL(url);
            	System.out.println(""+url);
            }
            for (String url : listImgSrc) {
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();
                FileOutputStream fo = new FileOutputStream(new File("src/res/"+imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
