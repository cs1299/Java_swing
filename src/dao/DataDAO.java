package dao;

import util.*;

import java.util.*;

public class DataDAO {
    public static final Object[] columnNames={"题号","题目内容","选项A","选项B","选项C","选项D","答案"};

    public static  final List<Object[]> data=new ArrayList<>();

    public static int maxId =2;
    static {
        data.add(new Object[]{1,"下列哪个选项不是Java的标识符？","1","2","3","4","4"});
        data.add(new Object[]{2,"哪个选项是String的标识符？","1","2","3","4","5"});

    }
    public static Object[][] search(int col, String text){
        List<Object[]> result=new ArrayList<>();
        for(Object[] row:data){
            if(row[col].toString().contains(text)){
                result.add(row);
            }
        }
        return CommonUtil.toArray(result);

    }

    public static void add(Object[] obj){
        obj[0]=++maxId;
        data.add(obj);
    }
    public static Object[] findById(Object id){
        for(Object[] row:data)
            if(row[0].equals(id))
                return row;
        return null;
    }

    public static void update(Object[] obj, Object id) {
        for (int i = 0; i < data.size(); i++){
            if (data.get(i)[0].equals(id)) {
                data.set(i, obj);
                break;
            }
        }
    }

    public static void delete(Object id) {
        for (int i = 0; i < data.size(); i++)
            if (data.get(i)[0].equals(id)) {
                data.remove(i);
                break;
            }
    }
}
