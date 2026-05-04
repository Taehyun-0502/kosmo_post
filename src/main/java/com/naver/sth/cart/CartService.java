package com.naver.sth.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.sth.board.bank.BankDTO;
import com.naver.sth.member.MemberDTO;

@Service
public class CartService {

	@Autowired
	private CartMapper cartMapper;
	
	public int createCart(CartDTO cartDTO) throws Exception{
		
		return cartMapper.createCart(cartDTO);
		
		
	}
	
	public List<BankDTO> list(MemberDTO memberDTO)throws Exception{
		
		return cartMapper.list(memberDTO);
		
	}
		
	/*
	 * public int delete(CartDTO cartDTO)throws Exception{
	 * 
	 * return cartMapper.delete(cartDTO); }
	 */
	public int delete(List<CartDTO> ar)throws Exception{
		return cartMapper.delete(ar);
	}
	
	
}
