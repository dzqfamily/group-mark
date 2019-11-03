package dzq.group.mark.domain;

import java.math.BigDecimal;

public class MemberMoneyResponse {

    private long id;
    private String memberName;
    private boolean muchPeopleChecked;
    private String muchPeopleMoney;
    private boolean partChecked;
    private String partMoney;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public boolean isMuchPeopleChecked() {
        return muchPeopleChecked;
    }

    public void setMuchPeopleChecked(boolean muchPeopleChecked) {
        this.muchPeopleChecked = muchPeopleChecked;
    }



    public boolean isPartChecked() {
        return partChecked;
    }

    public void setPartChecked(boolean partChecked) {
        this.partChecked = partChecked;
    }

    public String getMuchPeopleMoney() {
        return muchPeopleMoney;
    }

    public void setMuchPeopleMoney(String muchPeopleMoney) {
        this.muchPeopleMoney = muchPeopleMoney;
    }

    public String getPartMoney() {
        return partMoney;
    }

    public void setPartMoney(String partMoney) {
        this.partMoney = partMoney;
    }
}
