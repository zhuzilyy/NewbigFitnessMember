package com.member.gufei.bigfitness;

import java.io.File;

/**
 * Created by GuFei_lyf on 2017/3/21
 * <p>
 * 静态配置表
 * <p>
 * 包括服务器地址,消息类型,返回消息类型,筛选下拉列表内容
 */

public interface Constants {

    long CACHE_SIZE = 10 * 1024 * 1024; // OkHttp 缓存大小 10M
    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    long CONNECT_TIMEOUT = 10; // 连接超时时间设置
    String DATABASE_NAME = "myRealm.realm";//2
    long INTERVAL = 1000L;
    long TIME = 60 * 1000L;
    long TIME1 = 1000L;

    //    String BASEURL = "http://192.168.51.101:8080/MaxFit/";//大勇
//    String BASEURL = "http://192.168.31.94/";//ＨＯＭＥ　ＭＡＣ
//    String BASEURL = "http://www.a.com/";//ＨＯＭＥ　ＭＡＣ
//    String BASEURL = "http://jy00712345.55555.io:8081/";///外网
//    String BASEURL = "http://175.146.123.3:8081/";///外网
   //String BASEURL = "http://www.18bai6.cn:8080";//外网域名
   String BASEURL = "http://www.clfitsys.com:8080";//外网域名
    //      String IMGURL = "http://www.clfitsys.com:8081";//外网图片域名
//      String IMGURL = "http://www.18bai6.cn:9082";//外网图片域名
    String IMGURL = "http://www.clfitsys.com";

//      String BASEURL = "http://175.147.78.57:8081/";//外网

//    String BASEURL = "http://192.168.51.225:8444/MaxFit/";//self
//    String BASEURL = "http://192.168.51.189:8080/";//
//    String BASEURL = "http://flyfly4545.tunnel.qydev.com/MaxFit/";//self
//    String BASEURL = "http://abccd.tunnel.qydev.com/MaxFit/";//self
//    String BASEURL = "http://60.205.170.216/";//阿里
//    String BASEURL = "http://www.clfitsys.com/";//阿里域名
//    String BASEURL = "http://211.159.175.148/";//外网
//    String BASEURL = "http://123.207.246.64/";//外网/
//    String BASEURL = "http://192.168.51.165:8080/MaxFit/";//张师傅

    int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;

    String RESULT_TYPE = "result_type";
    String RESULT_ID = "result_id";
    String RESULT_STRING = "result_string";
    String RESULT_TEL = "result_tel";
    String RESULT_SEX = "result_sex";
    String PUT_STR = "com.GuFei.pub_string";


    /**
     * 预约页面
     */
    int ID_ACTIVITY_APPOINTMEN = 6000;


    /**
     * 私教课付款
     */
    int ID_PRIVATE_CLASS = 5000;


    /**
     * 会员卡续费付款
     */
    int ID_PRIVATE_RENEWAL = 5001;


    /**
     * 团体课付款
     */
    int ID_GROUPLESSON = 5002;


    /**
     * 会员卡买卡
     */
    int ID_CARD_BUY = 5003;


    /**
     * 会员卡升级付款
     */
    int ID_CARD_UP = 5004;


    /**
     * 会员卡续费付款
     */
    int ID_CARD_RENEWAL = 5005;

    /**
     * 私教课续费付款
     */
    int ID_PRIVATE_CLASS_RENEWAL = 5007;


    /**
     * 操课付款
     */
    int ID_AERIBICS_RENEWAL = 5006;


    int ACTIVITY_ID_MEMBERS = 4003;
    /**
     * 会员页面
     */
    int ACTIVITY_ID_PRIVATE_MEMBERS = 4004;
    /**
     * 私教会员页面
     */
    int ACTIVITY_ID_REPORT = 4005;
    /**
     * 体测记录
     */
    int ACTIVITY_ID_REPORT_APPOINTMENT = 4006;
    /**
     * 预约记录
     */
    int ACTIVITY_ID_CLASS_RECORD = 4007;
    /**
     * 课程记录
     */
    int ACTIVITY_ID_RECORDS_GIVING = 4008;
    /**
     * 赠送记录
     */

