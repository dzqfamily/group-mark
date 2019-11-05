package dzq.group.mark.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SettleResponse {

    private long id;
    private String nickName;
    private long groupId;
    private int setNum;
    private BigDecimal setMoney;
    private Date createdDate;
    private String createdDateStr;

    List<MemberSetResponse> memberSetList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDateStr() {
        return createdDateStr;
    }

    public void setCreatedDateStr(String createdDateStr) {
        this.createdDateStr = createdDateStr;
    }

    public List<MemberSetResponse> getMemberSetList() {
        return memberSetList;
    }

    public void setMemberSetList(List<MemberSetResponse> memberSetList) {
        this.memberSetList = memberSetList;
    }
}
