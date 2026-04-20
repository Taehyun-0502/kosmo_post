package com.naver.sth.board.bank;

import java.util.List;

import com.naver.sth.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BankDTO extends BoardDTO{

	
	private String productType;
	private double productRate;
	
	
}
