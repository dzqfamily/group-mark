package dzq.group.mark.domain;

public class DeleteMemberRequest extends BaseRequest {

    private long groupMemberId;

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