    int RESULT_SUCCESS = 1;
    int RESULT_FAILED = 2;


    String SELECTSEXKEY = "selectsexkey";
    /**
     * 性别选择
     */
    String SELECTNAMEKEY = "selectnamekey";
    /**
     * 姓名
     */

    String SELECTBRITHADAYEY = "selectbrithadayey";
    /**
     * 生日
     */

    String SELECTHEIGHTKEY = "selectheightkey";
    /**
     * 身高选择
     */
    String SELECTWEIGHTKEY = "selectweightkey";
    /**
     * 体重选择
     */

    String LATITUDEKEY = "";
    /**
     * 经度
     */
    String LONGITUDEKEY = "";
    /**
     * 纬度
     */
    String LOCATIONKEY = "";


    String ACCOUNTKEY = "account";
    /**
     * 用户名
     */
    String PASSWRODKEY = "password";
    /**
     * 用户密码
     */
    String DEVICECODEKEY = "deviceCode";
    /**
     * 设备号
     */
    String MOBLIEKEY = "mobilehid";
    /**
     * 用户电话
     */
    String USERIDKEY = "userid";
    /**
     * 用户ID
     */
    int USERID = 1;


    String WELCOMESHOWKEY = "welcomeShow";
//    欢迎页显示

    String SEXKEY = "sex";
    /**
     * 用户性别
     */
    String TOKENKEY = "token";
    /**
     * 设备号
     */


    String HEADERURLKEY = "headerurl";
    /**
     * 头像
     */
    String BIRTHDAYKEY = "birthday";
    /**
     * 生日
     */
    String HEIGHTKEY = "height";
    /**
     * 身高
     */
    String FITNESSREQUESTKEY = "fitnessrequest";
    /**
     * 健身需求id
     */
    String NICKNAMEKEY = "nickname";
    /**
     * 昵称
     */
    String WEIGHTKEY = "weight";
    /**
     * 体重
     */
    String FITNESSREQUESTNAMEKEY = "fitnessrequestname";
    /**
     * 健身需求名称
     */
    String FITNESSREQUESTLISTKEY = "fitnessrequestlist";
    /**
     * 健身需求列表
     */
    String SELECTEDCULBIDKEY = "selectedculbid";
    /**
     * 当前选择会所
     */

    String MEMBERIDKEY = "memberidkey";
    /**
     * 当前会员ID
     */

    String ISLOCKKEY = "islockkey";
    /**
     * 是否冻结
     */


    String LOGINKEY = "LoginId";
    /**
     * 登录标志
     */
    String CLIENTID = "clientid";
    /**
     * 推送
     */

