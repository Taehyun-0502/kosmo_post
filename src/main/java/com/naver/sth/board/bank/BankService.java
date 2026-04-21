package com.naver.sth.board.bank;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.naver.sth.board.BoardService;
import com.naver.sth.file.FileManager;
import com.naver.sth.pager.Pager;


@Service
public class BankService  {

	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.bank}")
	private String name;
	@Value("${app.upload.base}")
	private String path;
	
	public List<BankDTO> list(Pager pager) throws Exception {
		 pager.makePageNum(bankMapper.getCount(pager));
		 pager.makeStartNum();
		 return  bankMapper.list(pager);
		
	}

	
	public BankDTO detail(BankDTO bankDTO) throws Exception {
		// TODO Auto-generated method stub
		return bankMapper.detail(bankDTO);
	}

	
	public int create(BankDTO bankDTO, MultipartFile attach) throws Exception {
		
		int result = bankMapper.create(bankDTO);
		
		if(attach != null && !attach.isEmpty()) {
			String fileName=fileManager.fileSave(name, attach);
			BankFileDTO bankFileDTO=new BankFileDTO();
			bankFileDTO.setFileName(fileName);
			bankFileDTO.setOriName(attach.getOriginalFilename());
			bankFileDTO.setProductNum(bankDTO.getProductNum());
			bankMapper.createFile(bankFileDTO);
		}
		
	
		
		return result;
	}

	
	public int update(BankDTO bankDTO,MultipartFile [] attach) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delete(BankDTO bankDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
