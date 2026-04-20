package com.naver.sth.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Value("${app.upload.base}")
	private String path;
	
	public boolean fileDelete(String name, FileDTO fileDTO ) throws Exception{
		File file = new File(path, name); //upload / **까지 만들어짐
		file= new File(file, fileDTO.getFileName());
		
		return file.delete();
		
	}
	
	
	
	public String fileSave(String name,MultipartFile attach)throws Exception{
		//1. 어디에 저장할 것인가
		File file=new File(path,name);
		if(!file.exists()) {
			
			file.mkdirs();
			
		}
		String fileName=UUID.randomUUID().toString();
		
		fileName= fileName+"_"+attach.getOriginalFilename();
		file= new File(file,fileName);
		
		attach.transferTo(file);
		
		return fileName;
		//FileCopyUtils.copy(attach.getBytes(), file);
		
	}
}
