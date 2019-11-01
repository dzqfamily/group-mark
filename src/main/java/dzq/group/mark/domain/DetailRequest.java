package dzq.group.mark.domain;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.List;

public class DetailRequest extends BaseRequest {
    private long id;
    private long groupId;
    private String project;
    private BigDecimal moneyValue;
    private boolean muchPeopleFlag;
    private boolean partFlag;
    private String remark;
    private String muchPeopleDetail;
    private String partDetail;
    private List<CreateDetailMoneyRequest> muchPeopleDetailMoneyList;
    private List<CreateDetailMoneyRequest> partDetailMoneyList;

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

    public String getMuchPeopleDetail() {
        return muchPeopleDetail;
    }

    public void setMuchPeopleDetail(String muchPeopleDetail) {
        this.muchPeopleDetail = muchPeopleDetail;
        this.muchPeopleDetailMoneyList = JSON.parseArray(muchPeopleDetail, CreateDetailMoneyRequest.class);

    }

    public List<CreateDetailMoneyRequest> getMuchPeopleDetailMoneyList() {
        return muchPeopleDetailMoneyList;
    }

    public void setMuchPeopleDetailMoneyList(List<CreateDetailMoneyRequest> muchPeopleDetailMoneyList) {
        this.muchPeopleDetailMoneyList = muchPeopleDetailMoneyList;
    }

    public String getPartDetail() {
        return partDetail;
    }

    public void setPartDetail(String partDetail) {
        this.partDetail = partDetail;
        this.partDetailMoneyList = JSON.parseArray(partDetail, CreateDetailMoneyRequest.class);
    }

    public List<CreateDetailMoneyRequest> getPartDetailMoneyList() {
        return partDetailMoneyList;
    }

    public void setPartDetailMoneyList(List<CreateDetailMoneyRequest> partDetailMoneyList) {
        this.partDetailMoneyList = partDetailMoneyList;
    }

    @Override
    public String toString() {
        return "DetailRequest{" +
                "groupId=" + groupId +
                ", project='" + project + '\'' +
                ", moneyValue=" + moneyValue +
                ", muchPeopleFlag=" + muchPeopleFlag +
                ", partFlag=" + partFlag +
                ", remark='" + remark + '\'' +
                ", muchPeopleDetail=" + muchPeopleDetail +
                ", partDetail=" + partDetail +
                ", token='" + token + '\'' +
                '}';
    }
}
