package dzq.group.mark.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GmDetailView {
    private Long id;

    private Long groupId;

    private String createNickName;

    private String project;

    private BigDecimal moneyValue;

    private String moneyValueStr;

    private String muchPeopleFlag;

    private String partFlag;

    private String remark;

    private String status;

    private String statusName;

    private Date createdDate;

    private String createdDateStr;

    private Date modifiedDate;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateNickName() {
        return createNickName;
    }

    public void setCreateNickName(String createNickName) {
        this.createNickName = createNickName;
    }

    public String getMoneyValueStr() {
        return moneyValueStr;
    }

    public void setMoneyValueStr(String moneyValueStr) {
        this.moneyValueStr = moneyValueStr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
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

    public String getMuchPeopleFlag() {
        return muchPeopleFlag;
    }

    public void setMuchPeopleFlag(String muchPeopleFlag) {
        this.muchPeopleFlag = muchPeopleFlag;
    }

    public String getPartFlag() {
        return partFlag;
    }

    public void setPartFlag(String partFlag) {
        this.partFlag = partFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedDateStr() {
        return createdDateStr;
    }

    public void setCreatedDateStr(String createdDateStr) {
        this.createdDateStr = createdDateStr;
    }
}