package kr.or.ddit.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

// NoFileException이 발생할 경우HTTP 응답모드를 서버 내부에러인 500이 아니라
// 404 (not found) 응답코드로 대체
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception{
	
	

}



































