package com.teamo.ejournal.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.teamo.ejournal.orm.UserEntity;

public class UploadUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadUtils.class);
	
	public static String getServerSavingPathForUser(UserEntity user,String absoluteServerPath,String fileOriginalName,String version){
		return absoluteServerPath+"resources/"+ relativeFinalPath(user, fileOriginalName, version);
	}
	
	public static String getURLforFile(UserEntity user,String fileOriginalName,String version) throws UnsupportedEncodingException{
		return "resources/"+ relativeFinalPathEncoded(user, fileOriginalName, version);
	}
	
	private static String relativeFinalPath(UserEntity user,String fileOriginalName,String version){
		return "articles/userid"+user.getId()+"/v"+version+"_"+fileOriginalName;
	}
	
	private static String relativeFinalPathEncoded(UserEntity user,String fileOriginalName,String version) throws UnsupportedEncodingException{
		return "articles/userid"+user.getId()+"/v"+version+"_"+URLEncoder.encode(fileOriginalName, "UTF-8");
	}
	
	public static String getTempPath(String absoluteServerPath){
		return absoluteServerPath+"resources/temp.file";
	}
	
	public static void saveFile(MultipartFile file,String serverSavePath) throws IllegalStateException,IOException{
		
		logger.info("Trying to save file to: "+serverSavePath);
		
		File dest = new File(serverSavePath);
        dest.mkdirs(); //create necessary dirs, including parents
        file.transferTo(dest);
        
        logger.info("Saved file to: "+dest.getAbsolutePath());
	}
	
	public static void saveTempFile(MultipartFile file,String absoluteServerPath) throws IllegalStateException,IOException{
		saveFile(file, getTempPath(absoluteServerPath));
	}
	
	public static void moveTempFileToPath(String absoluteServerPath,String newPath) throws IOException{
		
		logger.info("Trying to move file...");
        
        InputStream inStream = null;
    	OutputStream outStream = null;
     
    	try{
 
    		File orig = new File(getTempPath(absoluteServerPath));
    	    File dest = new File(newPath);
    	    dest.getParentFile().mkdirs(); //create necessary dirs, including parents
 
    	    logger.info("Move From: "+orig.getAbsolutePath());
            logger.info("Move To: "+dest.getAbsolutePath());
    	    
    	    inStream = new FileInputStream(orig);
    	    outStream = new FileOutputStream(dest);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    //delete the original file
    	    orig.delete();
 
    	    logger.info("File is copied successful!");
 
    	}catch(IOException e){
    		throw e;
    	}
        
        logger.info("Saved file.");
	}
	
}
