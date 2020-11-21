package com.mo.designPattern.composite;

/**
 * Created by mo on 2020/11/21
 * 这个类是没有子节点，不用存储其他子类数组，所以是叶子节点
 */
public class File extends Root {

    public File(String name) {
        super(name);
    }

    @Override
    public void addFile(Root root) {

    }

    @Override
    public void removeFile(Root root) {

    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        //打印横线和当前文件名
        System.out.println(sb.toString()+this.getName());
    }
}
