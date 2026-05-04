package com.naver.sth.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.naver.sth.member.MemberDTO;
import com.naver.sth.reply.ReplyController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LogingCheckInterceptor implements HandlerInterceptor {

    private final ReplyController replyController;

    LogingCheckInterceptor(ReplyController replyController) {
        this.replyController = replyController;
    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Object obj =session.getAttribute("member");
		
		if(obj !=null) {
			return true;
			
		}
		
		response.sendRedirect("/member/login");
		
		return false;
	}
	
	
	
	
	
	
	
	
	
}
