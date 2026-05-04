package com.naver.sth.reply;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyDTO {

	private Long replyNum;
	private String username;
	private String replyContents;
	private LocalDateTime replyDate;
	private Long replyStar;
	private Long productNum;
	
}
