package dzq.group.mark.domain;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.List;

public class DetailInfoRequest extends BaseRequest {
    private long detailId;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    @Override
    public String toString() {
        return "DetailInfoRequest{" +
                "detailId=" + detailId +
                ", token='" + token + '\'' +
                '}';
    }
}
