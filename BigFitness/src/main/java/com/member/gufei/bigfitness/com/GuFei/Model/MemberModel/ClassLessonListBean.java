package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/6/12.
 */

public class ClassLessonListBean {

    /**
     * Ret : 0
     * Msg :
     * TotalPage : 1
     * rows : [{"LessonId":21,"ImageURL":"","LessonName":"200私教"}]
     */

    private int Ret;
    private String Msg;
    private int TotalPage;
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

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * LessonId : 21
         * ImageURL :
         * LessonName : 200私教
         */

        private int LessonId;
        private String ImageURL;
        private String LessonName;
        private String ComeLogId;

        public int getLessonId() {
            return LessonId;
        }

        public void setLessonId(int LessonId) {
            this.LessonId = LessonId;
        }

        public String getImageURL() {
            return ImageURL;
        }

        public void setImageURL(String ImageURL) {
            this.ImageURL = ImageURL;
        }

        public String getLessonName() {
            return LessonName;
        }

        public void setLessonName(String LessonName) {
            this.LessonName = LessonName;
        }

        public String getComeLogId() {
            return ComeLogId;
        }

        public void setComeLogId(String comeLogId) {
            ComeLogId = comeLogId;
        }
    }
}
