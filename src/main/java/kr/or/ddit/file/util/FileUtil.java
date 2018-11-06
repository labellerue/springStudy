package kr.or.ddit.file.util;


public class FileUtil {
	//fileUtil.getFileExt(String originalFileName)
	//확장자가 있을 경우 .을 포함한 확자자 값을 리턴
	//확장자가 없을 경우 "" whitespace를 리턴
	//테스트값 : sally.png  ==> png
	//테스트값 : sally ==> ""
	public static String getFileExt(String originalFileName) {
		String[] split = originalFileName.split("\\.");
		
		if (split.length > 1) {
			String ext = split[split.length - 1];
			return "."+ext;
		} else {
			return "";
		}
	}
	
	public static String getFileExt2(String originalFileName) {
		int lastDotIndex = originalFileName.lastIndexOf(".");
		
		if (lastDotIndex < 0) {
			return "";
		} else {
			return originalFileName.substring(lastDotIndex);
		}
	}

}
