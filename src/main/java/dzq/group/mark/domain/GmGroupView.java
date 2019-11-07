package dzq.group.mark.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GmGroupView {

    private Long id;

    private String groupName;

    private boolean deleteFlag;

    private Date createdDate;

    private Date modifiedDate;

    private String unSetMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getUnSetMoney() {
        return unSetMoney;
    }

    public void setUnSetMoney(String unSetMoney) {
        this.unSetMoney = unSetMoney;
    }


}
