package dzq.group.mark.vaild;

import dzq.group.mark.domain.CreateGroupRequest;
import dzq.group.mark.exception.ValidException;
import org.springframework.stereotype.Service;

@Service
public class CreateGroupValid extends BaseValid{


    public void vaild(CreateGroupRequest createGroupRequest) throws ValidException {

        checkObjectNull(createGroupRequest,"createGroupRequest");
        checkStringNotNullLength(createGroupRequest.getGroupName(), 16, "团名");

    }
}