    int CUSTOMERTAGID = 9001;
    /**
     * 客户标签ID
     */
    int CUSTOMERINTENTID = 9002;
    /**
     * 客户意向ID
     */
    int CARDTYPEID = 9003;
    /**
     * 证件类型ID
     */
    int WARDROBETYPEID = 9004;
    /**
     * 衣柜类型ID
     */
    int MEMBERINTENTID = 9005;
    /**
     * 会员意向ID
     */
    int MANGERLISTID = 9006;
    /**
     * 会籍顾问ID
     */
    int POSTEACHERLISTID = 9007;
    /**
     * pos教练ID
     */
    int CONTACTTEACHERLISTID = 9008;
    /**
     * 跟进教练ID
     */
    int LESSONTEACHERLISTID = 9009;
    /**
     * 上课教练ID
     */
    int SALETEACHERLISTID = 9010;
    /**
     * 签约教练ID
     */
    int PUBLICSEATYPEID = 9011;
    /**
     * 公海类别ID
     */
    int CREATEUSERLISTID = 9012;
    /**
     * 采集人ID
     */
    int ALLMEMBERCARDTYPEID = 9013;
    /**
     * 搜索条件 卡类型ID     会员卡类型
     */
    int SALEMEMBERCARDTYPEID = 9014;
    /**
     * 采集信息 卡类型ID  会员卡类型
     */
    int CUSTOMERAPPOINTMENTTYPEID = 9015;
    /**
     * 客户预约类别ID
     */
    int MEMBERAPPOINTMENTTYPEBYID = 9016;
    /**
     * 根据会员id预约类别ID
     */
    int CUSTOMERSOURCEID = 9017;
    /**
     * 会员来源ID
     */
    int CUSTOMERINTRODUCERID = 9018;
    /**
     * 介绍人类别
     */
    int PERSONTYPEID = 9019;
    /**
     * 登录身份
     */
    int IDENTIFICATIONID = 9020;
    /**
     * 标识类别
     */
    int CLASSTYPEID = 9021;
    /**
     * 课程类型
     */
    int CLASSNAMEID = 9022;
    /**
     * 课程名称
     */
    int APPOINTMENTRESULTID = 9023;
    /**
     * 预约详情结果
     */
    int CUSTOMERTYPEID = 9024;
    /**
     * 客户类型
     */
    int MEMBERAPPOINTMENTTYPEID = 9025;
    /**
     * 会员预约类别ID
     */
    int PERSONLISTID = 9026;
    /**
     * 身份选择预约人员
     */
    int IDTYPEID = 9027;
    /**
     * 身份选择预约人员
     */
    int LESSONMEMBERLISTID = 9028;
    /**
     * 续课预约选择预约人员
     */
    int LESSONLISTBYMEMBERKEY = 9029;
    /**
     * 根据会员id预约类别ID
     */
    int LESSONTEACHERBYMEMBERKEY = 9030;
    /**
     * 根据会员id预约类别ID
     */
    int LESSONTBYMEMBERKEY = 9031;
    /**
     * 根据会员id获取私教课
     */
    int NOMEMBERID = 9032;
    /**
     * 非会员ID
     */


    String CUSTOMERTAGKEY = "customertag";
    /**
     * 客户标签(ID,Name)  ,
     */
    String CUSTOMERINTENTKEY = "customerintent";
    /**
     * 客户意向(ID,Name)  ,
     */
    String CARDTYPEKEY = "cardtype";
    /**
     * 证件类型(ID,Name)  ,
     */
    String WARDROBETYPEKEY = "wardrobetype";
    /**
     * 衣柜类型(ID,Name)  ,
     */
    String MEMBERINTENTKEY = "memberintent";
    /**
     * 会员意向(ID,Name)  ,
     */
    String MANGERLISTKEY = "mangerlist";
    /**
     * 会籍顾问(ID,Name)  ,
     */
    String POSTEACHERLISTKEY = "posteacherlist";
    /**
     * pos教练(ID,Name)  ,
     */
    String CONTACTTEACHERLISTKEY = "contactteacherlist";
    /**
     * 跟进教练(ID,Name)  ,
     */
    String LESSONTEACHERLISTKEY = "lessonteacherlist";
    /**
     * 上课教练(ID,Name)  ,
     */
    String SALETEACHERLISTKEY = "saleteacherlist";
    /**
     * 签约教练(ID,Name),
     */
    String PUBLICSEATYPEKEY = "publicseatype";
    /**
     * 公海类别(ID,Name),
     */
    String CREATEUSERLISTKEY = "createuserlist ";
    /**
     * 采集人
     */
    String ALLMEMBERCARDTYPEKEY = "allmembercardtype";
    /**
     * 搜索条件 卡类型
     */
    String SALEMEMBERCARDTYPEKEY = "salemembercardtype";
    /**
     * 采集信息 卡类型
     */
    String CUSTOMERAPPOINTMENTTYPEKEY = "customerappointmenttype";
    /**
     * 客户预约类别
     */
    String MEMBERAPPOINTMENTTYPEKEY = "memberappointmenttype";
    /**
     * 会员预约类别
     */
    String CUSTOMERSOURCEKEY = "customersourcekey";
    /**
     * 会员来源类别
     */
    String CUSTOMERINTRODUCERKEY = "customerintroducerkey";
    /**
     * 介绍人类别
     */
    String IDENTIFICATIONKEY = "identificationkey";
    /**
     * 介绍人类别
     */
    String APPOINTMENTRESULTKEY = "appointmentresultkey";
    /**
     * 预约结果类别
     */
    String TRAININGPLANKEY = "trainingplankey";/** 训练计划KEY*/
    /**
     * String MEMBERAPPOINTMENTTYPEKEY = "memberappointmenttypekey";/**  会员预约类别
     */
    String CUSTOMERTYPEKEY = "customertypekey";
    /**
     * 客户类型
     */


