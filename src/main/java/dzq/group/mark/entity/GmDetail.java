package dzq.group.mark.entity;

import java.math.BigDecimal;
import java.util.Date;

public class GmDetail {
    private Long id;

    private Long groupId;

    private String openid;

    private String project;

    private BigDecimal moneyValue;

    private String muchPeopleFlag;

    private String partFlag;

    private String remark;

    private Date createdDate;

    private Date modifiedDate;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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
}