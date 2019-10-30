package dzq.group.mark.domain;

public class ModifyGroupNameRequest extends BaseRequest {

    private long groupId;

    private String groupName;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ModifyGroupNameRequest{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
