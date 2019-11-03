package dzq.group.mark.domain;

import java.math.BigDecimal;
import java.util.List;

public class DetailInfoResponse extends BaseRequest {
    private long id;
    private long groupId;
    private String project;
    private String moneyValue;
    private boolean muchPeopleFlag;
    private boolean partFlag;
    private String remark;
    private List<MemberMoneyResponse> memberMoneyList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(String moneyValue) {
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

    public List<MemberMoneyResponse> getMemberMoneyList() {
        return memberMoneyList;
    }

    public void setMemberMoneyList(List<MemberMoneyResponse> memberMoneyList) {
        this.memberMoneyList = memberMoneyList;
    }

}
