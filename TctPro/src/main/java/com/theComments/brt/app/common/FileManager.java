package com.theComments.brt.app.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Works;

public class FileManager {

	/**
	 * 파일 저장
	 * 
	 * @param file
	 *            멀티파일 파일
	 * @param path
	 *            멀티파일 경로 '/'을 반드시 포함하여 ex)/test
	 * @param fileTypeExp
	 *            멀티파일에 해당하는 확장자에 대한 정규표현식 ex)'jpg|png' 
	 * @return fileSave Model 리턴
	 * @throws Exception
	 *             403001:확장자 다름, 403002:파일 업로드 에러
	 */
	public static FileSave fileSave(MultipartFile file, String path, String fileTypeExp) throws Exception,RuntimeException {
		//String exp = ".*\\.(jpg|png)$";
		String exp= ".*\\.("+ fileTypeExp+ ")$";
		Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE);
		String fileName = file.getOriginalFilename();
		String ext = fileName.split(".*\\.")[1];

		if (pattern.matcher(fileName).matches() == false) {
			throw new RuntimeException("403001:fileError");
		}

		String filePath = FileConst.UPLOAD_CONST.UPLOAD_BASE_PATH + path;
		String realFilePath = new File(filePath).getCanonicalPath();
		new File(realFilePath).mkdirs();

		String realFileName = "";

		try {
			realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
			File uploadTarget = new File(realFilePath + "/" + realFileName);

			while (uploadTarget.exists()) {
				realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
				uploadTarget = new File(realFilePath + "/" + realFileName);
			}

			uploadTarget.createNewFile();

			FileOutputStream targetStream = new FileOutputStream(uploadTarget);
			targetStream.write(file.getBytes());
			targetStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("403002:fileError");
		}

		FileSave fs = new FileSave();
		fs.setFile_name(fileName);
		fs.setFile_path(filePath);
		fs.setFile_type(fileTypeExp);
		fs.setSave_file_path(realFilePath);
		fs.setSave_file_name(realFileName);

		return fs;
	}

}
