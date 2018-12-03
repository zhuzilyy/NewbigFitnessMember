package com.member.gufei.bigfitness.com.GuFei.Model;


/**
 * Created by GuFei_lyf on 2017/3/21
 *
 * APK 升级
 */

public class ApkUpdataModel{

    /**
     * id : 5
     * versionno : 版本:1.5
     * url : https://www.soujuw.com/app/appShopWeb.apk
     * content : 文件大小:4.81MB||更新内容: |1.添加WebView加载进度动画|2.添加微信分享|3.修改应用退出后网页线程未关闭BUG|4.优化耗电量
     * type : 2
     * must : 1
     */

    private int id;

    private String versionno;
    private String url;

    private String content;
    private int type;
    private int must;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionno() {


        return versionno;
    }

    public void setVersionno(String versionno) {


        this.versionno = versionno;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMust() {
        return must;
    }

    public void setMust(int must) {
        this.must = must;
    }
}
