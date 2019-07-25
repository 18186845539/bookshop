package org.ccunix.javaweb.util;

import java.io.UnsupportedEncodingException;

public class CharacterUtil {

	public static String parseString(String string,String srcCharset,String descCharset){
		String str=null;
		try {
			byte[] bs = string.getBytes(srcCharset);
			str = new String(bs, descCharset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
}
