package dzq.group.mark.domain;

public class SettleInfoRequest extends BaseRequest {

    private long groupId;

    private long settleId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getSettleId() {
        return settleId;
    }

    public void setSettleId(long settleId) {
        this.settleId = settleId;
    }

    @Override
    public String toString() {
        return "SettleInfoRequest{" +
                "settleId=" + settleId +
                ", token='" + token + '\'' +
                '}';
    }
}
