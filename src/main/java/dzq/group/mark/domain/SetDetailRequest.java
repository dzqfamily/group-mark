package dzq.group.mark.domain;

public class SetDetailRequest extends BaseRequest {

    private long groupId;

    private String detailIdList;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getDetailIdList() {
        return detailIdList;
    }

    public void setDetailIdList(String detailIdList) {
        this.detailIdList = detailIdList;
    }

    @Override
    public String toString() {
        return "DeleteMemberRequest{" +
                "groupId='" + groupId + '\'' +
                "detailIdList='" + detailIdList + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
