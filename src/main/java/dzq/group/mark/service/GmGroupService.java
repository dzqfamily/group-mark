package dzq.group.mark.service;

import dzq.group.mark.domain.BaseRequest;
import dzq.group.mark.domain.CreateGroupRequest;
import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;
import dzq.group.mark.entity.GmUser;
import dzq.group.mark.mapper.GmGroupMapper;
import dzq.group.mark.mapper.GmGroupMemberMapper;
import dzq.group.mark.mapper.GmUserMapper;
import dzq.group.mark.utils.JJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class GmGroupService {
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmGroupMapper gmGroupMapper;
    @Autowired
    private GmGroupMemberMapper gmGroupMemberMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createGroup(CreateGroupRequest createGroupRequest) {

        GmUser gmUser = gmUserService.getUserByToken(createGroupRequest.getToken());

        GmGroup gmGroup = new GmGroup();
        gmGroup.setGroupName(createGroupRequest.getGroupName());
        gmGroup.setOpenid(gmUser.getOpenid());

        gmGroupMapper.insert(gmGroup);

        if (!StringUtils.isEmpty(createGroupRequest.getMemberList())) {
            Arrays.stream(createGroupRequest.getMemberList().split(",")).forEach(groupMember -> {
                GmGroupMember ggm = new GmGroupMember();
                ggm.setGroupId(gmGroup.getId());
                ggm.setMemberName(groupMember);
                ggm.setOpenid(gmUser.getOpenid());
                gmGroupMemberMapper.insert(ggm);
            });

        }




    }

    public List<GmGroup> selectMyGroup(BaseRequest baseRequest) {
        GmUser gmUser = gmUserService.getUserByToken(baseRequest.getToken());
        return gmGroupMapper.selectMyGroup(gmUser.getOpenid());
    }
}
