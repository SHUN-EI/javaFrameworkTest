package com.mo.designPattern.flyweight;

/**
 * Created by mo on 2020/11/23
 */
public class Main {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        CloudWebSite companySite = factory.getWebSiteByCategory("企业官网");
        companySite.run(new Company("顺丰科技"));

        CloudWebSite byteDanceSite = factory.getWebSiteByCategory("信息流");
        byteDanceSite.run(new Company("字节跳动"));

        System.out.println("网站分类总数 " + factory.getWebsiteCategorySize());

    }
}
