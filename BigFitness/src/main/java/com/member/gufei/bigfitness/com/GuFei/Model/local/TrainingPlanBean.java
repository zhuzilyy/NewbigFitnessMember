package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class TrainingPlanBean {

    /**
     * error : 0
     * result : [{"name":"胸部0","list":[{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"}]},{"name":"胸部1","list":[{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"}]},{"name":"胸部2","list":[{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"}]}]
     */

    private int error;
    private List<ResultBean> result;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * name : 胸部0
         * list : [{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"},{"content":" 哑铃仰卧飞鸟(4组*10)"}]
         */

        private String name;
        private List<ListBean> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * content :  哑铃仰卧飞鸟(4组*10)
             */

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
