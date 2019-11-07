package dzq.group.mark.exception;

import dzq.group.mark.common.ValidExCode;
import org.springframework.util.StringUtils;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class GroupMarkException extends RuntimeException {

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

	public GroupMarkException(String code) {
		this.code = code;
		this.msg = ValidExCode.getMsgByCode(code);
	}

	public GroupMarkException(String code, String msg) {
		this.code = code;
		this.msg = ValidExCode.getMsgByCode(code);
		if (!StringUtils.isEmpty(msg)) {
			this.msg = String.format(this.msg, msg);
		}
	}
	public GroupMarkException(String code, int msg) {
		this.code = code;
		this.msg = String.format(ValidExCode.getMsgByCode(code), msg);
	}
}
