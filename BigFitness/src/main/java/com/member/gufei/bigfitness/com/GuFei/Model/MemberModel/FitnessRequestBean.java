package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/3/27.
 */

public class FitnessRequestBean {


    /**
     * Ret : 0
     * Msg : 获取信息成功！
     * rows : [{"dicid":448,"dicName":"减脂"},{"dicid":450,"dicName":"塑形"},{"dicid":449,"dicName":"增肌"},{"dicid":451,"dicName":"产后恢复"},{"dicid":452,"dicName":"康复"},{"dicid":453,"dicName":"柔韧性"},{"dicid":454,"dicName":"反应"},{"dicid":455,"dicName":"休闲"},{"dicid":456,"dicName":"社交"},{"dicid":457,"dicName":"改善体质"},{"dicid":458,"dicName":"竞技性训练（拳击、综合格斗、健身、健美）"}]
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
         * dicid : 448
         * dicName : 减脂
         * dicSelected 已选
         */

        private int dicid;
        private String dicName;

        public RowsBean(int Dicid, String DicName) {
            dicid = Dicid;
            dicName = DicName;
        }

        private boolean dicSelected;

        public int getDicid() {
            return dicid;
        }

        public void setDicid(int dicid) {
            this.dicid = dicid;
        }

        public String getDicName() {
            return dicName;
        }

        public void setDicName(String dicName) {
            this.dicName = dicName;
        }

        public boolean isDicSelected() {
            return dicSelected;
        }

        public void setDicSelected(boolean dicSelected) {
            this.dicSelected = dicSelected;
        }
    }
}
