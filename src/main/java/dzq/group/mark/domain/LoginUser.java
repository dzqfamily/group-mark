package dzq.group.mark.domain;

public class LoginUser {

    private String code;

    private String nickName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "code='" + code + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
