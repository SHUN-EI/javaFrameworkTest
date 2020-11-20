package com.mo.designPattern.builder;

/**
 * Created by mo on 2020/11/20
 * 将产品和创建过程进行解耦，使用相同的创建过程创建不同的产品，控制产品生产过程
 * Director是全程指导组装过程，具体的细节还是builder去操作
 */
public class Director {

    public Computer create(ComputerBuilder builder) {

        builder.buildCPU();
        builder.buildDisk();
        builder.buildMainboard();
        builder.buildMemory();
        builder.buildPower();

        return builder.createComputer();
    }
}
