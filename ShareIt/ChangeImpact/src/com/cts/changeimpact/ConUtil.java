package com.cts.changeimpact;

import java.util.ArrayList;
import java.util.Properties;

public class ConUtil {
	
	static ArrayList<String> invalidChars = new ArrayList<String>();

	static {
		invalidChars.add("_");
		invalidChars.add(" ");
		invalidChars.add("'");
		invalidChars.add("\"");
		invalidChars.add(";");
		invalidChars.add(":");
		invalidChars.add("}");
		invalidChars.add("{");
		invalidChars.add("]");
		invalidChars.add("[");
		invalidChars.add("=");
		invalidChars.add("+");
		invalidChars.add("*");
		invalidChars.add("&");
		invalidChars.add("^");
		invalidChars.add("%");
		invalidChars.add("#");
		invalidChars.add("@");
	}
	
	public static boolean checkContainValue(String originalstr,
			String containStr) {

		boolean flag = false;

		String original = originalstr.substring(
				originalstr.lastIndexOf(".") + 1, originalstr.length());

		if (original.contains(containStr)) {
			flag = true;
		}

		return flag;
	}
	
	public static boolean isValid(String str) {

		boolean isValid = true;
 
		if (str != null) {

			for (String temp : invalidChars) {

				if (str.indexOf(temp) > -1) {
					isValid = false;
					break;
				}
			}

		} else {
			isValid = false;
		}

		return isValid;

	}
	
	public static Properties loadProperty(String fileName)
			throws BaseException, NoFileException {

		return PropertyManager.loadProperties(fileName);

	}

}
