package dzq.group.mark.vaild;

import dzq.group.mark.domain.RegisterUser;
import dzq.group.mark.exception.VaildException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
@Service("registerUserValid")
public class RegisterUserValid extends BaseValid{

	private final String mobilePhoneReg = "^1[0-9]{10}$";
	private final String nickName = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$";

	public void vaild(RegisterUser registerUser) throws VaildException {
		String mobilePhone = registerUser.getMobilePhone();
		Pattern pattern = Pattern.compile(mobilePhoneReg);
		Matcher matcher = pattern.matcher(mobilePhone);
		if (!matcher.matches()) {
			throw new VaildException();
		}
	}
}
