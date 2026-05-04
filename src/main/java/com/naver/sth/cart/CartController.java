package com.naver.sth.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.sth.board.bank.BankDTO;
import com.naver.sth.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("create")
	public String createCart(CartDTO cartDTO,HttpSession httpSession,Model model)throws Exception {
		MemberDTO memberDTO=(MemberDTO)httpSession.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());
	
		System.err.println(cartDTO.getProductNum());
		int result = cartService.createCart(cartDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	@GetMapping("list")
	public void list()throws  Exception{
		
		
	}
	@GetMapping("cartlist")
	public void list(HttpSession session,Model model)throws  Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		
		
		List<BankDTO> ar=cartService.list(memberDTO);
		
		model.addAttribute("list", ar);
		
	}
	/*
	 * @PostMapping("delete") public String delete(CartDTO cartDTO, HttpSession
	 * session,Model model)throws Exception{ MemberDTO
	 * memberDTO=(MemberDTO)session.getAttribute("member");
	 * cartDTO.setUsername(memberDTO.getUsername());
	 * System.out.println(cartDTO.getProductNum()); int result =
	 * cartService.delete(cartDTO); model.addAttribute("result", 1);
	 * 
	 * return "commons/ajaxResult";
	 * 
	 * }
	 */
	@PostMapping("delete")
	public String delete(@RequestParam("productNum") Long[] productNum, HttpSession session,Model model)throws Exception{
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		
		
		List<CartDTO> ar = new  ArrayList();
		
		for(Long l :productNum) {
			CartDTO cartdto=new CartDTO();
			cartdto.setProductNum(l);
			cartdto.setUsername(memberDTO.getUsername());
			ar.add(cartdto);
		}
		
		 int result = cartService.delete(ar);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
	}
	
}
	

