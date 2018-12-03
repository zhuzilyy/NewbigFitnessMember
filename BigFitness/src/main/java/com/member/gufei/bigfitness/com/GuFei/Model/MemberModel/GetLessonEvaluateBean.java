package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel;
/**
 * Created by LiuShengYuan on 2018/10/17.
 */
public class GetLessonEvaluateBean {

    /**
     * Ret : 0
     * Msg :
     * rows : {"LessonEvaluate":{"EvaluateStar":5,"TeacherImageURL":"uploadFiles/uploadImgs/20181017/9ddeca45c16b4acab985ed2ab865de96.jpg,uploadFiles/uploadImgs/20181017/40e48a29f8d84568b919516e332bab1f.jpg,uploadFiles/uploadImgs/20181017/fe37d8639d0741fbb2b7a3d0c4578812.jpg","EvaluateContent":"不错","IsAnonymous":1,"ImageURL":"","TeacherEvaluateStar":5,"TeacherEvaluateContent":"可以","ServiceEvaluateStar":5},"ComeLogId":60,"AppointmentId":438}
     */

    private int Ret;
    private String Msg;
    private RowsBean rows;

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

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * LessonEvaluate : {"EvaluateStar":5,"TeacherImageURL":"uploadFiles/uploadImgs/20181017/9ddeca45c16b4acab985ed2ab865de96.jpg,uploadFiles/uploadImgs/20181017/40e48a29f8d84568b919516e332bab1f.jpg,uploadFiles/uploadImgs/20181017/fe37d8639d0741fbb2b7a3d0c4578812.jpg","EvaluateContent":"不错","IsAnonymous":1,"ImageURL":"","TeacherEvaluateStar":5,"TeacherEvaluateContent":"可以","ServiceEvaluateStar":5}
         * ComeLogId : 60
         * AppointmentId : 438
         */

        private LessonEvaluateBean LessonEvaluate;
        private int ComeLogId;
        private int AppointmentId;

        public LessonEvaluateBean getLessonEvaluate() {
            return LessonEvaluate;
        }

        public void setLessonEvaluate(LessonEvaluateBean LessonEvaluate) {
            this.LessonEvaluate = LessonEvaluate;
        }

        public int getComeLogId() {
            return ComeLogId;
        }

        public void setComeLogId(int ComeLogId) {
            this.ComeLogId = ComeLogId;
        }

        public int getAppointmentId() {
            return AppointmentId;
        }

        public void setAppointmentId(int AppointmentId) {
            this.AppointmentId = AppointmentId;
        }

        public static class LessonEvaluateBean {
            /**
             * EvaluateStar : 5
             * TeacherImageURL : uploadFiles/uploadImgs/20181017/9ddeca45c16b4acab985ed2ab865de96.jpg,uploadFiles/uploadImgs/20181017/40e48a29f8d84568b919516e332bab1f.jpg,uploadFiles/uploadImgs/20181017/fe37d8639d0741fbb2b7a3d0c4578812.jpg
             * EvaluateContent : 不错
             * IsAnonymous : 1
             * ImageURL :
             * TeacherEvaluateStar : 5
             * TeacherEvaluateContent : 可以
             * ServiceEvaluateStar : 5
             */

            private int EvaluateStar;
            private String TeacherImageURL;
            private String EvaluateContent;
            private int IsAnonymous;
            private String ImageURL;
            private int TeacherEvaluateStar;
            private String TeacherEvaluateContent;
            private int ServiceEvaluateStar;

            public int getEvaluateStar() {
                return EvaluateStar;
            }

            public void setEvaluateStar(int EvaluateStar) {
                this.EvaluateStar = EvaluateStar;
            }

            public String getTeacherImageURL() {
                return TeacherImageURL;
            }

            public void setTeacherImageURL(String TeacherImageURL) {
                this.TeacherImageURL = TeacherImageURL;
            }

            public String getEvaluateContent() {
                return EvaluateContent;
            }

            public void setEvaluateContent(String EvaluateContent) {
                this.EvaluateContent = EvaluateContent;
            }

            public int getIsAnonymous() {
                return IsAnonymous;
            }

            public void setIsAnonymous(int IsAnonymous) {
                this.IsAnonymous = IsAnonymous;
            }

            public String getImageURL() {
                return ImageURL;
            }

            public void setImageURL(String ImageURL) {
                this.ImageURL = ImageURL;
            }

            public int getTeacherEvaluateStar() {
                return TeacherEvaluateStar;
            }

            public void setTeacherEvaluateStar(int TeacherEvaluateStar) {
                this.TeacherEvaluateStar = TeacherEvaluateStar;
            }

            public String getTeacherEvaluateContent() {
                return TeacherEvaluateContent;
            }

            public void setTeacherEvaluateContent(String TeacherEvaluateContent) {
                this.TeacherEvaluateContent = TeacherEvaluateContent;
            }

            public int getServiceEvaluateStar() {
                return ServiceEvaluateStar;
            }

            public void setServiceEvaluateStar(int ServiceEvaluateStar) {
                this.ServiceEvaluateStar = ServiceEvaluateStar;
            }
        }
    }
}