    int TIME_BEGIN_ID = 1301;
    /**
     * 开始时间
     */
    int TIME_END_ID = 1302;
    /**
     * 结束时间
     */
    int TIME_REMIND_ID = 1303;
    /**
     * 提醒时间
     */
    int TIME_INTERVAL_ID = 1304;
    /**
     * 提醒时间
     */

    int TYPE_CLERK = 0;
    /**
     * 职员ID
     */
    int TYPE_MANAGER = 1;
    /**
     * 经理ID
     */
    /*app的下载地址*/
    String appDownLoadUrl = "https://www.clfitsys.com/BigFitness-Member.apk";


    String[] CUSTOMER_ORDER_DATAS = {"最后跟进时间", "采集提交时间", "客户姓名排序"};
    String[] CHART_LIST_ORDER_DATAS = {"最后跟进时间", "办卡时间", "有效期(结束时间)", "会员姓名排序"};

    String[] MERBERS_ORDER_DATAS = {"会员姓名排序", "采集提交时间", "最后跟进时间"};
    String[] PRIVATE_ORDER_DATAS = {"会员姓名排序", "课程购买时间", "课程到期时间", "最后跟进时间"};
    String[] PUBLIC_SEA_ORDER_DATAS = {"抛入时间排序", "客户名称排序"};
    String[] DEPARTMENT_DATAS = {"我的", "部门"};
    String[] CERVIX_DATAS = {"操作时间", "生成时间"};
    String[] REPORT_DATAS = {"最后跟进时间", "课程购买时间", "课程到期时间", "办卡时间", "会员姓名排序"};
    String[] MYCARDTYPE = {"未开卡", "已开卡", "已冻结", "已到期", "作废", "冻结申请中", "未激活", "退款申请中", "已退款"};

    String[] PAYTYPE = {"微信", "支付宝"};
    String[] TYPEGTOUPLESSON = {"未开课", "已开课", "已结束", "已取消"};
    String[] TYPEAPPOINTMENT = {"未确认", "已确认-预约成功", "-手动取消", "未确认-自动取消", "未到场"};
    String[] TYPELESSONRECORD = {"未申请", "未补课（补课申请中）", "补课申请成功"};


    String[] CUSTOMER_ORDER_Interface_DATAS = {"LastContactTime", "CreateTime", "CustomerName"};
    String[] MERBERS_ORDER_Interface_DATAS = {"MemberName", "CreateTime", "LastContactTime"};
    String[] CHART_LIST_ORDER_DATAS_Interface_DATAS = {"MemberName", "CreateTime", "LastContactTime", "aa"};
    String[] PRIVATE_Interface_DATAS = {"MemberName", "CreateTime", "LastContactTime"};
    String[] PUBLIC_SEA_ORDER_Interface_DATAS = {"InPublicSeaTime", "CustomerName"};
    String[] PUBLIC_SEA_MEMBERS_ORDER_Interface_DATAS = {"AbandonTime", "MemberName"};
    String[] CERVIX_Interface_DATAS = {"ReportTime", "CreateTime"};
    String[] REPORT_Interface_DATAS = {"LastContactTime", "mls.CreateTime", "mls.StopTime", "mc.CreateTime", "MemberName"};


    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};


    //  String CUSTOMER_ORDER="最后跟进时间, 采集提交时间,客户姓名排序";
    //
    //
    //  String CUSTOMER_ORDER_Interface= "LastContactTime,CreateTime,CustomerName";

    //

}
