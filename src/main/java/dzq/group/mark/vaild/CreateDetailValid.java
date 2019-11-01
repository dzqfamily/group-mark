package dzq.group.mark.vaild;

import dzq.group.mark.domain.DetailRequest;
import dzq.group.mark.exception.ValidException;
import org.springframework.stereotype.Service;

@Service
public class CreateDetailValid extends BaseValid{


    public void vaild(DetailRequest createDetailRequest) throws ValidException {

        checkObjectNull(createDetailRequest,"createDetailRequest");
//        checkStringNotNullLength(createGroupRequest.getGroupName(), 16, "团名");

    }
}
