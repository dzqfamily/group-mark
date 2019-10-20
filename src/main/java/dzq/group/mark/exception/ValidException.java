package dzq.group.mark.exception;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class ValidException extends Exception {

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ValidException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
