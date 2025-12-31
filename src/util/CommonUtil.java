package util;
import java.util.*;
public class CommonUtil {

    public static Object[][] toArray(List<Object[]> list)
    {
        Object[][] result = new Object[list.size()][];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
