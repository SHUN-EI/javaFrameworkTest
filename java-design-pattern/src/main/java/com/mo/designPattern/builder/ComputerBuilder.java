package com.mo.designPattern.builder;

/**
 * Created by mo on 2020/11/20
 * 声明了建造者的公共方法
 */
public interface ComputerBuilder {

    /**
     * 细节方法
     */
    void buildCPU();

    void buildMainboard();

    void buildDisk();

    void buildPower();

    void buildMemory();

    Computer createComputer();

}
