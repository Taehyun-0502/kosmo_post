package com.naver.sth.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.sth.board.BoardDTO;
import com.naver.sth.file.FileDTO;
import com.naver.sth.file.FileManager;
import com.naver.sth.pager.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
    private final FileManager fileManager;
    
    @ModelAttribute("name")
    public String getname () {
    	
    	return "qna";
    }
    
    
	@Autowired
	private QnaService qnaService;

    QnaController(FileManager fileManager) {
        this.fileManager = fileManager;
    }
	
    
    @GetMapping("down")
    public String fileDown(QnaFileDTO qnaFileDTO,Model model)throws Exception{
    	
    	FileDTO fileDTO=qnaService.fileDetail(qnaFileDTO);
    	
    	model.addAttribute("fileDTO", fileDTO);
    	
    	return "fileDownView";
    	
    }
    
    
	@GetMapping("list")
	public String list(Pager pager,Model model) throws Exception{
		
		List<BoardDTO> ar =qnaService.list(pager);
		model.addAttribute("list", ar);
		
		return "board/list";
		
	} 
	@GetMapping("create")
	public String create()throws Exception {
		
		return "board/create";
	}
	@PostMapping("create")
	public String create(QnaDTO qnaDTO,@RequestParam("attach") MultipartFile [] attach) throws Exception{
		
		qnaService.create(qnaDTO, attach);
		
		
		
		return "redirect:./list";
	}
	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model)throws Exception{
			
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("detail", boardDTO);
		
		return "board/detail";
	}
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model)throws Exception {
		
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/update";
	}
	@PostMapping("update")
	public ModelAndView update(QnaDTO qnaDTO ,@RequestParam("attach") MultipartFile [] attach )throws Exception {
		
		int result = qnaService.update(qnaDTO, attach);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:./list");
		mv.addObject("dto",qnaDTO);
		
		
		return mv;
	}
	@PostMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.delete(qnaDTO);
		
		return "redirect:./list";
		
		
	}
	
	
	
	
	
	
}
