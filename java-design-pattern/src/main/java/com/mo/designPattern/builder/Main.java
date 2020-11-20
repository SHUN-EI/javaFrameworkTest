package com.mo.designPattern.builder;

/**
 * Created by mo on 2020/11/20
 */
public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        Computer lowComputer = director.create(new LowComputerBuilder());
        Computer highComputer = director.create(new HighComputerBuilder());

        System.out.println(lowComputer.toString());
        System.out.println(highComputer.toString());
    }
}
