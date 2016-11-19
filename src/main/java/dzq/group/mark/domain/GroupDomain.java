package dzq.group.mark.domain;

/**
 * Created by lijianjianchi on 2016/11/19.
 */
public class GroupDomain {

    private String nickName;
    private String createUser;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "GroupDomain{" +
                "nickName='" + nickName + '\'' +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
