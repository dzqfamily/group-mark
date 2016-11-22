package dzq.group.mark.entity;

import java.util.Date;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class GmPurchase {
	private String purId;
	private String groupId;
	private String creUser;
	private double amount;
	private int status;
	private Date creDate;
	private Date modDate;

	public String getPurId() {
		return purId;
	}

	public void setPurId(String purId) {
		this.purId = purId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCreUser() {
		return creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
