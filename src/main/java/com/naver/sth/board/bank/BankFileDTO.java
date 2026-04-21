package com.naver.sth.board.bank;

import org.springframework.stereotype.Component;

import com.naver.sth.file.FileDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankFileDTO extends FileDTO{

	private Long productNum;
}
