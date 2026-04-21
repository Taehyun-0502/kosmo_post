package com.naver.sth.board.bank;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naver.sth.board.BoardMapper;
import com.naver.sth.file.FileDTO;
import com.naver.sth.pager.Pager;

@Mapper
public interface BankMapper {

	public List<BankDTO> list(Pager pager)throws Exception;
	
	public BankDTO detail(BankDTO bankDTO)throws Exception;
	
	public Long getCount(Pager pager)throws Exception;
	
	public int create(BankDTO bankDTO)throws Exception;
	
	public int createFile(BankFileDTO bankFileDTO)throws Exception;
	
}
