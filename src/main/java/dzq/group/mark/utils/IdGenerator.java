package dzq.group.mark.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by duanzhiqiang1 on 2017/3/17.
 */
public class IdGenerator {

	private final static AtomicLong num = new AtomicLong(0);

	public static String getId() {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Date now = new Date();

		String dataFormat = format.format(now);

		long next = num.addAndGet(1);
		if (next > 99999999) {
			next = num.getAndSet(0);
		}
		String numFormat = String.format("%08d", next);

		return dataFormat + numFormat;
	}
}
