package com.naver.sth.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.sth.board.BoardDTO;
import com.naver.sth.board.BoardService;
import com.naver.sth.board.notice.NoticeFileDTO;
import com.naver.sth.file.FileDTO;
import com.naver.sth.file.FileManager;
import com.naver.sth.pager.Pager;

@Service
public class QnaService  implements BoardService{
	
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.board.qna}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(qnaMapper.getCount(pager));
		
		pager.makeStartNum();
		
		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		
		return qnaMapper.detail(boardDTO);
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		
		return qnaMapper.fileDetail(fileDTO);
	}
	
	
	@Override
	public int create(BoardDTO boardDTO,MultipartFile[]attach) throws Exception {
		int result = qnaMapper.create(boardDTO);
		
		if(attach==null) {
			
			return result;
		}
		for(MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName=fileManager.fileSave(name, f);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());
			result=qnaMapper.createFile(qnaFileDTO);
			
		}
		
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO,MultipartFile [] attach) throws Exception {
		int result=qnaMapper.update(boardDTO);
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		 	
		boardDTO = qnaMapper.detail(boardDTO);
		for(FileDTO fileDTO:boardDTO.getList()) {
			//qnaMapper.fileDelete(fileDTO);
		fileManager.fileDelete(name,fileDTO);
		}
		qnaMapper.fileDeleteFor(boardDTO.getList());
		
		int result=qnaMapper.delete(boardDTO);
		
		
		return result;
	}
	
		
}
