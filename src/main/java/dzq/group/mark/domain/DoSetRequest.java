package dzq.group.mark.domain;

public class DoSetRequest extends BaseRequest {

    private long groupId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "DeleteMemberRequest{" +
                "groupId='" + groupId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
