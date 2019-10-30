package dzq.group.mark.domain;

public class AddGroupMemberRequest extends BaseRequest {

    private long groupId;

    private String memberAliasName;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getMemberAliasName() {
        return memberAliasName;
    }

    public void setMemberAliasName(String memberAliasName) {
        this.memberAliasName = memberAliasName;
    }

    @Override
    public String toString() {
        return "AddGroupMemberRequest{" +
                "groupId=" + groupId +
                ", memberAliasName='" + memberAliasName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
