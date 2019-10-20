package dzq.group.mark.domain;

public class UserInfoRequest extends BaseRequest {

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserInfoRequest{" +
                "nickName='" + nickName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
