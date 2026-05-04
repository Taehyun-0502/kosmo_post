package com.naver.sth.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {

	public List<ReplyDTO> list (Long productNum)throws Exception;
	
	public int create(ReplyDTO replyDTO)throws Exception;
	
	public int delete(ReplyDTO replyDTO)throws Exception;
	
	public int update(ReplyDTO replyDTO)throws Exception;
	
}
