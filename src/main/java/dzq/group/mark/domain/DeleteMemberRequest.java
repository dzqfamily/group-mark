package dzq.group.mark.domain;

public class DeleteMemberRequest extends BaseRequest {

    private long groupId;

    private long groupMemberId;

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

    @Override
    public String toString() {
        return "DeleteMemberRequest{" +
                "groupMemberId='" + groupMemberId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
