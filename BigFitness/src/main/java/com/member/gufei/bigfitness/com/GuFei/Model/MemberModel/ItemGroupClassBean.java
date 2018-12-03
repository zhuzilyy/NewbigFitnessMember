package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;

import java.util.List;

/**
 * Created by GuFei on 2018/4/12.
 */

public class ItemGroupClassBean {

    private List<GroupLessonClassTimeBean> GroupLessonClassTime;

    public List<GroupLessonClassTimeBean> getGroupLessonClassTime() {
        return GroupLessonClassTime;
    }

    public void setGroupLessonClassTime(List<GroupLessonClassTimeBean> GroupLessonClassTime) {
        this.GroupLessonClassTime = GroupLessonClassTime;
    }

    public static class GroupLessonClassTimeBean {
        /**
         * ClassTime : 13:30~14:30
         * LessonDate : 2017-12-26
         */

        private String ClassTime;
        private String LessonDate;

        public String getClassTime() {
            return ClassTime;
        }

        public void setClassTime(String ClassTime) {
            this.ClassTime = ClassTime;
        }

        public String getLessonDate() {
            return LessonDate;
        }

        public void setLessonDate(String LessonDate) {
            this.LessonDate = LessonDate;
        }
    }
}
