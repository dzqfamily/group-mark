package dzq.group.mark.response;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class Response {

	private String RESPONSE_CODE = "code";
	private String RESPONSE_MSG = "msg";
	private JSONObject jsonObject;

	public Response(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void setCode(String code) {
		jsonObject.put(RESPONSE_CODE, code);
	}

	public void setMsg(String msg) {
		jsonObject.put(RESPONSE_MSG, msg);
	}

	public void setResponse(String code, String msg) {
		jsonObject.put(RESPONSE_CODE, code);
		jsonObject.put(RESPONSE_MSG, msg);
	}

	public String result() {
		return jsonObject.toJSONString();
	}
}
