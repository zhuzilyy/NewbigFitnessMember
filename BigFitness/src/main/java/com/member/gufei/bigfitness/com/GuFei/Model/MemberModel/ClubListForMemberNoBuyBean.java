package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/4.
 */

public class ClubListForMemberNoBuyBean {


    /**
     * Ret : 0
     * Msg :
     * rows : [{"ClubName":"测试会所一","Address":null,"Introduce":null,"ImageURL":"uploadFiles/uploadImgs/20170907/fbd281f025ea402799e341a9d1a9ee99.png","ClubId":15},{"ClubName":"彩檬科技","Address":null,"Introduce":null,"ImageURL":"uploadFiles/uploadImgs/20170809/bf5353e3ac3042c2af450a17bda17642.png","ClubId":6},{"ClubName":"MAX普兰店店","Address":null,"Introduce":null,"ImageURL":"","ClubId":4},{"ClubName":"MAX朝阳店","Address":null,"Introduce":null,"ImageURL":"","ClubId":3},{"ClubName":"MAX辽阳店","Address":null,"Introduce":null,"ImageURL":"uploadFiles\\","ClubId":2},{"ClubName":"MAX沈北店","Address":"1","Introduce":"3","ImageURL":"uploadFiles/uploadImgs/20170719/3386482103d9429ca136de4f6bf5932b.png","ClubId":1}]
     */

    private int Ret;
    private String Msg;
    private List<RowsBean> rows;

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * ClubName : 测试会所一
         * Address : null
         * Introduce : null
         * ImageURL : uploadFiles/uploadImgs/20170907/fbd281f025ea402799e341a9d1a9ee99.png
         * ClubId : 15
         */

        private String ClubName;
        private Object Address;
        private Object Introduce;
        private String ImageURL;
        private int ClubId;

        public String getClubName() {
            return ClubName;
        }

        public void setClubName(String ClubName) {
            this.ClubName = ClubName;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public Object getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(Object Introduce) {
            this.Introduce = Introduce;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public int getClubId() {
            return ClubId;
        }

        public void setClubId(int ClubId) {
            this.ClubId = ClubId;
        }
    }
}
