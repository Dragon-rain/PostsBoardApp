package utils;

import java.util.Date;

public class DateUtil {

	public static java.sql.Date getCurrentSqlDate() {
		Date today = new Date();
		return new java.sql.Date(today.getTime());
	}

}
