package dzq.group.mark.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    //str length = 17
    private static String dataFormat17 = "yy-MM-dd HH:mm:ss";
    //str length = 6
    private static String dataFormat6 = "yyyyMM";

    public static String format17(Date date) {

        return new SimpleDateFormat(dataFormat17).format(date);

    }

    public static String format6(Date date) {

        return new SimpleDateFormat(dataFormat6).format(date);

    }

}
