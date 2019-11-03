package dzq.group.mark.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class DoSetResponse {

    private int setNum;
    private String detailIdList;
    private BigDecimal setMoney;

    private List<MemberSetResponse> setResponseList;

    public String getDetailIdList() {
        return detailIdList;
    }

    public void setDetailIdList(String detailIdList) {
        this.detailIdList = detailIdList;
    }

    public int getSetNum() {
        return setNum;
    }

    public void setSetNum(int setNum) {
        this.setNum = setNum;
    }

    public BigDecimal getSetMoney() {
        return setMoney;
    }

    public void setSetMoney(BigDecimal setMoney) {
        this.setMoney = setMoney;
    }

    public List<MemberSetResponse> getSetResponseList() {
        return setResponseList;
    }

    public void setSetResponseList(List<MemberSetResponse> setResponseList) {
        this.setResponseList = setResponseList;
    }
}
