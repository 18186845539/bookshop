package org.ccunix.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转化为拼音的工具类
 * 
 * @author liuyazhuang
 * 
 */
public class PinyinTool {
	HanyuPinyinOutputFormat format = null;

	public static enum Type {
		UPPERCASE, // 全部大写
		LOWERCASE, // 全部小写
		FIRSTUPPER // 首字母大写
	}

	public PinyinTool() {
		format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	public String toPinYin(String str)
			throws BadHanyuPinyinOutputFormatCombination {
		return toPinYin(str, "", Type.UPPERCASE);
	}

	public String toPinYin(String str, String spera)
			throws BadHanyuPinyinOutputFormatCombination {
		return toPinYin(str, spera, Type.UPPERCASE);
	}
	/**
	 * 将str转换成拼音，如果不是汉字或者没有对应的拼音，则不作转换 如： 明天 转换成 MINGTIAN
	 * 
	 * @param str
	 *            ：要转化的汉字
	 * @param spera
	 *            ：转化结果的分割符
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public String toPinYin(String str, String spera, Type type)
			throws BadHanyuPinyinOutputFormatCombination {
		if (str == null || str.trim().length() == 0)
			return "";
		if (type == Type.UPPERCASE)
			format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		else
			format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

		String py = "";
		String temp = "";
		String[] t;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((int) c <= 128)
				py += c;
			else {
				t = PinyinHelper.toHanyuPinyinStringArray(c, format);
				if (t == null)
					py += c;
				else {
					temp = t[0];
					if (type == Type.FIRSTUPPER)
						temp = t[0].toUpperCase().charAt(0) + temp.substring(1);
					py += temp + (i == str.length() - 1 ? "" : spera);
				}
			}
		}
		return py.trim();
	}
	public static void main(String[] args) {
		PinyinTool tool = new PinyinTool();
		Connection connection = null;
		try {
			System.out.println("刘亚壮的运行测试结果为====" + tool.toPinYin("魏建波", "", Type.LOWERCASE));
			String pinyin = tool.toPinYin("魏建波", "", Type.LOWERCASE);
			String onePinyin = pinyin.substring(0,1);
			System.out.println(onePinyin);
			HashMap<String, String> map = new HashMap<String, String>();
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dx_car", "root", "123456");
			connection.setAutoCommit(false);
			String sql="select fullname from dx_car";
		    PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				String key = rs.getString(1);
				String value = tool.toPinYin(key, "", Type.LOWERCASE).substring(0,1);
				map.put(key, value);
			}
			
			// 修改
			String sql_update = "update dx_car set name=? where fullname=?";
			Set<String> keyss =  map.keySet();
			for (Iterator<String> iterator = keyss.iterator(); iterator.hasNext();) {
				String key = iterator.next();
				PreparedStatement ps1 = connection.prepareStatement(sql_update);
				ps1.setString(1, map.get(key));
				ps1.setString(2, key);
				ps1.executeUpdate();
			}
		    connection.commit();
			System.out.println("成功...................................");
		}  catch (Exception e) {
            try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}