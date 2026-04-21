package com.naver.sth.board.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.naver.sth.board.BoardDTO;
import com.naver.sth.pager.Pager;

@Controller
@RequestMapping("/bank/*")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@Value("${app.board.bank}")
	private String name;
	
	@ModelAttribute("name")
	public String getname() {
		return this.name;
	}
	
	@GetMapping("list")
	public String list(Pager pager,Model model)throws Exception{
		
		
		List<BankDTO> ar= bankService.list(pager);
		
		model.addAttribute("list", ar);
		
		return "/bank/list";
	}
	@GetMapping("create")
	public String create()throws Exception {
		
		return "/bank/create";
	}
	@PostMapping("create")
	public String create(BankDTO bankDTO,@RequestParam("attach") MultipartFile attach)throws Exception {
		int result =bankService.create(bankDTO, attach);
		
		
		return "redirect:./list";
	}
	@GetMapping("detail")
	public void detail (BankDTO bankDTO, Model model) throws Exception{
		bankDTO= bankService.detail(bankDTO);
		
		model.addAttribute("detail", bankDTO);
		
	}	
}
