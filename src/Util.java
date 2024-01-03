import java.text.SimpleDateFormat;

public class Util {
	public static String getDateTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String strNowDate = simpleDateFormat.format(simpleDateFormat);

		return strNowDate;

	}

}
