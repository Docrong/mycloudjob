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
		/*mkdir()��mkdirs()������:
		 *
		 *mkdir()ֻ�����и�Ŀ¼������´�����Ŀ¼, ����Ŀ¼��������mkdir()������ʧ��
		 *mkdirs()����Ŀ¼������ʱ,mkdirs�ᴴ����Ŀ¼����true;
		 */
	}
}
