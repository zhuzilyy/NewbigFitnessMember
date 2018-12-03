package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/4/10
 */

public class LoginBean {


    /**
     * sex : 男
     * UserLevel : 1
     * code : 0
     * headerURL : 1
     * message : 登录成功!
     * clubId : 1
     * clubList : [{"clubid":1,"clubname":"测试"},{"clubid":23,"clubname":"test会所"},{"clubid":24,"clubname":"test1会所"},{"clubid":25,"clubname":"test2会所"},{"clubid":26,"clubname":"会所1"},{"clubid":27,"clubname":"会所"},{"clubid":28,"clubname":"会所2"},{"clubid":29,"clubname":"123"},{"clubid":30,"clubname":"1233321"},{"clubid":31,"clubname":"zltest会所"},{"clubid":32,"clubname":"苏1"},{"clubid":33,"clubname":"苏2a"},{"clubid":34,"clubname":"苏3a"},{"clubid":35,"clubname":"zltest会所02"},{"clubid":36,"clubname":"临时1"},{"clubid":37,"clubname":"苏苏1"},{"clubid":38,"clubname":"添加会所测试1"},{"clubid":39,"clubname":"123123123"},{"clubid":40,"clubname":"12312312311a"},{"clubid":41,"clubname":"asdadad"},{"clubid":42,"clubname":"机构管理员添加测试会所"},{"clubid":43,"clubname":"苏苏2"},{"clubid":44,"clubname":"123123123abc"},{"clubid":45,"clubname":"123123123abcd"},{"clubid":46,"clubname":"苏苏3"},{"clubid":47,"clubname":"苏苏4"},{"clubid":48,"clubname":"su1"},{"clubid":49,"clubname":"su2"},{"clubid":50,"clubname":"会所01"},{"clubid":51,"clubname":"会所02"},{"clubid":52,"clubname":"会所001"},{"clubid":53,"clubname":"会所002"},{"clubid":54,"clubname":"su3"},{"clubid":55,"clubname":"会所003"},{"clubid":56,"clubname":"添加测试会所"}]
     * token : ae02c13b09e4c59824bbd3dc4c8e2daa1505874546414
     * userId : 8
     * isdepartmanager : 0
     * userName : Aaron
     * departId : 1
     * personType : 平台管理员
     */

    private String sex;
    private int UserLevel;
    private int code;
    private int headerURL;
    private String message;
    private int clubId;
    private String token;
    private int userId;
    private int isdepartmanager;
    private String userName;
    private int departId;
    private String personType;
    private List<ClubListBean> clubList;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUserLevel() {
        return UserLevel;
    }

    public void setUserLevel(int UserLevel) {
        this.UserLevel = UserLevel;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHeaderURL() {
        return headerURL;
    }

    public void setHeaderURL(int headerURL) {
        this.headerURL = headerURL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsdepartmanager() {
        return isdepartmanager;
    }

    public void setIsdepartmanager(int isdepartmanager) {
        this.isdepartmanager = isdepartmanager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public List<ClubListBean> getClubList() {
        return clubList;
    }

    public void setClubList(List<ClubListBean> clubList) {
        this.clubList = clubList;
    }

    public static class ClubListBean {
        /**
         * clubid : 1
         * clubname : 测试
         */

        private int clubid;
        private String clubname;

        public int getClubid() {
            return clubid;
        }

        public void setClubid(int clubid) {
            this.clubid = clubid;
        }

        public String getClubname() {
            return clubname;
        }

        public void setClubname(String clubname) {
            this.clubname = clubname;
        }
    }
}
