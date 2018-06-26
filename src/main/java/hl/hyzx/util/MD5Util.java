package hl.hyzx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/**
	 * 寰楀埌strSrc鐨勬枃浠禡D5淇℃伅
	 */
	public static String getMD5(String strSrc) {
		MessageDigest md = null;
		byte[] bt = strSrc.getBytes();
		String strDes = null;

		try {
			md = MessageDigest.getInstance("MD5");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strDes;
	}

	/**
	 * 浜岃鍒惰浆hex瀛楃涓�
	 */
	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

}
