package com.naver.sth.board.notice;

import com.naver.sth.file.FileDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeFileDTO extends FileDTO{

	private Long boardNum;
}
