package com.zw.jdk10;

import java.util.*;

/**
 * <p>Title: JavaBasic-com.zw.jdk10</p>
 * <p>Description: copyOf方法</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/25/2020
 */
public class JDK_01_Common_02_copyOf {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        var list2 = List.copyOf(list);
        System.out.println(list2);
        //list2.add("e");//不可修改 java.lang.UnsupportedOperationException

        var set = new HashSet<String>();
        set.add("s2");
        set.add("s1");
        set.add("s3");
        set.add("s4");
        var set2 = Set.copyOf(set);
        System.out.println(set2);

        var map = new HashMap<Integer,String>();
        map.put(2,"map2");
        map.put(1,"map1");
        map.put(3,"map3");
        var map2 = Map.copyOf(map);
        System.out.println(map2);
    }
}
