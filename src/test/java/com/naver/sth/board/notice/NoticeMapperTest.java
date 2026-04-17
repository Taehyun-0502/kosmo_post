package com.naver.sth.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.sth.board.BoardDTO;
import com.naver.sth.pager.Pager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class NoticeMapperTest {
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void testList() throws Exception{
		Pager pager = new Pager();
		pager.setPage(1L);
		pager.setSearch("8");
		pager.makeStartNum();
		
		List<BoardDTO> ar= noticeMapper.list(pager);
		log.info("{}",ar);
		assertNotEquals(0, ar.size());
		
		
	}
	/*
	 * @Test void testCreate()throws Exception{
	 * 
	 * for(int i =0;i<23;i++ ) { NoticeDTO noticeDTO = new NoticeDTO();
	 * noticeDTO.setBoardTitle("title"+i); noticeDTO.setBoardWriter("writer"+1);
	 * noticeDTO.setBoardContents("contents"+i); noticeMapper.create(noticeDTO);
	 * if(i%3 ==0) { Thread.sleep(500);
	 * 
	 * 
	 * }
	 * 
	 * } System.out.println("끝");
	 * 
	 * 
	 * }
	 */

}
