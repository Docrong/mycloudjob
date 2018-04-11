package aaa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dd {

	public static void main(String[] args) {
		
		  String str = "15812345131s15812345672a15812345133s15812345674a15812345135s15812345676a";
	        Pattern p = Pattern.compile("1[358]\\d{9}");
	        Matcher m = p.matcher(str);        
	        while(m.find()){
	            System.out.println(m.group());
	            m.find();
	       }
	}
}
