package cc.openHome.test;

import cc.openHome.test.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 28029 on 2017/9/18.
 */
public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Student student=new Student();
        Map map=new HashMap();
        map.put("name", "ldl");
        map.put("age", 22);
        map.put("id", "2");
        map.put("sex", "男女");
        BeanUtils.populate(student, map);//populate方法
        System.out.println(student.toString());


    }
}


