package dzq.group.mark.common;

/**
 * Created by duanzhiqiang1 on 2017/3/17.
 */
public enum UserTypeEnum {

	VIRTUAL(0,"虚拟用户"),
	REAL(1,"真实用户");


	private int id;
	private String desc;


	UserTypeEnum(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
