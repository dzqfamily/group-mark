package dzq.group.mark.common;

public enum ValidExCode {
    NOT_NULL("0001", "%s不能为空"),
    STRING_NOT_NULL("0002", "%s不能为空"),
    STRING_OVERLENGTH("0003", "%s超长"),
    PARAM_ERROR("0004", "参数异常"),
    DETAIL_MODIFY_ERROR("0005", "明细修改失败"),
    SET_DETAIL_NUM_ERROR("0006", "结算失败"),
    GROUP_LIMIT_ERROR("0007", "团上限%s个"),
    CREATE_GROUP_FREQUENT("0008", "创建团频繁"),
    MEMBER_LIMIT_ERROR("0009", "每团团员上限%s人"),
    CREATE_MEMBER_FREQUENT("0010", "创建团员频繁"),
    DETAIL_LIMIT_ERROR("0018", "每团每月明细上限%s条"),
    CREATE_DETAIL_FREQUENT("0019", "创建明细频繁"),
    DOSET_NO_UNDETAILI("0011", "没有需要结算的明细"),
    MODIFY_DETAIL_NOT_SELF("0012", "只有创建人才能修改明细"),
    DELETE_DETAIL_NOT_SELF("0013", "只有创建人才能删除明细"),
    MODIFY_FREQUENT("0014", "修改操作冲突,请重试"),
    DELETE_GROUP_NOT_SELF("0015", "只有创建人才能删除团"),
    NOT_FOUND_GROUP("0016", "未找到团"),
    NOT_FOUND_DETAIL("0017", "未找到明细"),
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
