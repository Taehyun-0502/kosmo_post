package com.naver.sth.board.qna;

import com.naver.sth.file.FileDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QnaFileDTO extends FileDTO {
	
	private Long boardNum;
}
