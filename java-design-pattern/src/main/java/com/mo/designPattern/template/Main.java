package com.mo.designPattern.template;

/**
 * Created by mo on 2020/11/23
 */
public class Main {

    public static void main(String[] args) {
        AbstractProjectManager manager;

        manager = new PayServiceProjectManager();
        manager.processProject();

        System.out.println("=============================================");
        manager = new UserServiceProjectManager();
        manager.processProject();
    }
}
