package dzq.group.mark.vaild;

import dzq.group.mark.domain.CreateDetailRequest;
import dzq.group.mark.domain.CreateGroupRequest;
import dzq.group.mark.exception.ValidException;
import org.springframework.stereotype.Service;

@Service
public class CreateDetailValid extends BaseValid{


    public void vaild(CreateDetailRequest createDetailRequest) throws ValidException {

        checkObjectNull(createDetailRequest,"createDetailRequest");
//        checkStringNotNullLength(createGroupRequest.getGroupName(), 16, "团名");

    }
}
