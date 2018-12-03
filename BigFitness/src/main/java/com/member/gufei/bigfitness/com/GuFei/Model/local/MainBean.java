package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public class MainBean {
    /**
     * error : 0
     * result : {"msg":[{"a":"a"},{"a":"b"}],"appointment":[{"a":"a"},{"a":"b"}]}
     */

    private int error;
    private ResultBean result;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<MsgBean> msg;
        private List<AppointmentBean> appointment;

        public List<MsgBean> getMsg() {
            return msg;
        }

        public void setMsg(List<MsgBean> msg) {
            this.msg = msg;
        }

        public List<AppointmentBean> getAppointment() {
            return appointment;
        }

        public void setAppointment(List<AppointmentBean> appointment) {
            this.appointment = appointment;
        }

        public static class MsgBean {
            /**
             * a : a
             */

            private String a;

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }
        }

        public static class AppointmentBean {
            /**
             * a : a
             */

            private String a;

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }
        }
    }
}
