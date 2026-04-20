package com.naver.sth.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pager {

	//검색어
	private String search="";
	//검색어 컬럼
	private String kind;
	
	//페이지당 보여줄 글의 갯수
	private Long perPage;
	
	//offset 번호
	private Long startNum;
	//page 번호
	private Long page;
	
	private Long start;
	
	private Long end;
	
	//이전 블럭의 유무
	private boolean pre=true;//true면 이전 블럭이 존재 
	//다음 블럭의 유무
	private boolean next=true;//false 면 이전 블럭이 존재
	
	
	
	public Long getPerPage() {
		if(perPage == null || perPage <1) {
			
			this.perPage=5L;
		}
		return this.perPage;
	}
	public Long getPage() {
		if(page == null || page<1) {
			this.page=1L;
		}
		return this.page;
	}
	
	public void makeStartNum() {
		
		this.startNum=(this.getPage()-1)*this.getPerPage();
		
	}
	public void makePageNum(Long totalCount) {
		//1.총페이지 구하기
		Long totalPage=(long)(Math.ceil((double)totalCount/this.getPerPage()));
		
		//2. 총 블럭 수 구하기 
		Long perBlock=5L; //한 블럭당 출력할 번호
		Long totalBlock= totalPage/perBlock;
		
		if(totalPage%5 !=0) {
			totalBlock++;
			
		}
		
		//3. 페이지 번호로 현재 블럭 구하기 
		Long curBlock= this.getPage()/perBlock;
		
		if(this.page%perBlock !=0) {
			curBlock++;
			
		}
		//4.현재 블럭 번호로 시작번호 끝번호 구하기
		 start=(curBlock-1)*perBlock+1;
		 end=curBlock*perBlock;
		 this.setStart(start);
		this.setEnd(end);
		//5. 현재 블럭 번호가 총블럭 번호와 같다면 
		if(curBlock==totalBlock) {
			end=totalPage;
			next=false;
		}
		
		//6. 현
		if(curBlock<2) {
			pre=false;
			
			
		}
		
	}
	
	
	
	
	
	
	
}
