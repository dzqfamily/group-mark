package dzq.group.mark.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class IdGenUtil {

	private static AtomicLong atomicLong = new AtomicLong(0);

	private static final String PRE_USER = "10";
	private static final String PRE_GROUP = "20";

	public static String genUserId(){
		return PRE_USER + new SimpleDateFormat("yyyymmdd").format(new Date()) + String.format("%08d",atomicLong.addAndGet(1));
	}

	public static void main(String[] args) {
		System.out.println(genUserId());
	}
}
