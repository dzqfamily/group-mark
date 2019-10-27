package dzq.group.mark.domain;

import java.math.BigDecimal;

public class CreateDetailRequest extends BaseRequest {

    private long groupId;
    private String project;
    private BigDecimal moneyValue;
    private boolean muchPeopleFlag;
    private boolean partFlag;
    private String remark;

    private CreateDetailMoneyRequest muchPeopleDetailMoneyList;

    private CreateDetailMoneyRequest partDetailMoneyList;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public BigDecimal getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(BigDecimal moneyValue) {
        this.moneyValue = moneyValue;
    }

    public boolean isMuchPeopleFlag() {
        return muchPeopleFlag;
    }

    public void setMuchPeopleFlag(boolean muchPeopleFlag) {
        this.muchPeopleFlag = muchPeopleFlag;
    }

    public boolean isPartFlag() {
        return partFlag;
    }

    public void setPartFlag(boolean partFlag) {
        this.partFlag = partFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CreateDetailMoneyRequest getMuchPeopleDetailMoneyList() {
        return muchPeopleDetailMoneyList;
    }

    public void setMuchPeopleDetailMoneyList(CreateDetailMoneyRequest muchPeopleDetailMoneyList) {
        this.muchPeopleDetailMoneyList = muchPeopleDetailMoneyList;
    }

    public CreateDetailMoneyRequest getPartDetailMoneyList() {
        return partDetailMoneyList;
    }

    public void setPartDetailMoneyList(CreateDetailMoneyRequest partDetailMoneyList) {
        this.partDetailMoneyList = partDetailMoneyList;
    }

    @Override
    public String toString() {
        return "CreateDetailRequest{" +
                "groupId=" + groupId +
                ", project='" + project + '\'' +
                ", moneyValue=" + moneyValue +
                ", muchPeopleFlag=" + muchPeopleFlag +
                ", partFlag=" + partFlag +
                ", remark='" + remark + '\'' +
                ", muchPeopleDetailMoneyList=" + muchPeopleDetailMoneyList +
                ", partDetailMoneyList=" + partDetailMoneyList +
                ", token='" + token + '\'' +
                '}';
    }
}
