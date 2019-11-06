package dzq.group.mark.common;

public enum ValidExCode {
    NOT_NULL("0001", "%s不能为空"),
    STRING_NOT_NULL("0002", "%s不能为空"),
    STRING_OVERLENGTH("0003", "%s超长"),
    PARAM_ERROR("0004", "参数异常"),
    DETAIL_MODIFY_ERROR("0005", "明细修改失败"),
    SET_DETAIL_NUM_ERROR("0006", "结算失败"),
    GROUP_LIMIT_ERROR("0007", "团超过上限"),
    CREATE_GROUP_FREQUENT("0008", "创建团频繁"),
    MEMBER_LIMIT_ERROR("0009", "团员超过上限"),
    CREATE_MEMBER_FREQUENT("0010", "创建团员频繁"),
    SUCCESS("0000", "成功"),
    ERROR("9999", "服务器异常"),
    NOT_LOGIN("NOT_LOGIN", "未登陆");

    private String code;
    private String msg;

    ValidExCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    public static String getMsgByCode(String code) {

        ValidExCode[] ones = ValidExCode.values();
        for (ValidExCode one : ones) {
            if (code.equals(one.getCode())) {
                return one.getMsg();
            }
        }
        return null;

    }

}
