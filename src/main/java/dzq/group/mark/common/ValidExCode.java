package dzq.group.mark.common;

public enum ValidExCode {
    NOT_NULL("0001", "%s不能为空");

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
