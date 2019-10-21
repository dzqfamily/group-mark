package dzq.group.mark.vaild;

import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.exception.ValidException;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class BaseValid {

    protected void checkObjectNull(Object object, String msg) throws ValidException {
        if (object == null) {
            throw new ValidException(ValidExCode.NOT_NULL.getCode(), msg);
        }
    }



}
