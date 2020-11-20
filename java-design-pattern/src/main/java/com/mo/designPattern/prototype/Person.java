package com.mo.designPattern.prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2020/11/20
 */
public class Person implements Cloneable, Serializable {

    private String name;

    private int age;

    private List<String> list = new ArrayList<>();

    public Person() {
        System.out.println("构造函数调用");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }


    /**
     * 深拷贝
     *
     * @return
     */
    public Object deepClone() {
        try {
            //字节输出流、序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            //字节输入流、反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Person obj = (Person) ois.readObject();

            //序列化和反序列化之后，内存地址是会变更的
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
