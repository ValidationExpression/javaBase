package com.hhxy;

import java.util.Arrays;

public class Demo01_fanxing<E> {
    Object[] objects=new Object[5];
    int size;

    /**
     * E:表示的是不确定的类型,方便其他人调用
     */
    //添加数据
    public boolean add(E e){
        objects[size]=e;
        size++;
        return true;
    }
    //删除数据
    public E get(int index){
        //此时需要强转
        return (E) objects[index];
    }
    //将数组以字符形式返回
    @Override
    public String toString(){
        return Arrays.toString(objects);
    }

}
