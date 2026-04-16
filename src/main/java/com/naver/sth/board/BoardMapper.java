package com.naver.sth.board;

import java.util.List;




public interface BoardMapper {

	public List<BoardDTO> list()throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO)throws Exception;
	
	
}
