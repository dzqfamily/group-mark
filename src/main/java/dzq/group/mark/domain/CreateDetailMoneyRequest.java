package dzq.group.mark.domain;

import java.math.BigDecimal;

public class CreateDetailMoneyRequest {

    private String memberName;
    private long memberId;
    private BigDecimal moneyValue;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
    }

    @Override
    public String toString() {
        return "CreateDetailMoneyRequest{" +
                "memberName='" + memberName + '\'' +
                ", memberId=" + memberId +
                ", moneyValue=" + moneyValue +
                '}';
    }
}
