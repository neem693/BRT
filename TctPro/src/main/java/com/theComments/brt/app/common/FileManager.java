package com.theComments.brt.app.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.Yaml;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.constFile.FileConst.UPLOAD_CONST;
import com.theComments.brt.jpa.theComment.model.FileSave;

public class FileManager {
	
	static String KEY_ID = "";
	static String SECRET_ACCESS_KEY = "";
	
	static {
		Yaml yaml = new Yaml();
		InputStream inputStream = FileManager.class.getClassLoader().getResourceAsStream("application.yml");
		Map<String, Object> property = yaml.load(inputStream);
		Map<String,Object> aws = (Map<String, Object>)property.get("AWS");
		
		KEY_ID = aws.get("KEY_ID").toString();
		SECRET_ACCESS_KEY = aws.get("SECRET_ACCESS_KEY").toString();
		
	}

	/**
	 * 파일 저장
	 * 
	 * @param file        멀티파일 파일
	 * @param path        멀티파일 경로 '/'을 반드시 포함하여 ex)/test
	 * @param fileTypeExp 멀티파일에 해당하는 확장자에 대한 정규표현식 ex)'jpg|png'
	 * @return fileSave Model 리턴
	 * @throws Exception 403001:확장자 다름, 403002:파일 업로드 에러
	 */
	public static FileSave fileSave(MultipartFile file, String path, String fileTypeExp)
			throws Exception, RuntimeException {
		// String exp = ".*\\.(jpg|png)$";
		String exp = ".*\\.(" + fileTypeExp + ")$";
		Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
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
			
// TODO aws s3 업로드 적용;
			
			realFileName = awsFileSave(filePath, file,ext,null);
			realFilePath = UPLOAD_CONST.S3_URL + filePath;
//			realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
//			File uploadTarget = new File(realFilePath + "/" + realFileName);
//
//			while (uploadTarget.exists()) {
//				realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
//				uploadTarget = new File(realFilePath + "/" + realFileName);
//			}
//
//			uploadTarget.createNewFile();
//
//			FileOutputStream targetStream = new FileOutputStream(uploadTarget);
//			targetStream.write(file.getBytes());
//			targetStream.close();

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

	/**
	 * 파일 저장 오버라이딩!!!!!(그저 다른옵션으로 지정됨)
	 * 
	 * @param fileName    파일 이름
	 * @param byteArray		해당 파일 바이트어레이
	 * @param path        멀티파일 경로 '/'을 반드시 포함하여 ex)/test
	 * @param fileTypeExp 멀티파일에 해당하는 확장자에 대한 정규표현식 ex)'jpg|png'
	 * @return fileSave Model 리턴
	 * @throws Exception 403001:확장자 다름, 403002:파일 업로드 에러
	 */
	public static FileSave fileSave(String fileName, byte[] byteArray, String path, String fileTypeExp)
			throws Exception, RuntimeException {
		// String exp = ".*\\.(jpg|png)$";
		String exp = ".*\\.(" + fileTypeExp + ")$";
		Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
//		String fileName = file.getOriginalFilename();
		String ext = fileName.split(".*\\.")[1];

		if (pattern.matcher(fileName).matches() == false) {
			throw new RuntimeException("403001:fileError");
		}

		String filePath = FileConst.UPLOAD_CONST.UPLOAD_BASE_PATH + path;
		String realFilePath = new File(filePath).getCanonicalPath();
		new File(realFilePath).mkdirs();

		String realFileName = "";

		try {
			
			realFileName = awsFileSave(filePath, null,ext,byteArray);
			realFilePath = UPLOAD_CONST.S3_URL + filePath;
//			realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
//			File uploadTarget = new File(realFilePath + "/" + realFileName);
//
//			while (uploadTarget.exists()) {
//				realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
//				uploadTarget = new File(realFilePath + "/" + realFileName);
//			}
//
//			uploadTarget.createNewFile();
//
//			FileOutputStream targetStream = new FileOutputStream(uploadTarget);
//			targetStream.write(byteArray);
//			targetStream.close();

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
	
	/**
	 * aws S3에 파일 세이브
	 * @param path 경로
	 * @param file 파일
	 * @param ext 확장자
	 * @param byteArray 파일이 아닌 byte 어레이라면 file이 null로 넘어올것.
	 * @return
	 * @throws IOException 
	 */
		private static String awsFileSave(String path, MultipartFile file, String ext,byte [] byteArray) throws IOException {
			// TODO Auto-generated method stub
			//앞 슬러쉬 지움
			//뒤 슬러쉬 붙임
			path = path.substring(1) + "/";
			
			Regions clientRegion = Regions.AP_NORTHEAST_2;
			String KEY_ID = FileManager.KEY_ID;
			String SECRET_ACCESS_KEY = FileManager.SECRET_ACCESS_KEY;
			String bucketName = "tct-file";
			
			AWSStaticCredentialsProvider awsCP = new AWSStaticCredentialsProvider(
					new BasicAWSCredentials(KEY_ID, SECRET_ACCESS_KEY));
			
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(awsCP).withRegion(clientRegion).build();
			
			String realFileName = CommonSecure.getRandomSecure(20) + "." + ext;	
			
			while (s3Client.doesObjectExist(bucketName, path + realFileName)) {
				realFileName = CommonSecure.getRandomSecure(20) + "." + ext;
			}

			ObjectMetadata metadata = new ObjectMetadata();
//			metadata.setContentType("plain/text");
//			metadata.addUserMetadata("x-amz-meta-title", "someTitle");
			
			InputStream stream = null;
			if(file == null) {
				stream = new ByteArrayInputStream(byteArray);
			}else {
				stream = file.getInputStream();
			}
			// Upload a file as a new object with ContentType and title specified.
			PutObjectRequest request = new PutObjectRequest(bucketName, path+ realFileName, stream,metadata).withCannedAcl(CannedAccessControlList.PublicRead);
			PutObjectResult result = s3Client.putObject(request);
			return realFileName;
			
		}

}
