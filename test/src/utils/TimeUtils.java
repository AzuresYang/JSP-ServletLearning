package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 28029 on 2017/9/18.
 */
public class TimeUtils {

    public static String getCurrentTime(){
        return getTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentTime(String format){
        return getTime(format);
    }
    private static String getTime(String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }
}
