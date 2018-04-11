package JavaCrawler.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static String sendGet(String url){
		String result="";
		BufferedReader in=null;
		try{
			URL realurl=new URL(url); 
			URLConnection conn=realurl.openConnection();
			conn.connect();
			in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line=in.readLine())!=null){
				result+=line;
			}
		}catch(Exception e){
			System.out.println("发送请求异常");
			e.printStackTrace();
		}finally{
			try{
				if(in!=null){
					in.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	static String RegexString(String targetStr, String patternStr)
	{
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		// 相当于埋好了陷阱匹配的地方就会掉下去
		Pattern pattern = Pattern.compile(patternStr);
		// 定义一个matcher用来做匹配
		Matcher matcher = pattern.matcher(targetStr);
		// 如果找到了
		if (matcher.find())
		{
			// 打印出结果
			return matcher.group();
		}
		return "Nothing";
	}


	
	public static void main(String[] args) {
		String url="https://www.baidu.com";
		String result=sendGet(url);
		String imgSrc = RegexString(result, "src=//(.+?)");
		// 打印结果
		System.out.println(result);
		System.out.println(imgSrc);
	}
}
