package dzq.group.mark.domain;

public class DeleteDetailRequest extends BaseRequest {

    private long detailId;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    @Override
    public String toString() {
        return "DeleteDetailRequest{" +
                "detailId=" + detailId +
                ", token='" + token + '\'' +
                '}';
    }
}
