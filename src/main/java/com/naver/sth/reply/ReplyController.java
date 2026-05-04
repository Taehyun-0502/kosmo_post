package com.naver.sth.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.sth.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@GetMapping("list")
	public String list(@RequestParam("productNum")Long productNum,Model model)throws Exception {
		
		
		List<ReplyDTO> ar=replyService.list(productNum);
		model.addAttribute("reply", ar);
		
		return "reply/list";
	}
	@PostMapping("create")
	@ResponseBody
	public int create(ReplyDTO replyDTO,HttpSession session,Model model)throws Exception{
	MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		replyDTO.setUsername(memberDTO.getUsername());
	
		int result=replyService.create(replyDTO);
		model.addAttribute("result", result);
		
		return result;
		
	}
	@PostMapping("delete")
	@ResponseBody
	public int delete(ReplyDTO replyDTO,Model model)throws Exception{
		
		int result=replyService.delete(replyDTO);
		model.addAttribute("result", result);
		
		return result;
		
	}
	@PostMapping("update")
	@ResponseBody
	public int update(ReplyDTO replyDTO,Model model)throws Exception{
		
		
		int result=replyService.update(replyDTO);
		model.addAttribute("result", result);
		
		return result;
		
	}
	
}
