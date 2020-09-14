package kosta.mvc.exception;

/**
 * 수정할떄 발생 예외 
 */
public class ModifyException extends Exception {
	public  ModifyException() {
	}
	
	public ModifyException(String message) {
		super(message);
	}

}
