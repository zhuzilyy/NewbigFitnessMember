package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/6.
 */

public class ClubImagesBean {

    /**
     * Ret : 0
     * Msg :
     * rows : [{"ImageURL":"uploadFiles/uploadImgs/2.jpg"},{"ImageURL":"uploadFiles/uploadImgs/2.jpg"}]
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
         * ImageURL : uploadFiles/uploadImgs/2.jpg
         */

        private String ImageURL;

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }
    }
}
