package com.naver.sth.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.sth.file.FileManager;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Value("${app.member}")
	private String name;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
		
	@Override
	public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
			
		int result= memberMapper.join(memberDTO);
		
		if(file !=null && !file.isEmpty()) {
		String fileName=fileManager.fileSave(name, file);
		
		ProfileDTO profileDTO = new ProfileDTO();
		
		profileDTO.setFileName(fileName);
		profileDTO.setOriName(file.getOriginalFilename());
		profileDTO.setUsername(memberDTO.getUsername());
		memberMapper.addProfile(profileDTO);
		}
		
		
		
		
		
			return result;
		}
	@Override
	public MemberDTO detail(MemberDTO memberDTO) throws Exception {
		MemberDTO check = memberMapper.detail(memberDTO);
		if(check != null) {
			if(check.getPassword().equals(memberDTO.getPassword())) {
				
				return check;
			}
			
		}
		
		return null;
	}
	
	
	
}
