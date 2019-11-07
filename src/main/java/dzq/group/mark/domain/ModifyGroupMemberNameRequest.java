package dzq.group.mark.domain;

public class ModifyGroupMemberNameRequest extends BaseRequest {

    private long groupId;

    private long groupMemberId;

    private String groupMemberName;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(long groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public String getGroupMemberName() {
        return groupMemberName;
    }

    public void setGroupMemberName(String groupMemberName) {
        this.groupMemberName = groupMemberName;
    }

    @Override
    public String toString() {
        return "ModifyGroupMemberNameRequest{" +
                "groupMemberId=" + groupMemberId +
                ", groupMemberName='" + groupMemberName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
