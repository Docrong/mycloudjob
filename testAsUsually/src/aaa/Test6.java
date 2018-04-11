package aaa;

import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;


public class Test6 {
 
    public static void main(String[] args) throws UnknownHostException {
    	String sql="select m.sheetid as sheetid,m.title as title, m.maincity as city, m.maincountry as country,m.mainspecialty as specialty,case when m.maintasktype is not null then m.maintasktype else '-' end as tasktype,case when m.maintasksubtype is not null then m.maintasksubtype else '-' end as sontasktype,m.sendtime as sendtime, m.SHEETACCEPTLIMIT as acceptlimit,m.sheetcompletelimit as completelimit, thelink.operatedeptid as grouppartner, case when m.mainresname is not null then m.mainresname else '-' end as resname from pnr_commontask_main m, (select * from (select a.*, row_number() over(partition by mainid order by a.operatetime desc) cn from pnr_commontask_link a where a.operatetype = '95') where cn = 1) thelink where m.id = thelink.mainid and m.status in ('0','1')     ";

    	/*
    	 * 如果添加新的数据库前缀在(pnr|taw|partner)中添加"|表名前缀"		
    	 */
    	String regex="\\s+(pnr|taw|partner)_+[a-z]*(_?[a-z]*)*\\s";
    		   regex="select+(\\s\\S)*+from";
    	
    	Pattern pattern=Pattern.compile(regex);
		Matcher m=pattern.matcher(sql);
		while(m.find()){
			
			System.out.println(m.group());
		}
				
		
	}
}
