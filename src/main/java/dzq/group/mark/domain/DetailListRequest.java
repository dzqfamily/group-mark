package dzq.group.mark.domain;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.List;

public class DetailListRequest extends BaseRequest {

    private long groupId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "DetailListRequest{" +
                "groupId=" + groupId +
                ", token='" + token + '\'' +
                '}';
    }
}
