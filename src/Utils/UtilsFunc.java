package Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsFunc {
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(?:\\.\\d+)?");
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static String standardizeString(String string) {
		return isEmpty(string) ? ""
				: string.trim().replaceAll("&quot;", "\"").replaceAll("\\s{2,}", "\\s").replaceAll("&nbsp;", " ")
						.replaceAll("&apos;", "\'").replaceAll("&amp;", "&").replaceAll("&lt;", "<")
						.replaceAll("&gt;", ">");
	}

	/**
	 * Example : <div d = "linh">hehe
	 * <p>
	 * kekek
	 * </p>
	 * </div> return linh kekek
	 * 
	 * @param string
	 * @param replaceBy
	 * @return
	 */
	public static String replaceTagHtmlByString(String string) {
		string = Pattern.compile("<\\w+(?:\\s*[a-zA-Z0-9. _*:+!,?\\-/\"'#=;$%^&~`|()]+)?>", Pattern.DOTALL)
				.matcher(string).replaceAll("; ");
		string = string.replaceAll("<\\/\\w+>", "\n");
		return standardizeString(string);
	}

	/**
	 * Example : <div d = "linh"></div> return linh
	 * 
	 * @param tag
	 * @param attr
	 * @return
	 */
	public static String getValueAttrTagHtml(String tag, String attr) {
		if (tag == null)
			return "";
		String PATTERN = "^<\\w+[^<>]*" + attr + "\\s*=\\s*(\"|')([^\"\']*)\\1\\s*[^<]*\\/?>";
		Pattern p = Pattern.compile(PATTERN, Pattern.MULTILINE);
		Matcher m = p.matcher(tag);
		if (m.find()) {
			tag = m.group(2).toString();
		}
		return tag.trim();
	}

	/**
	 * Example : <div d = "linh"></div> return linh
	 * 
	 * @param tag
	 * @param attr
	 * @return
	 */
	public static String getValueAttrTagHtmlNotStart(String tag, String attr) {
		if (tag == null)
			return "";
		String PATTERN = "<\\w+[^<>]*" + attr + "\\s*=\\s*(\"|')([^\"\']*)\\1\\s*[^<]*\\/?>";
		Pattern p = Pattern.compile(PATTERN, Pattern.MULTILINE);
		Matcher m = p.matcher(tag);
		if (m.find()) {
			tag = m.group(2).toString();
		}
		return tag.trim();
	}

	/**
	 * Example : <div> linh</div> return linh
	 * 
	 * @param tag
	 * @return
	 */
	public static String getValueInTagHtml(String tag) {
		if (tag == null)
			return "";
		String PATTERN = "^<(\\w+)[^<>]*>(.*)<\\/\\1>$";
		Pattern p = Pattern.compile(PATTERN, Pattern.DOTALL);
		Matcher m = p.matcher(tag);
		if (m.find()) {
			tag = m.group(2).toString();
			tag = tag.replaceAll("<(\\w+)[^<>]*>(.*)<\\/\\1>", "");
		}
		return tag.trim();
	}

	/**
	 * 
	 * @param isTag
	 * @return
	 */
	public static boolean checkStringContainerAnHtmlTag(String isTag, String tag) {
		String findTag = tag.toLowerCase().equals("all") ? "\\w+" : tag;
		String PATTERN = "<(" + findTag + ")[^<>]*\\/?>";
		Pattern p = Pattern.compile(PATTERN, Pattern.MULTILINE);
		Matcher m = p.matcher(isTag);
		return m.find() ? true : false;
	}

	/**
	 * 
	 * @param htmlTag
	 * @param tag
	 * @param attr
	 * @return
	 */
	private static List<List<String>> getValueAllAttrTagHtml(String htmlTag, String tag, String attr) {
		List<List<String>> listImage = new ArrayList<>();
		String findTag = tag.toLowerCase().equals("all") ? "\\w+" : tag;
		String PATTERT_IMG_TAG = "<(" + findTag + ")[^<>]* " + attr + "\\s*=\\s*('|\")([^<>'\"]*)\\2[^<>]*\\/?>";
		Pattern p = Pattern.compile(PATTERT_IMG_TAG, Pattern.MULTILINE);
		Matcher m = p.matcher(htmlTag);
		while (m.find()) {
			String start = String.valueOf(m.start());
			String end = String.valueOf(m.end());
			String data = standardizeString(m.group(3).toString());
			String tagName = m.group(1).toString();
			if (!isEmpty(data)) {
				listImage.add(new ArrayList<String>() {
					{
						add(start);
						add(data);
						add(end);
						add(tagName);
						add(attr);
					}
				});
			}
		}

		return listImage;
	}
	
	/**
	 * 
	 * @param htmlTag
	 * @param tag
	 * @return
	 */
	private static List<List<String>> getAllValueInTagHtml(String htmlTag, String tag){
		List<List<String>> listValue = new ArrayList<>();
		String findTag = tag.toLowerCase().equals("all") ? "\\w+" : tag;
		
		String PATTERT_START_TAG = "<("+findTag+")[^<>]*(?!=/)>([^<>]*)";
		Pattern p = Pattern.compile(PATTERT_START_TAG, Pattern.MULTILINE);
		Matcher m = p.matcher(htmlTag);
		while (m.find()) {
			String start = String.valueOf(m.start());
			String data = standardizeString(m.group(2).toString());
			String end = String.valueOf(m.end());
			String tagName = standardizeString(m.group(1).toString());
			if (!isEmpty(data)) {
				listValue.add(new ArrayList<String>() {
					{
						add(start);
						add(data);
						add(end);
						add(tagName);
					}
				});
			}
		}
		
		return listValue;
	}

	/**
	 * 
	 * @param htmlTag
	 * @return
	 */
	public static List<String> getTextInformationInTagHtml(String htmlTag) {
		List<String> listText = new ArrayList<>();
		List<List<String>> listTag = new ArrayList<>(), listImage = new ArrayList<>();
		//get all value in tag have closing tag
		listTag = getAllValueInTagHtml(htmlTag, "all");
		// get src image tag
		listImage = getValueAllAttrTagHtml(htmlTag, "img", "src");
		// return list data ordered
		int index = 0, ind = 0;
		while (index < listTag.size() && ind < listImage.size()) {
			if (Integer.parseInt(listTag.get(index).get(0)) < Integer.parseInt(listImage.get(ind).get(0))) {
				listText.add(listTag.get(index).get(1));
				index++;
			} else {
				listText.add(listImage.get(ind).get(1));
				ind++;
			}
		}
		while(index < listTag.size()) {
			listText.add(listTag.get(index++).get(1));
		}
		while(ind < listImage.size()) {
			listText.add(listImage.get(ind++).get(1));
		}
		
		return listText;
	}
	
	/**
	 * 
	 * @param htmlTag
	 * @return
	 */
	public static List<String> getTextInformationInTagHtmlAdvance(String htmlTag) {
		List<String> listText = new ArrayList<>();
		List<List<String>> listTag = new ArrayList<>();
		//get value in tag have closing tag
		listTag = getAllValueInTagHtml(htmlTag, "all");
		// get src image tag
		listTag.addAll(getValueAllAttrTagHtml(htmlTag, "img", "src"));
		// get href
		listTag.addAll(getValueAllAttrTagHtml(htmlTag, "a", "href"));
		//value in input
		listTag.addAll(getValueAllAttrTagHtml(htmlTag, "input", "value"));
		
		listTag.sort(new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return Integer.parseInt(o1.get(0)) > Integer.parseInt(o2.get(0)) ? 1 : -1;
			}
		});
		for(List<String> tagValue : listTag) {
			listText.add(tagValue.get(1));
		}
		
		return listText;
	}

	/**
	 * 
	 * @param currency
	 * @return
	 */
	public static Double convertCurrencyToNumber(String currency) {
		String number = currency.replaceAll("[^,0-9]", "");
		return UtilsFunc.isNumeric(number) ? Double.parseDouble(number) : 0.0D;
	}
}
