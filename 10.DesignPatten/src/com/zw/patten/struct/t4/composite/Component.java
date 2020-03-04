package com.zw.patten.struct.t4.composite;

/**
 * @program: JavaBasic
 * @description: 组合（复合）模式
 * 使所有的组件、容器都有统一的处理方式
 * 存在天然的递归
 * @author: zw-cn
 * @create: 2020-03-04 09:54
 */
public interface Component {
    void operate();
}
interface Leaf extends Component{

}
interface Composite extends Component{
    void add(Component c);
    Component get(int index);
    void remove(Component c);
}
