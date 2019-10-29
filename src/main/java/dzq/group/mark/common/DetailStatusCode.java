package dzq.group.mark.common;

public enum DetailStatusCode {
    INIT("0", "未结"),
    SET("1", "已结"),
    CLOSE("2", "作废");

    private String code;
    private String msg;

    DetailStatusCode(String code, String msg) {
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

        DetailStatusCode[] ones = DetailStatusCode.values();
        for (DetailStatusCode one : ones) {
            if (code.equals(one.getCode())) {
                return one.getMsg();
            }
        }
        return null;

    }

}
