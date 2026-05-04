package com.naver.sth.reply;

import java.util.List;

import com.naver.sth.board.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private final NoticeService noticeService;

	@Autowired
	private ReplyMapper replyMapper;

    ReplyService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

	public List<ReplyDTO> list(Long productNum)throws Exception{
		
		return replyMapper.list(productNum);
	}

	public int create(ReplyDTO replyDTO)throws Exception{
		
		return replyMapper.create(replyDTO);
	}

	public int delete(ReplyDTO replyDTO)throws Exception{
		return replyMapper.delete(replyDTO);
	}

	public int update(ReplyDTO replyDTO)throws Exception{
		
		return replyMapper.update(replyDTO);
		
	}
}
