package dao;
import pojo.User;

import java.util.*;
public class AdminDAO {
    public static final Object[] columnNames = {"ID","Name","Password"};

    //存储数据
    public static List<Object[]> data = new ArrayList<Object[]>();

    //初始数据
    static {
        data.add(new Object[] {1,"zly","123456"});
        data.add(new Object[] {2,"js","123456"});
        data.add(new Object[] {3,"hjx","123456"});
        data.add(new Object[] {4,"cze","123456"});
    }
    //查询用户
    public static User getUser(String name,String password) {
    for(Object[] user : data) {
            if(user[1].equals(name)) {
                return new User((Integer)user[0],(String)user[1],(String)user[2]);
            }
        }
        return null;
    }

    public static void updatePassword(Integer id, String password) {
        for(Object[] user : data) {
            if(user[0].equals(id)) {
                user[2] = password;
                break;
            }
        }
    }

}
