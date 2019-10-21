package dzq.group.mark.domain;

public class CreateGroupRequest extends BaseRequest {

    private String groupName;
    private String memberList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMemberList() {
        return memberList;
    }

    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "CreateGroupRequest{" +
                "groupName='" + groupName + '\'' +
                ", memberList='" + memberList + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
