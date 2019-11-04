package dzq.group.mark.common;

public enum DirectionCode {

    REVENUES("I", "收"),
    EXPENSES("D", "支");

    private String code;
    private String msg;

    DirectionCode(String code, String msg) {
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

        DirectionCode[] ones = DirectionCode.values();
        for (DirectionCode one : ones) {
            if (code.equals(one.getCode())) {
                return one.getMsg();
            }
        }
        return null;

    }

}
