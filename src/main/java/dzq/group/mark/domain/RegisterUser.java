package dzq.group.mark.domain;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class RegisterUser {

	private String mobilePhone;
	private String nickName;
	private String password;

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterUser{" +
				"mobilePhone='" + mobilePhone + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}
