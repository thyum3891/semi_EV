package com.kh.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;


// 나의 리네임 정책 만들기
public class MyFileRenamePolicy implements FileRenamePolicy {

	// 실제 파일이름을 변경할 메소드
	// input -> 현재 파일이름
	// output -> 바뀌는 이름 
	
	private static int sequenceValue = 1;
	
	@Override
	public File rename(File oldfile) {
		// 파일 이름 삭제, 일자와 시간만 남길 코드
		// 인코딩 문제 발생, 관리 용도 -> 일정 시간 이전 파일은 삭제
		String dateStr = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		String sequenceStr =  "" + (sequenceValue++);
		String extensionStr = "";
		
		try {
			String oldName = oldfile.getName(); // testIMG0001.jpg 자바강의01.pdf
			int extensionIndex = oldName.lastIndexOf(".");
			extensionStr = oldName.substring(extensionIndex, oldName.length());
		} catch (Exception e) {
		}
		
		String newFileName = dateStr + "_" + sequenceStr + "_" + extensionStr;
		File newFile = new File(oldfile.getParent(), newFileName);
		System.out.println(newFile.getAbsolutePath());
		return newFile;
	}
	
//	public static void main(String[] args) {
//		File file = new File("./testjdsiogjsdiogv.sdvsdv.txt");
//		File newFile1 = new MyFileRenamePolicy().rename(file);
//		File newFile2 = new MyFileRenamePolicy().rename(file);
//		File newFile3 = new MyFileRenamePolicy().rename(file);
//		File newFile4 = new MyFileRenamePolicy().rename(file);
//		System.out.println(newFile1);
//		System.out.println(newFile2);
//		System.out.println(newFile3);
//		System.out.println(newFile4);
//	}

}
