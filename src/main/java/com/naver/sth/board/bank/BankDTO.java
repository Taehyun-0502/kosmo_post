package com.naver.sth.board.bank;

import java.util.List;

import com.naver.sth.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BankDTO {

	private Long productNum;
	private String productTitle;
	private String productContents;
	private String productType;
	private Double productRate;
	
	private BankFileDTO bankFileDTO;
	
}
