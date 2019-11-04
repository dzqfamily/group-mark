package dzq.group.mark.entity;

import java.math.BigDecimal;
import java.util.Date;

public class GmSettle {
    private Long id;

    private Long groupId;

    private Integer setNum;

    private BigDecimal setMoney;

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

    public Integer getSetNum() {
        return setNum;
    }

    public void setSetNum(Integer setNum) {
        this.setNum = setNum;
    }

    public BigDecimal getSetMoney() {
        return setMoney;
    }

    public void setSetMoney(BigDecimal setMoney) {
        this.setMoney = setMoney;
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