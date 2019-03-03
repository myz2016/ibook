import com.mfh.model.Department;
import com.mfh.model.Role;
import com.mfh.model.User;
import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;

import java.util.*;

public class OgnlTest {
    @Test
    public void getValueFromRoot() {
        try {
            /**
             * Ognl中最重要的概念是根（root），全称：Object-Graph Navigation Language（对象图形导航语言）
             * hzz使用ognl可以表示为：
             *         hzz
             *          -- name
             *          -- age
             */
            User hzz = new User("贺知章", 109);
            /**
             * 使用Ognl取值
             * 第一个参数表示一个表达式，也就是从根中取值，第二个参数就是根，这里的根就是hzz这个对象
             * 所以以下语句的意义是：从hzz中将name的值取出来
             */
            System.out.println(Ognl.getValue("name", hzz));
            Department dep = new Department(203, "编辑部");
            hzz.setDep(dep);
            /**
             * hzz使用ognl可以表示为：
             *         hzz
             *          -- name
             *          -- age
             *          -- dep
             *              -- id
             *              -- depName
             * hzz对象中，设置了部门，以hzz为根，取部门的名称
             */
            System.out.println(Ognl.getValue("dep.depName", hzz));
            /**
             * 以部门为根，取部门名称
             */
            System.out.println(Ognl.getValue("depName", dep));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getValueFromMap() {
        Map<String, Object> map = new HashMap<>();
        User bjy = new User("白居易", 300);
        Department chb = new Department(1, "策划部");
        bjy.setDep(chb);
        Role superMan = new Role(1, "超级管理员");
        map.put("bjy", bjy);
        map.put("superMan", superMan);
        try {
            /**
             * 以下是从root中取值，bjy是root
             * 从root中取值不需要加 #
             */
            System.out.println(Ognl.getValue("name", map, bjy));
            /**
             * 以下是从map中取值
             * 从map中取值需要加 #
             * 想一想struts2的s标签，使用s标签取值的是，往往都是需要加#的，也就是从map中取值的方式
             * 比如：<s:property value="#name"/>
             */
            System.out.println(Ognl.getValue("#bjy.name", map, bjy));
            System.out.println(Ognl.getValue("#bjy.dep.depName", map, bjy));

            /**
             * 当从map中找值时，第三个参数就没有什么作用了，写一个毫不相干的对象也不会有影响，比如chb，chb与superMan没有任何关系
             * 当从root中取值时，第二个参数也就没有什么作用了，同上
             */
            System.out.println(Ognl.getValue("#superMan.roleName", map, chb));
            /**
             * root是map，所以也可以直接取到值
             */
            System.out.println(Ognl.getValue("superMan.roleName", map, map));
            /**
             * 以下方式也可以取到值
             * 注意：取值的方式是#，根据上面的理论，这是从map中取值的方式，但是现在将第二个参数map
             * 换成一个毫不相干的map，同样也可以取到值。但是如果将最后一个参数换成chb，就会报错。
             * 报错信息为：Department中不存在name属性
             * 看来使用#方式取值也与第三个参数有关系了？反而与第二个参数没有关系了,这是为什么呢？
             * 原因：
             *   这里的root是struts2的root，是一个大的根，所有的对象会被放在这个root下面，这个root是一个map，也就是ActionContext。
             *   所以可以使用#root来取根元素中的所有数据，它其实就是一个大map。
             * 因为是从root中取bjy对象中的值，所以当然与第三个参数有关系了。
             *   root
             *      -- chb
             *          -- name
             *          -- age
             *          -- dep
             * Ognl其实就是一个大的Context，根的Key就是root，所以可以通过#root.xxx来取值
             */
            System.out.println(Ognl.getValue("#root.name", map, bjy));
            /**
             * 从struts的root中取值，与第二个参数没有关系
             */
            System.out.println(Ognl.getValue("#root.dep.depName", new HashMap(), bjy));
            System.out.println(Ognl.getValue("#root.roleName", new TreeMap(), superMan));
        } catch (OgnlException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getValueFromList() {
        List<User> users = new ArrayList<User>();
        users.add(new User("李白", 122));
        users.add(new User("杜甫", 342));
        users.add(new User("骆宾王", 232));
        users.add(new User("李清照", 132));
        try {
            /**
             * 从root中取得users中的第0个元素的name值
             */
            System.out.println(Ognl.getValue("#root[0].name", users));

            /**
             * ognl还可以调用方法
             */
            System.out.println(Ognl.getValue("#root[2].sum(1,2)", users));

            /**
             * 调用was对象的say()方法
             */
            User was = new User("王安石", 543);
            System.out.println(Ognl.getValue("say('hello')", was));

            /**
             * Ognl可以调用对象的方法，所以也可以这么用
             * users是一个集合对象，那么集合有get()方法
             */
            System.out.println(Ognl.getValue("get(3).name", users));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }
}
