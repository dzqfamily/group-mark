package dzq.group.mark.vaild;

import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.exception.ValidException;
import org.springframework.util.StringUtils;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class BaseValid {

    protected void checkObjectNull(Object object, String msg) throws ValidException {
        if (object == null) {
            throw new ValidException(ValidExCode.NOT_NULL.getCode(), msg);
        }
    }
    protected void checkStringNotNullLength(String param,int length, String msg) throws ValidException {
        if (StringUtils.isEmpty(param)) {
            throw new ValidException(ValidExCode.STRING_NOT_NULL.getCode(), msg);
        }
        checkStringLength(param, length, msg);
    }

    protected void checkStringLength(String param,int length, String msg) throws ValidException {
        if (!StringUtils.isEmpty(param) && msg.length() > length) {
            throw new ValidException(ValidExCode.STRING_OVERLENGTH.getCode(), msg);
        }

    }


}
