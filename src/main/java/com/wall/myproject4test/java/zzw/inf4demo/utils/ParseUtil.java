package com.wall.myproject4test.java.zzw.inf4demo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.lang.StringEscapeUtils;
import org.json.XML;
import org.springframework.web.util.HtmlUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtil {

	//
	public static String parseJson2Xml(String jsonStr) throws Exception {
		String xmlStr = null;
		JSONObject json = JSONObject.fromObject(jsonStr);
		XMLSerializer serializer = new XMLSerializer();
		serializer.setTypeHintsEnabled(false);
		xmlStr = serializer.write(json);
		return xmlStr;
	}

	//
	public static String parseXml2Json(String xmlStr) throws Exception {
		String jsonStr = null;
		XMLSerializer serializer = new XMLSerializer();
		jsonStr = serializer.read(xmlStr).toString();
		return jsonStr;
	}

	//
	public static String xmlLoopParse(String content,String key)throws Exception{
		String result = content;
		if(key==null || "".equals(key)){
			return result;
		}

		int index0 = 0;
		int index1 = content.indexOf("<"+key+">");
		int index2 = content.indexOf("<"+key+">")+key.length()+2;
		int index3 = content.indexOf("</"+key+">");
		int index4 = content.indexOf("</"+key+">")+key.length()+3;
		int index5 = content.length();

		if(index1 < 0){
			result = result.replaceAll("\\^"+key+"\\^",key);
			return result;
		}

		String content0 = content.substring(index0, index1);
		String content1 = content.substring(index2, index3);
		String content2 = content.substring(index4, index5);

		content1 = content1.replaceAll("\\<e", "<^"+key+"^").replaceAll("\\</e", "</^"+key+"^");
		result = content0 + content1 + content2;
		result = xmlLoopParse(result,key);

		return result;
	}

	public static String xmlReplaceKey(String content,String orgKey,String tarKey) throws Exception{
		content = content.replaceAll("\\<"+orgKey+"\\>", "<"+tarKey+">");
		content = content.replaceAll("\\</"+orgKey+"\\>", "</"+tarKey+">");
		return content;

	}
	//
	public static String xmlRoughParse(String content, String key) throws Exception {
		String result = null;
		content = StringEscapeUtils.unescapeHtml(content);
		content = HtmlUtils.htmlUnescape(content);
		content = content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		content = content.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"no\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\"\\?\\>", "");

		content = content.replaceAll("\\r\\n", "");
		content = content.replaceAll("\\n", "");
		content = content.trim();
		content = content.replaceAll("\\<\\s+", "<");
		content = content.replaceAll("\\</\\s+", "</");
		content = content.replaceAll("\\s+\\>", ">");
		content = content.replaceAll("\\>\\s+", ">");
		content = content.replaceAll("\\s+\\<", "<");
		content = content.replaceAll("\\s+", " ");


		if (key == null || "".equals(key)) {
			return content;
		}
		int startIndex = content.indexOf("<" + key + ">");
		int endIndex = content.indexOf("</" + key + ">");
		if (startIndex < 0 || endIndex <= 0 || endIndex <= startIndex) {
			return result;
		}
		result = content.substring(startIndex + key.length() + 2, endIndex);
		return result;
	}
	public static String xmlRoughParseNoCdata(String content, String key) throws Exception {
		String result = null;
		content = StringEscapeUtils.unescapeHtml(content);
		content = HtmlUtils.htmlUnescape(content);
		content = content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		//content = content.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"no\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\"\\?\\>", "");

		content = content.replaceAll("\\r\\n", "");
		content = content.replaceAll("\\n", "");
		content = content.trim();
		content = content.replaceAll("\\<\\s+", "<");
		content = content.replaceAll("\\</\\s+", "</");
		content = content.replaceAll("\\s+\\>", ">");
		content = content.replaceAll("\\>\\s+", ">");
		content = content.replaceAll("\\s+\\<", "<");
		content = content.replaceAll("\\s+", " ");


		if (key == null || "".equals(key)) {
			return content;
		}
		int startIndex = content.indexOf("<" + key + ">");
		int endIndex = content.indexOf("</" + key + ">");
		if (startIndex < 0 || endIndex <= 0 || endIndex <= startIndex) {
			return result;
		}
		result = content.substring(startIndex + key.length() + 2, endIndex);
		return result;
	}
	public static String xmlRoughParseNoEscape(String content, String key) throws Exception {
		String result = null;
		content = content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		content = content.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"no\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\"\\?\\>", "");

		content = content.replaceAll("\\r\\n", "");
		content = content.replaceAll("\\n", "");
		content = content.trim();
		content = content.replaceAll("\\<\\s+", "<");
		content = content.replaceAll("\\</\\s+", "</");
		content = content.replaceAll("\\s+\\>", ">");
		content = content.replaceAll("\\>\\s+", ">");
		content = content.replaceAll("\\s+\\<", "<");
		content = content.replaceAll("\\s+", " ");


		if (key == null || "".equals(key)) {
			return content;
		}
		int startIndex = content.indexOf("<" + key + ">");
		int endIndex = content.indexOf("</" + key + ">");
		if (startIndex < 0 || endIndex <= 0 || endIndex <= startIndex) {
			return result;
		}
		result = content.substring(startIndex + key.length() + 2, endIndex);
		return result;
	}

	public static String xmlReplaceE(String content) throws Exception {
		content = content.replaceAll("\\<e\\>", "");
		content = content.replaceAll("\\</e\\>", "");
		return content;

	}

	public static String xmlLoopParseIncludeEmpty(String content, String key) throws Exception {
		String result = content;
		if(key==null || "".equals(key)){
			return result;
		}

		int index0 = 0;
		int index1 = content.indexOf("<"+key+">");
		int index2 = content.indexOf("<"+key+">")+key.length()+2;
		int index3 = content.indexOf("</"+key+">");
		int index4 = content.indexOf("</"+key+">")+key.length()+3;
		int index5 = content.length();

		if(index1 < 0){
			result = result.replaceAll("\\^"+key+"\\^",key);
			return result;
		}

		String content0 = content.substring(index0, index1);
		String content1 = content.substring(index2, index3);
		String content2 = content.substring(index4, index5);

		content1 = content1.replaceAll("\\<e", "<^"+key+"^").replaceAll("\\</e", "</^"+key+"^");
		result = content0 + content1 + content2;
		result = xmlLoopParseIncludeEmpty(result,key);

		return result;
	}


	public static String xmlReplaceFirstSmallLetter(String xml) {
		String[] letters = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
		for (String l : letters) {
			String smallLetterStart = "<" + l;
			String smallLetterEnd = "</" + l;
			xml = xml.replaceAll(smallLetterStart, smallLetterStart.toUpperCase());
			xml = xml.replaceAll(smallLetterEnd, smallLetterEnd.toUpperCase());
		}
		return xml;
	}

	public static String xmlReplaceFirstBigLetter(String xml) {
		String[] letters = new String[]{"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
		for (String l : letters) {
			String smallLetterStart = "<" + l;
			String smallLetterEnd = "</" + l;
			xml = xml.replaceAll(smallLetterStart, smallLetterStart.toLowerCase());
			xml = xml.replaceAll(smallLetterEnd, smallLetterEnd.toLowerCase());
		}
		return xml;
	}

	public static String jsonObjectKey(JSONObject jsonStr1, String toSmallOrBig) {
		JSONObject jsonStr2 = new JSONObject();
		Iterator it = jsonStr1.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			String key1 = key.substring(0, 1);
			String key2 = key.substring(1, key.length());
			Object object = jsonStr1.get(key);
			if ("toSmall".equals(toSmallOrBig)) {
				if (object.getClass().toString().endsWith("String")) {
					jsonStr2.accumulate(key1.toLowerCase() + key2, object);
				} else if (object.getClass().toString().endsWith("JSONObject")) {
					jsonStr2.accumulate(key1.toLowerCase() + key2, jsonObjectKey((JSONObject) object, toSmallOrBig));
				} else if (object.getClass().toString().endsWith("JSONArray")) {
					jsonStr2.accumulate(key1.toLowerCase() + key2, jsonArrayKey(jsonStr1.getJSONArray(key), toSmallOrBig));
				}
			} else if ("toBig".equals(toSmallOrBig)) {
				if (object.getClass().toString().endsWith("String")) {
					jsonStr2.accumulate(key1.toUpperCase() + key2, object);
				} else if (object.getClass().toString().endsWith("JSONObject")) {
					jsonStr2.accumulate(key1.toUpperCase() + key2, jsonObjectKey((JSONObject) object, toSmallOrBig));
				} else if (object.getClass().toString().endsWith("JSONArray")) {
					jsonStr2.accumulate(key1.toUpperCase() + key2, jsonArrayKey(jsonStr1.getJSONArray(key), toSmallOrBig));
				}
			}

		}
		return jsonStr2.toString();
	}

	public static String jsonArrayKey(JSONArray jsonStr1, String toSmallOrBig) {
		JSONArray jsonStr2 = new JSONArray();
		for (int i = 0; i < jsonStr1.size(); i++) {
			Object jArray = jsonStr1.getJSONObject(i);
			if (jArray.getClass().toString().endsWith("JSONObject")) {
				jsonStr2.add(jsonObjectKey((JSONObject) jArray, toSmallOrBig));
			} else if (jArray.getClass().toString().endsWith("JSONArray")) {
				jsonStr2.add(jsonArrayKey((JSONArray) jArray, toSmallOrBig));
			}
		}
		return jsonStr2.toString();
	}

	public static String loadFile(URL url) throws Exception {
		String charset = "UTF-8";//响应报文模板的编码
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = reader.readLine();
		while (temp != null) {
			sb.append(temp + " ");
			temp = reader.readLine();
		}
		reader.close();
		String data = sb.toString();
		return data;
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}


	public static String xmlRoughParseEx(String content, String key) throws Exception {
		StringBuffer result = new StringBuffer("<" + key + ">");
		String xmlPough = xmlRoughParse(content, key);
		result = result.append(xmlPough + "</" + key + ">");
		String afterParse = new String(result);
		return afterParse;
	}

	/**
	 * xml标签首字母变大写
	 *
	 * @param xmlStr
	 * @return
	 */
	public static String xmlTagInitialsUpper(String xmlStr) {
		xmlStr = StringEscapeUtils.unescapeHtml(xmlStr);
		xmlStr = xmlStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		xmlStr = xmlStr.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\"\\?\\>", "");

		xmlStr = xmlStr.replaceAll("\\r\\n", "");
		xmlStr = xmlStr.replaceAll("\\n", "");
		xmlStr = xmlStr.trim();
		xmlStr = xmlStr.replaceAll("\\<\\s+", "<");
		xmlStr = xmlStr.replaceAll("\\</\\s+", "</");
		xmlStr = xmlStr.replaceAll("\\s+\\>", ">");
		xmlStr = xmlStr.replaceAll("\\>\\s+", ">");
		xmlStr = xmlStr.replaceAll("\\s+\\<", "<");
		xmlStr = xmlStr.replaceAll("\\s+", " ");
		String regex = "<(/*[A-Za-z]+)>";
		regex = "<([^>]*)>";
		Matcher matcher = Pattern.compile(regex).matcher(xmlStr);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String str = matcher.group(1);
			if (!str.startsWith("/")) {
//				matcher.appendReplacement(sb, "<" + (StringUtils.capitalize (str)) + ">");
				matcher.appendReplacement(sb, "<" + (str.substring(0, 1).toUpperCase()) + (str.substring(1)) + ">");
			} else {
//				matcher.appendReplacement(sb, "</" + (StringUtils.capitalize (str.substring(1, str.length()))) + ">");
				matcher.appendReplacement(sb, "</" + (str.substring(1, 2).toUpperCase()) + (str.substring(2)) + ">");
			}

		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * xml标签首字母变小写
	 *
	 * @param xmlStr
	 * @return
	 */
	public static String xmlTagInitialsLower(String xmlStr) {
		xmlStr = StringEscapeUtils.unescapeHtml(xmlStr);
		xmlStr = xmlStr.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		xmlStr = xmlStr.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GB2312\"\\?\\>", "");
		xmlStr = xmlStr.replaceAll("\\<\\?xml version=\"1.0\"\\?\\>", "");

		xmlStr = xmlStr.replaceAll("\\r\\n", "");
		xmlStr = xmlStr.replaceAll("\\n", "");
		xmlStr = xmlStr.trim();
		xmlStr = xmlStr.replaceAll("\\<\\s+", "<");
		xmlStr = xmlStr.replaceAll("\\</\\s+", "</");
		xmlStr = xmlStr.replaceAll("\\s+\\>", ">");
		xmlStr = xmlStr.replaceAll("\\>\\s+", ">");
		xmlStr = xmlStr.replaceAll("\\s+\\<", "<");
		xmlStr = xmlStr.replaceAll("\\s+", " ");
		String regex = "<(/*[A-Za-z]+)>";
		regex = "<([^>]*)>";
		Matcher matcher = Pattern.compile(regex).matcher(xmlStr);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String str = matcher.group(1);
			if (!str.startsWith("/")) {
				matcher.appendReplacement(sb, "<" + (str.substring(0, 1).toLowerCase()) + (str.substring(1)) + ">");
			} else {
				matcher.appendReplacement(sb, "</" + (str.substring(1, 2).toLowerCase()) + (str.substring(2)) + ">");
			}

		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	public  static String xmlUpperOnlyTagkey(String xml, String key) throws Exception {
		String tagKeyxml = xmlRoughParseEx(xml, key);
		String UpperTagKeyxml = xmlTagInitialsUpper(tagKeyxml);
		String regex = "<"+ key +">(.*?)</"+ key +">";
		xml = xml.replaceAll(regex, UpperTagKeyxml);
		return xml;
	}

	public static String soapXmlRoughParse(String content, String key) throws Exception {
		String result = null;
		content = StringEscapeUtils.unescapeHtml(content);
		content = content.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
		content = content.replaceAll("\\<!\\[CDATA\\[", "").replaceAll("\\]\\]\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>", "");
		content = content.replaceAll("\\<\\?xml version=\"1.0\" encoding=\"GBK\"\\?\\>", "");

		content = content.replaceAll("\\r\\n", "");
		content = content.replaceAll("\\n", "");
		content = content.trim();
		content = content.replaceAll("\\<\\s+", "<");
		content = content.replaceAll("\\</\\s+", "</");
		content = content.replaceAll("\\s+\\>", ">");
		content = content.replaceAll("\\>\\s+", ">");
		content = content.replaceAll("\\s+\\<", "<");
		content = content.replaceAll("\\s+", " ");


		if (key == null || "".equals(key)) {
			return content;
		}
		int startIndex = content.indexOf("<" + key);
		int endIndex = content.indexOf("</" + key + ">");
		if (startIndex < 0 || endIndex <= 0 || endIndex <= startIndex) {
			return result;
		}
		result = content.substring(startIndex + key.length() + 2, endIndex);
		startIndex = result.indexOf(">");
		result = result.substring(startIndex + 1, result.length());
		return result;
	}

	public static String xml2Json(String xml) throws Exception{
		org.json.JSONObject xmlJSONObj = XML.toJSONObject(xml);

		return xmlJSONObj.toString();
	}

	/**
	 * java生成随机数字和字母组合10位数
	 * @param length[生成随机数的长度]
	 * @return
	 */
	public static String getRandomNickname(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
//	public static String parseXmlTagToLowerCase(String xml) {
//		if(xml==null) {
//			throw new IllegalArgumentException("the arg xml must not be null");
//		}
//		if(StringUtils.isBlank(xml)) {
//			return xml;
//		}
//		StringBuilder sb = new StringBuilder(xml);
//		//TODO
//	}
//	
}
