package com.naver.sth.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naver.sth.board.BoardMapper;
import com.naver.sth.file.FileDTO;

@Mapper
public interface QnaMapper extends BoardMapper {

	public int fileDelete(FileDTO fileDTO)throws Exception;
	
	public int fileDeleteFor(List<FileDTO> list)throws Exception;
	
}
