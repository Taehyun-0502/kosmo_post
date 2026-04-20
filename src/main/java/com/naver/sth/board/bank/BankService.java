package com.naver.sth.board.bank;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.sth.board.BoardDTO;
import com.naver.sth.board.BoardService;
import com.naver.sth.file.FileManager;
import com.naver.sth.pager.Pager;


@Service
public class BankService implements BoardService {

	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.bank}")
	private String name;
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		 
		List<BoardDTO> ar = bankMapper.list(pager);
		return ar;
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		
		int result = bankMapper.create(boardDTO);
		
		if(attach==null) {
			return result;
			
		}
		
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName=fileManager.fileSave(name, f);
			
			BankFileDTO bankFileDTO= new BankFileDTO();
			bankFileDTO.setOriName(f.getOriginalFilename());
			bankFileDTO.setFileName(fileName);
			bankFileDTO.setBoardNum(boardDTO.getBoardNum());
			result=bankMapper.createFile(bankFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO,MultipartFile [] attach) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
