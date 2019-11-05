package dzq.group.mark.domain;

public class SettleInfoRequest extends BaseRequest {
    private long settleId;

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
