package com.gr;

import java.io.File;

public class IOStream {
	public static void main(String[] args) {
		String filePath="/partner/uploadfile/partner/uploadfile/riskControl";
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		System.out.println(file.getAbsolutePath());
		/*mkdir()和mkdirs()的区别:
		 *
		 *mkdir()只能在有父目录的情况下创建子目录, 当父目录不在在是mkdir()创建会失败
		 *mkdirs()当父目录不存在时,mkdirs会创建父目录返回true;
		 */
	}
}
