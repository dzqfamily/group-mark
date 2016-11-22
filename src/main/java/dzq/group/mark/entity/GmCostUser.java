package dzq.group.mark.entity;

import java.util.Date;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class GmCostUser {

	private String costId;
	private String groupId;
	private String purId;
	private String userId;
	private double amount;
	private Date creDate;
	private Date modDate;

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPurId() {
		return purId;
	}

	public void setPurId(String purId) {
		this.purId = purId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
}
