package com.naver.sth.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.naver.sth.board.bank.BankDTO;
import com.naver.sth.member.MemberDTO;

@Mapper
public interface CartMapper {

	public int createCart(CartDTO cartDTO)throws Exception;

	public List<BankDTO> list(MemberDTO memberDTO)throws Exception;

	public int delete(List<CartDTO> ar)throws Exception;
	
	/* public int delete(CartDTO cartDTO)throws Exception; */
}
