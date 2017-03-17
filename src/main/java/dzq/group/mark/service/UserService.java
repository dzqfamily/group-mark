package dzq.group.mark.service;

import dzq.group.mark.entity.GmUser;
import dzq.group.mark.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by duanzhiqiang1 on 2016/11/28.
 */
@Service("userService")
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public String regist(GmUser gmUser) {
		return userMapper.insert(gmUser);
	}

}
