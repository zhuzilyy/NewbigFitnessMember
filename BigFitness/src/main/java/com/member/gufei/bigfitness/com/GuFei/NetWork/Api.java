package com.member.gufei.bigfitness.com.GuFei.NetWork;

import com.member.gufei.bigfitness.ResBean;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.AllCulbsList.UpdateVersion.UpdateBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.APPBuyLessonOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyAPPBuyCardOrderDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListNotActiveBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberCardListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListActivedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListNotActiveBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppGetMyMemberLessonListRefundedBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.AppUserResetPwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AddFeeMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.AppBuyMemberLessonPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NewAppBuyMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.NoticeListBean;
//import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.RenewMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.RenewMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.UpMemberCardPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassAppointmentBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassCountdownInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClassLessonRecordListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubFLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubGroupLessonEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubImagesBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubInfoByIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonEvaluateStarTotalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubLessonTeacherListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubListForMemberNoBuyBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubMemberCardTypeDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubOnlineSaleMemberCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubSaleNotOpenOrBuyGroupLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherEvaluateListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ClubTeacherListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.ConsumptionRecordBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.CreateLessonQRBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.DistanceClassTimeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.EventDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonAppointmentListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FreeLessonClassRecordBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.GetLessonEvaluateBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LandAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.LessonAddFeePriceBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberCardOnlineUpInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberIdBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberMyInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MemberSetUserInfoBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MembershipRenewalBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyGroupLessonDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppDetailBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyLessonAppListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyOthersAppointmentBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.MyTwoDimensionCodeBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.NotActiveMemberLessonListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy.PayForAliPayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.PwdCheckBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.QueryScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.RegisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.TeacherScheduleDayBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UpGradeCardListBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.UserregisterAppUserBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerificationAccountNameBean;
import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.VerifyCodeBean;

import java.sql.RowId;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.member.gufei.bigfitness.Constants.BASEURL;

/**
 * Created by GuFei_lyf on 2017/3/21
 * 外部接口类
 */

public interface Api {


    String baseUrl = BASEURL;


    /**
     * 登录
     *
     * @param AccountName 用户名
     * @param Pwd         密码
     * @param DeviceCode  设备码
     * @param DeviceType  设备类型
     * @return
     */
    @GET("appUser/landAppUser")
    rx.Observable<LandAppUserBean> landAppUser(
            @Query("AccountName") String AccountName,
            @Query("Pwd") String Pwd,
            @Query("DeviceCode") String DeviceCode,
            @Query("DeviceType") String DeviceType


    );


    /**
     * #原手机修改密码验证
     *
     * @param Mobile     电话
     * @param VerifyCode 验证码
     * @param token
     * @return
     */
    @GET("appUser/appUserResetPwdCheck")
    rx.Observable<AppUserResetPwdCheckBean> appUserResetPwdCheck(
            @Query("Mobile") String Mobile,
            @Query("VerifyCode") String VerifyCode,
            @Query("token") String token
    );

    /**
     * 操课预约详情
     *
     * @param ClubId
     * @param Token
     * @param APPUserId
     * @param FLessonId
     * @param StartTime
     * @param LessonDate
     * @return
     */
    @GET("/appMember/memberLesson/getClubFreeLessonInfo")
    rx.Observable<ResBean> getClubFreeLessonInfo(
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("APPUserId") String APPUserId,
            @Query("FLessonId") String FLessonId,
            @Query("StartTime") String StartTime,
            @Query("LessonDate") String LessonDate
    );

    /**
     * 修改密码
     *
     * @param AccountName 用户名
     * @param Pwd         密码
     * @param APPUserId   用户id
     * @param token
     * @return
     */
    @GET("appUser/appUserResetPwd")
    rx.Observable<CodeBean> appUserResetPwd(
            @Query("AccountName") String AccountName,
            @Query("Pwd") String Pwd,
            @Query("APPUserId") String APPUserId,
            @Query("token") String token

    );

    /**
     * 昵称重复校验
     *
     * @param NickName 昵称
     * @param token
     * @return
     */
    @GET("appUser/checkNickName")
    rx.Observable<MemberMyInfoBean> checkNickName(
            @Query("NickName") String NickName,
            @Query("token") String token

    );

    /**
     * 注册
     *
     * @param AccountName 用户名
     * @param Mobile      电话
     * @param Pwd         密码
     * @param VerifyCode  验证码
     * @param token
     * @return
     */
    @GET("appUser/registerAppUser")
    rx.Observable<RegisterAppUserBean> registerAppUser(
            @Query("AccountName") String AccountName,
            @Query("Mobile") String Mobile,
            @Query("Pwd") String Pwd,
            @Query("VerifyCode") String VerifyCode,
            @Query("token") String token

    );

    /**
     * 完善个人信息
     *
     * @param APPUserId      用户id
     * @param DeviceCode     设备码
     * @param Birthday       生日
     * @param NickName       昵称
     * @param Sex            性别
     * @param Height         身高
     * @param Weight         体重
     * @param FitnessRequest 健身需求
     * @param DeviceType     设备类型
     * @return
     */
    @GET("appUser/updateAppUserInfo")
    rx.Observable<MemberMyInfoBean> updateAppUserInfo(

            @Query("APPUserId") String APPUserId,
            @Query("DeviceCode") String DeviceCode,
            @Query("Sex") String Sex,
            @Query("NickName") String NickName,
            @Query("Birthday") String Birthday,
            @Query("Height") String Height,
            @Query("Weight") String Weight,
            @Query("FitnessRequest") String FitnessRequest,
            @Query("DeviceType") String DeviceType

    );
    /**
     * 修改个人信息
     *
     * @param APPUserId      用户id
     * @param HeaderURL      头像
     * @param Birthday       生日
     * @param NickName       昵称
     * @param Sex            性别
     * @param Height         身高
     * @param Weight         体重
     * @param FitnessRequest 健身需求
     * @param token
     * @return
     */
    @GET("appMember/setUserInfo")
    rx.Observable<MemberSetUserInfoBean> setAppUserInfo(

            @Query("APPUserId") String APPUserId,
            @Query("HeaderURL") String HeaderURL,
            @Query("Sex") String Sex,
            @Query("NickName") String NickName,
            @Query("Birthday") String Birthday,
            @Query("Height") String Height,
            @Query("Weight") String Weight,
            @Query("FitnessRequest") String FitnessRequest,
            @Query("token") String token

    );

    /**
     * 用户名重复校验
     *
     * @param AccountName 用户名
     * @param token
     * @return
     */
    @GET("appUser/checkTAppuserByAccountName")
    rx.Observable<VerificationAccountNameBean> checkTAppuserByAccountName(
            @Query("AccountName") String AccountName,
            @Query("token") String token

    );


    /**
     * 获取健身需求
     *
     * @param token
     * @return
     */
    @GET("appUser/getFitnessRequest")
    rx.Observable<FitnessRequestBean> getFitnessRequest(
            @Query("token") String token
    );

    /**
     * 获取通知消息
     *
     * @param APPUserId
     * @param token
     * @param PageIndex
     * @param PageSize
     * @param MsgTypeId
     * @return
     */
    @GET("appMember/pushMessage/getAPPUserMessage")
    rx.Observable<NoticeListBean> getNoticeList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("PageIndex") String PageIndex,
            @Query("PageSize") String PageSize,
            @Query("MsgTypeId") String MsgTypeId
    );

    /**
     * 阅读消息，标记为已读
     *
     * @param APPUserId
     * @param token
     * @param RowId
     * @param IsAPPPush
     * @return
     */
    @GET("appMember/pushMessage/ReadMessage")
    rx.Observable<CodeBean> getIsRead(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("RowId") String RowId,
            @Query("IsAPPPush") String IsAPPPush
    );

    /**
     * 删除通知
     *
     * @param APPUserId
     * @param token
     * @param RowId
     * @param IsAPPPush
     * @return
     */
    @GET("appMember/pushMessage/delMessage")
    rx.Observable<CodeBean> getDelete(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("RowId") String RowId,
            @Query("IsAPPPush") String IsAPPPush
    );

    /**
     *全部标记为已读
     *
     * @param APPUserId
     * @param token
     * @param MsgTypeId
     * @return
     */
    @GET("appMember/pushMessage/ReadAllMessage")
    rx.Observable<CodeBean> getAllRead(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("MsgTypeId") String MsgTypeId
    );

    /**
     *删除全部已读
     *
     * @param APPUserId
     * @param token
     * @param MsgTypeId
     * @return
     */
    @GET("appMember/pushMessage/delAllMessage")
    rx.Observable<CodeBean> getAllDelete(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("MsgTypeId") String MsgTypeId
    );

    /**
     * 所有会所列表(包含我的会所)
     *
     * @param APPUserId
     * @param token
     * @param currentPage
     * @param UserPosition
     * @return
     */
    @GET("appClub/getClubListForMember")
    rx.Observable<ClubListForMemberBean> getClubListForMember(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("currentPage") String currentPage,
            @Query("UserPosition") String UserPosition
    );


    /**
     * 会所详情
     *
     * @param ClubId
     * @param APPUserId
     * @param token
     * @return
     */

    @GET("appClub/clubInfoById")
    rx.Observable<ClubInfoByIdBean> clubInfoById(
            @Query("ClubId") String ClubId,
            @Query("APPUserId") String APPUserId,
            @Query("token") String token
    );

    /**
     * 轮播图详情
     *
     * @param Id
     * @param token
     * @return
     */

    @GET("appClub/getEventDetail")
    rx.Observable<EventDetailBean> getEventDetail(
            @Query("Id") String Id,
            @Query("token") String token
    );


    /**
     * 其他会所列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appClub/getClubListForMemberNoBuy")
    rx.Observable<ClubListForMemberNoBuyBean> getClubListForMemberNoBuy(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("lat") String lat,
            @Query("lng") String lng
    );


    /**
     * 获取会所评价列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param IsOnlyShowContent
     * @param Star
     * @param PageIndex
     * @return
     */
    @GET("appClub/getClubevaluateByClubId")
    rx.Observable<ClubLessonEvaluateStarTotalBean> getClubevaluateByClubId(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("IsOnlyShowContent") int IsOnlyShowContent,
            @Query("Star") int Star,
            @Query("PageIndex") int PageIndex


    );


    /**
     * 获取会所图片列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appClub/getClubImages")
    rx.Observable<ClubImagesBean> getClubImages(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token
    );

    /**
     * 获取会所教练列表
     *
     * @param ClubId
     * @param token
     * @param APPUserId
     * @return
     */
    @GET("appMember/clubTeacher/getClubLessonTeacherList")
    rx.Observable<ClubTeacherListBean> getClubTeacherList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("currentPage") int currentPage
    );

    /**
     * 获取会所私教课评价列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubSaleLessonList")
    rx.Observable<ClubSaleLessonListBean> getClubSaleLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("currentPage") int currentPage
    );

    /**
     * 获取私教课评价列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param IsOnlyShowContent
     * @param Star
     * @param PageIndex
     * @return
     */
    @GET("appMember/memberLesson/getClubLessonEvaluateList")
    rx.Observable<ClubLessonEvaluateStarTotalBean> getClubLessonEvaluateList(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("LessonId") String LessonId,
            @Query("IsOnlyShowContent") int IsOnlyShowContent,
            @Query("Star") int Star,
            @Query("PageIndex") int PageIndex


    );


    /**
     * 获取团体课评价列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param GroupLessonId
     * @param IsOnlyShowContent
     * @param Star
     * @param PageIndex
     * @return
     */
    @GET("appMember/memberLesson/getClubGroupLessonEvaluateList")
    rx.Observable<ClubGroupLessonEvaluateListBean> getClubGroupLessonEvaluateList(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("GroupLessonId") String GroupLessonId,
            @Query("IsOnlyShowContent") int IsOnlyShowContent,
            @Query("Star") int Star,
            @Query("PageIndex") int PageIndex
    );

    /**
     * 获取会所评价统计
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubLessonEvaluateStarTotal")
    rx.Observable<ClubLessonEvaluateStarTotalBean> getClubLessonEvaluateStarTotal(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId

    );

    /**
     * 获取会教练评价列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubTeacherEvaluateList")
    rx.Observable<ClubTeacherEvaluateListBean> getClubTeacherEvaluateList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("PageIndex") int PageIndex,
            @Query("TeacherId") String TeacherId,
            @Query("Star") int Star
    );

    /**
     * 获取会所私教课详情信息
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubLessonDetail")
    rx.Observable<ClubLessonDetailBean> getClubLessonDetail(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("LessonId") String LessonId
    );


    /**
     * 获取会所在售未开课或已购买的小团体课列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubSaleNotOpenOrBuyGroupLessonList")
    rx.Observable<ClubSaleNotOpenOrBuyGroupLessonListBean> getClubSaleNotOpenOrBuyGroupLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("currentPage") int currentPage
    );

    /**
     * 获取会所小团体课详情信息
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubGroupLessonDetail")
    rx.Observable<ClubGroupLessonDetailBean> getClubGroupLessonDetail(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("GroupLessonId") String GroupLessonId
    );


    /**
     * 获取会所私教课的教练列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubLessonTeacherList")
    rx.Observable<ClubLessonTeacherListBean> getClubLessonTeacherList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("LessonId") String LessonId,
            @Query("currentPage") int currentPage
    );


    /**
     * 获取会所教练详情信息
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/clubTeacher/getClubTeacherDetail")
    rx.Observable<ClubTeacherDetailBean> getClubTeacherDetail(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("TeacherId") String TeacherId
    );


    /**
     * 获取私教课教练详情信息
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubTeacherDetail")
    rx.Observable<ClubTeacherDetailBean> getClubLessonTeacherDetail(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("TeacherId") String TeacherId
    );


    /**
     * 我的会员卡列表-全部
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @return
     */
    @GET("appMember/memberCard/appGetMyMemberCardList")
    rx.Observable<AppGetMyMemberCardListBean> appGetMyMemberCardList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );

    /**
     * 获取会所线上销售的会员卡列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param currentPage
     * @return
     */
    @GET("appMember/memberCard/getClubOnlineSaleMemberCardList")
    rx.Observable<ClubOnlineSaleMemberCardListBean> getClubOnlineSaleMemberCardList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );

    /**
     * /**
     * 获取会所线上销售的会员卡详情
     *
     * @param APPUserId
     * @param token
     * @param ClubId
     * @param MemberCardTypeId
     * @return
     */
    @GET("appMember/memberCard/getClubMemberCardTypeDetail")
    rx.Observable<ClubMemberCardTypeDetailBean> getClubMemberCardTypeDetail(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("MemberCardTypeId") String MemberCardTypeId
    );
    /**
     * /**
     *
     *获取会员卡续费-APP支付订单信息
     * @param APPUserId
     * @param token
     * @param ClubId
     * @param MemberCardId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/memberCard/appAddFeeMemberCardPay")
    rx.Observable<RenewMemberCardPayBean> getRenewMemberCardPay(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("MemberCardId") String MemberCardId,
            @Query("Amount") String Amount,
            @Query("Price") String Price,
            @Query("TotalMoney") String TotalMoney,
            @Query("PayMode") String PayMode
    );

    /**
     * /**
     * 获取会员卡续费价格列表
     *
     * @param APPUserId
     * @param token
     * @param ClubId
     * @param MemberCardTypeId
     * @return
     */
    @GET("sysMemberCard/memberCard/getMemberCardAddFeePriceList")
    rx.Observable<MembershipRenewalBean> getMemberCardAddFeePriceList(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("MemberCardTypeId") String MemberCardTypeId
    );


    /**
     * 获取会所操课列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param LessonDate
     * @param StartTime
     * @param PageIndex
     * @return
     */
    @GET("appMember/memberLesson/getClubFLessonList")
    rx.Observable<ClubFLessonListBean> getClubFLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("LessonDate") String LessonDate,
            @Query("StartTime") String StartTime,
            @Query("PageIndex") int PageIndex
    );


    /**
     * 我的会员卡列表-已激活
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @return
     */
    @GET("appMember/memberCard/appGetMyMemberCardListActived")
    rx.Observable<AppGetMyMemberCardListActivedBean> appGetMyMemberCardListActived(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );

    /**
     * 我的会员卡列表-未激活
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @return
     */
    @GET("appMember/memberCard/appGetMyMemberCardListNotActive")
    rx.Observable<AppGetMyMemberCardListNotActiveBean> appGetMyMemberCardListNotActive(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );


    /**
     * 我的会员卡列表-已退款
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @return
     */
    @GET("appMember/memberCard/appGetMyMemberCardListRefunded")
    rx.Observable<AppGetMyMemberCardListRefundedBean> appGetMyMemberCardListRefunded(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );

    /**
     * 我的会员卡详情   未激活 - 退款申请中 -  已退款
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/appGetMyAPPBuyCardOrderDetail")
    rx.Observable<AppGetMyAPPBuyCardOrderDetailBean> appGetMyAPPBuyCardOrderDetail(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("OrderId") String OrderId,
            @Query("Status") String Status
    );

    /**
     * 我的私教课退款申请
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param OrderId
     * @return
     */
    @GET("appMember/memberLesson/appMyMemberLessonApplyRefund")
    rx.Observable<CodeBean> appMyMemberLessonApplyRefund(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("OrderId") String OrderId
    );


    /**
     * 我的会员卡详情   激活 -过期 -已冻结 -作废 -冻结申请
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/appGetMyMemberCardDetail")
    rx.Observable<AppGetMyMemberCardDetailBean> appGetMyMemberCardDetail(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("Status") String Status,
            @Query("MemberCardId") String MemberCardId,
            @Query("ConsumeType") String ConsumeType
    );

    /**
     * 冻结会员卡申请
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @return
     */
    @GET("sysMemberCard/appMemberCardLockApply")
    rx.Observable<CodeBean> appMemberCardLockApply(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("MemberCardId") String MemberCardId,
            @Query("StartDate") String StartDate,
            @Query("EndDate") String EndDate
    );

    /**
     * 获取会员卡升级-APP支付订单信息
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param MemberCardId
     * @param NewMemberCardTypeId
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/memberCard/appUpMemberCardPay")
    rx.Observable<UpMemberCardPayBean> getAppUpMemberCardPay(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("MemberCardId") String MemberCardId,
            @Query("NewMemberCardTypeId") String NewMemberCardTypeId,
            @Query("TotalMoney") String TotalMoney,
            @Query("PayMode") String PayMode
    );

    /**
     * 获取会员卡升级列表
     *
     * @param ClubId
     * @param MemberCardTypeId
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/getMemberCardOnlineUpPriceList")
    rx.Observable<UpGradeCardListBean> appMemberUpGradeCardList(
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("MemberCardTypeId") String MemberCardTypeId
    );

    /**
     * 我的会员卡升级信息
     *
     * @param MemberCardTypeId
     * @param NewMemberCardTypeId
     * @param ExpireTime
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/getMemberCardOnlineUpInfo")
    rx.Observable<MemberCardOnlineUpInfoBean> getMemberCardOnlineUpInfo(
            @Query("MemberCardTypeId") String MemberCardTypeId,
            @Query("NewMemberCardTypeId") String NewMemberCardTypeId,
            @Query("ExpireTime") String ExpireTime,
            @Query("Token") String Token
    );

    /**
     * 预约操课按钮
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param FLessonId
     * @param MemberId
     * @param LessonDate
     * @return
     */
    @GET("appMember/memberLesson/AddMemberFreeLessonAppointment")
    rx.Observable<ClassAppointmentBean> classAppointment(
            @Query("APPUserId") String APPUserId,
            @Query("Token") String Token,
            @Query("ClubId") String ClubId,
            @Query("FLessonId") String FLessonId,
            @Query("MemberId") String MemberId,
            @Query("LessonDate") String LessonDate
    );


    /**
     * 我的会员卡 申请退款
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/appMyMemberCardApplyRefund")
    rx.Observable<CodeBean> appMyMemberCardApplyRefund(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("OrderId") String OrderId
    );

    /**
     * 我的会员卡 删除
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @return
     */
    @GET("appMember/memberCard/delMemberCardByOrderId")
    rx.Observable<CodeBean> delMemberCardByOrderId(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("OrderId") String OrderId
    );


    /**
     * #获取会所在售未开课或已购买的小团体课列表
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getClubSaleNotOpenOrBuyGroupLessonList")
    rx.Observable<FitnessRequestBean> getClubSaleNotOpenOrBuyGroupLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token

    );


    /**
     * 我的私教课列表-全部
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/appGetMyMemberLessonList")
    rx.Observable<AppGetMyMemberLessonListBean> appGetMyMemberLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token

    );

    /**
     * #获取我的私教课列表——未激活
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @param PageIndex 页码
     * @return
     */
    @GET("appMember/memberLesson/appGetMyMemberLessonListNotActive")
    rx.Observable<AppGetMyMemberLessonListNotActiveBean> appGetMyMemberLessonListNotActive(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * #获取我的私教课列表——已激活
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @param PageIndex 页码
     * @return
     */
    @GET("appMember/memberLesson/appGetMyMemberLessonListActived")
    rx.Observable<AppGetMyMemberLessonListActivedBean> appGetMyMemberLessonListActived(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * #获取我的私教课列表——已退款
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @param PageIndex 页码
     * @return
     */
    @GET("appMember/memberLesson/appGetMyMemberLessonListRefunded")
    rx.Observable<AppGetMyMemberLessonListRefundedBean> appGetMyMemberLessonListRefunded(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * #获取我的私教课列表——未认证
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @param PageIndex 页码
     * @return
     */
    @GET("appMember/memberLesson/getNotActiveMemberLessonList")
    rx.Observable<NotActiveMemberLessonListBean> getNotActiveMemberLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * #私教课详细信息——已激活
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param Id        私教课ID
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/appGetMyMemberLessonDetail")
    rx.Observable<AppGetMyMemberLessonDetailBean> appGetMyMemberLessonDetail(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Id") String Id,
            @Query("Status") String Status,
            @Query("token") String token
    );

    /**
     * 我的私教课购买订单详情
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param OrderId   订单编号
     * @param Status
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/appGetMyAPPBuyLessonOrderDetail")
    rx.Observable<APPBuyLessonOrderDetailBean> getMyAPPBuyLessonOrderDetailNo(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("OrderId") String OrderId,
            @Query("Status") String Status,
            @Query("token") String token
    );


    /**
     * 消费记录
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @return
     */
    @GET("appMember/Record/getConsumptionRecord")
    rx.Observable<ConsumptionRecordBean> getConsumptionRecord(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * 上课记录--操课
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param PageIndex
     * @param MemberId
     * @return
     */
    @GET("appMember/Record/getFreeLessonClassRecord")
    rx.Observable<FreeLessonClassRecordBean> getFreeLessonClassRecord(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex,
            @Query("MemberId") String MemberId
    );

    /**
     * 我的小团体课列表
     *
     * @param ClubId
     * @param MemberId
     * @param token
     * @param PageIndex
     * @return
     */
    @GET("appMember/memberLesson/getMyGroupLesson")
    rx.Observable<MyGroupLessonBean> getMyGroupLesson(
            @Query("ClubId") String ClubId,
            @Query("MemberId") String MemberId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex
    );

    /**
     * 我的小团体课详情
     *
     * @param ClubId
     * @param MemberId
     * @param Id
     * @param token
     * @return
     */
    @GET("appMember/memberLesson/getMyGroupLessonDetail")
    rx.Observable<MyGroupLessonDetailBean> getMyGroupLessonDetail(
            @Query("ClubId") String ClubId,
            @Query("MemberId") String MemberId,
            @Query("Id") int Id,
            @Query("token") String token
    );


    /**
     * 4.2.11.18.6.1.	上课私教课列表
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param PageIndex
     * @param MemberId
     * @return
     */
    @GET("appMember/Record/getClassLessonList")
    rx.Observable<ClassLessonListBean> getClassLessonList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex,
            @Query("MemberId") int MemberId
    );


    /**
     *私教课上课记录
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param PageIndex
     * @param MemberId
     * @param ComeLogId
     * @return
     */
    @GET("appMember/Record/getLessonClassRecord")
    rx.Observable<ClassLessonRecordListBean>getLessonClassRecord(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("PageIndex") int PageIndex,
            @Query("MemberId") int MemberId,
            @Query("LessonId") String LessonId,
            @Query("ComeLogId") String ComeLogId
    );

    /**
     *私教课评价
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param MemberId
     * @param ComeLogId
     * @param AppointmentId
     * @param EvaluateStar
     * @param EvaluateContent
     * @param TeacherEvaluateStar
     * @param ServiceEvaluateStar
     * @param TeacherEvaluateContent
     * @param ImageURL
     * @param TeacherImageURL
     * @param IsAnonymous
     * @return
     */
    @GET("appMember/memberAppointment/LessonEvaluate")
    rx.Observable<CodeBean>getLessonEvaluate(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("MemberId") String MemberId,
            @Query("ComeLogId") String ComeLogId,
            @Query("AppointmentId") String AppointmentId,
            @Query("EvaluateStar") String EvaluateStar,
            @Query("EvaluateContent") String EvaluateContent,
            @Query("TeacherEvaluateStar") String TeacherEvaluateStar,
            @Query("ServiceEvaluateStar") String ServiceEvaluateStar,
            @Query("TeacherEvaluateContent") String TeacherEvaluateContent,
            @Query("ImageURL") String ImageURL,
            @Query("TeacherImageURL") String TeacherImageURL,
            @Query("IsAnonymous") String IsAnonymous
    );

    /**
     *获取私教课评价内容
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param MemberId
     * @param AppointmentId
     * @param ComeLogId
     * @return
     */
    @GET("appMember/Record/getLessonEvaluate")
    rx.Observable<GetLessonEvaluateBean>getEvaluate(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("MemberId") String MemberId,
            @Query("AppointmentId") String AppointmentId,
            @Query("ComeLogId") String ComeLogId
    );

    /**
     *补课申请
     *
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param LessonId
     * @param AppointmentId
     * @param Cause
     * @return
     */
    @GET("appMember/Record/AddLessonMakeUpApply")
    rx.Observable<CodeBean>getAddLessonMakeUpApply(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token,
            @Query("LessonId") String LessonId,
            @Query("AppointmentId") String AppointmentId,
            @Query("Cause") String Cause
    );


    /**
     * 会所评价
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param EvaluateStar
     * @param EvaluateContent
     * @param ImageURL
     * @param IsAnonymous
     * @return
     */
    @POST("appClub/ClubEvaluate")
    @FormUrlEncoded
    rx.Observable<CodeBean> ClubEvaluate(
            @Field("APPUserId") String APPUserId,
            @Field("ClubId") String ClubId,
            @Field("Token") String Token,
            @Field("EvaluateStar") String EvaluateStar,
            @Field("EvaluateContent") String EvaluateContent,
            @Field("ImageURL") String ImageURL,
            @Field("IsAnonymous") String IsAnonymous
    );

    /**
     * 操课评价
     *
     * @param MemberId
     * @param ClubId
     * @param Token
     * @param FreeLessonId
     * @param EvaluateStar
     * @param EvaluateContent
     * @param ImageURL

     * @param IsAnonymous
     * @return
     */
    @POST("appMember/memberLesson/FreeLessonEvaluate")
    @FormUrlEncoded
    rx.Observable<CodeBean> FreeLessonEvaluate(
            @Field("MemberId") String MemberId,
            @Field("ClubId") String ClubId,
            @Field("Token") String Token,
            @Field("FreeLessonId") String FreeLessonId,
            @Field("EvaluateStar") String EvaluateStar,
            @Field("EvaluateContent") String EvaluateContent,
            @Field("ImageURL") String ImageURL,
            @Field("IsAnonymous") String IsAnonymous
    );
    /**
     *  小团体课评价
     *
     * @param MemberId
     * @param ClubId
     * @param Token
     * @param FreeLessonId
     * @param EvaluateStar
     * @param EvaluateContent
     * @param ImageURL

     * @param IsAnonymous
     * @return
     */
    @POST("appMember/memberLesson/GroupLessonEvaluate")
    @FormUrlEncoded
    rx.Observable<CodeBean> GroupLessonEvaluate(
            @Field("MemberId") String MemberId,
            @Field("ClubId") String ClubId,
            @Field("Token") String Token,
            @Field("GroupLessonId") String FreeLessonId,
            @Field("EvaluateStar") String EvaluateStar,
            @Field("EvaluateContent") String EvaluateContent,
            @Field("ImageURL") String ImageURL,
            @Field("IsAnonymous") String IsAnonymous
    );


    /**
     * 4.2.11.8.5.1.	会员卡冻结催办
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberCardId
     * @return
     */
    @GET("sysMemberCard/appMemberCardLockSendMsg")
    rx.Observable<CodeBean> appMemberCardLockSendMsg(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("MemberCardId") String MemberCardId
    );

    /**
     * 日程查询，按日期段查询预约数据接口 (包含上课预约记录)
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param AppointmentStartDate
     * @param AppointmentEndDate
     * @return
     */
    @GET("appMember/schedule/QueryScheduleDay")
    rx.Observable<QueryScheduleDayBean> QueryScheduleDay(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("AppointmentStartDate") String AppointmentStartDate,
            @Query("AppointmentEndDate") String AppointmentEndDate,
            @Query("isNow") String isNow

    );


    /**
     * 首页悬浮按钮
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param AppointmentStartDate
     * @param AppointmentEndDate
     * @param quanquan
     * @return
     */
    @GET("appMember/schedule/QueryScheduleDay")
    rx.Observable<QueryScheduleDayBean> getQuanQuan(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("AppointmentStartDate") String AppointmentStartDate,
            @Query("AppointmentEndDate") String AppointmentEndDate,
            @Query("quanquan") String quanquan
    );

    /**
     * 二维码生成
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberLesson/CreateLessonQR")
    rx.Observable<CreateLessonQRBean> CreateLessonQR(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("AppointmentId") String AppointmentId
    );

    /**
     * 获取手机验证码
     *
     * @param Mobile
     * @return
     */
    @GET("appUser/getVerifyCode")
    rx.Observable<VerifyCodeBean> getVerifyCode(
            @Query("Mobile") String Mobile
    );

    /**
     * 新用户注册
     *
     * @param AccountName
     * @param Mobile
     * @param Pwd
     * @param VerifyCode
     * @return
     */
    @GET("appUser/registerAppUser")
    rx.Observable<RegisterAppUserBean> registerAppUser(
            @Query("AccountName") String AccountName,
            @Query("Mobile") String Mobile,
            @Query("Pwd") String Pwd,
            @Query("VerifyCode") String VerifyCode
    );


    /**
     * @return
     */
    @GET("appUserregisterAppUser")
    rx.Observable<UserregisterAppUserBean> appUserregisterAppUser(
    );

    /**
     * 验证密码
     *
     * @param APPUserId
     * @param Pwd
     * @param token
     * @return
     */
    @GET("appMember/PwdCheck")
    rx.Observable<PwdCheckBean> PwdCheck(
            @Query("APPUserId") String APPUserId,
            @Query("Pwd") String Pwd,
            @Query("token") String token
    );

    /**
     * 我的二维码
     *
     * @param APPUserId
     * @param token
     * @return
     */
    @GET("appUser/getMyTwoDimensionCode")
    rx.Observable<MyTwoDimensionCodeBean> getMyTwoDimensionCode(
            @Query("APPUserId") String APPUserId,
            @Query("token") String token
    );


    /**
     * 4.2.11.3.4.3.	修改手机号码
     *
     * @param APPUserId
     * @param Mobile
     * @param VerifyCode
     * @return
     */
    @GET("appMember/updateAPPUserMobile")
    rx.Observable<CodeBean> updateAPPUserMobile(
            @Query("APPUserId") String APPUserId,
            @Query("Mobile") String Mobile,
            @Query("VerifyCode") String VerifyCode
    );

    /**
     * 获取我的私教课预约列表
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @return
     */
    @GET("appMember/memberAppointment/getMyLessonAppList")
    rx.Observable<MyLessonAppListBean> getMyLessonAppList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("currentPage") int currentPage
    );

    /**
     * 获取我的其他预约列表
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param PageIndex
     * @param PageSize
     * @return
     */
    @GET("appMember/getMemberAppointmentList")
    rx.Observable<MyOthersAppointmentBean> getMyOthersAppointmentList(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("Token") String Token,
            @Query("PageIndex") int PageIndex,
            @Query("PageSize") int PageSize
    );




    /**
     * 私教课预约详情
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberAppointment/getMyLessonAppDetail")
    rx.Observable<MyLessonAppDetailBean>getMyLessonAppDetail(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId
    );

    /**
     * 请求距离上课时间
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param LessonId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberLesson/AttendClassTime")
    rx.Observable<DistanceClassTimeBean>getAttendClassTime(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("LessonId") String LessonId  ,
            @Query("AppointmentId") String AppointmentId
    );

    /**
     * 上课正计时
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberLesson/getClassCountdownInfo")
    rx.Observable<ClassCountdownInfoBean>getClassCountdownInfo(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("AppointmentId") String AppointmentId
    );


    /**
     * 确认私教预约
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberAppointment/confirmLessonAppointment")
    rx.Observable<CodeBean>confirmLessonAppointment(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId
    );

    /**
     *
     * 取消私教预约
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @param AppointmentStatus
     * @return
     */
    @GET("appMember/memberAppointment/cancelMemberLessonAppointment")
    rx.Observable<CodeBean>cancelMemberLessonAppointment(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId  ,
            @Query("AppointmentStatus") String AppointmentStatus
    );

    /**
     *
     * 确认其他预约
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberAppointmentConfirm")
    rx.Observable<CodeBean>getMyOthersAppointmentSubmit(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId
    );

    /**
     *
     * 取消其他预约
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @return
     */
    @GET("appMember/memberAppointmentCancel")
    rx.Observable<CodeBean>getMyOthersAppointmentCancel(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId
    );




    /**
     *
     * 操课预约列表
     *
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param currentPage
     * @param MemberId
     * @return
     */
    @GET("appMember/memberLesson/FreeLessonAppointmentList")
    rx.Observable<FreeLessonAppointmentListBean>FreeLessonAppointmentList(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("currentPage") int currentPage  ,
            @Query("MemberId") String MemberId
    );

    /**
     * 取消操课预约
     * @param APPUserId
     * @param ClubId
     * @param Token
     * @param MemberId
     * @param AppointmentId
     * @param Cause
     * @return
     */
    @GET("appMember/memberLesson/cancelMemberFreeLessonAppointment")
    rx.Observable<CodeBean>cancelMemberFreeLessonAppointment(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Token") String Token  ,
            @Query("MemberId") String MemberId  ,
            @Query("AppointmentId") String AppointmentId  ,
            @Query("Cause") String Cause
    );


    /**
     * 教练日程列表-日
     * @param APPUserId
     * @param ClubId
     * @param token
     * @param AppointmentTeacherId
     * @return
     */
    @GET("appMember/memberAppointment/getTeacherScheduleDay")
    rx.Observable<TeacherScheduleDayBean>getTeacherScheduleDay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("token") String token  ,
            @Query("AppointmentStartDate") String AppointmentStartDate  ,
            @Query("AppointmentEndDate") String AppointmentEndDate  ,
            @Query("AppointmentTeacherId") String AppointmentTeacherId
    );

    /**
     *
     * 添加私教课预约
     * @param APPUserId
     * @param ClubId
     * @param MemberId
     * @param LessonId
     * @param AppointmentTeacherId
     * @param Content
     * @param token
     * @param StartTime
     * @param EndTime
     * @param TipStartTime
     * @param TipInterval
     * @param AppointmentCata
     * @param AppointmentOwner
     * @param AppointmentStatus
     * @return
     */
    @GET("appMember/memberAppointment/AddMemberLessonAppointment")
    rx.Observable<CodeBean>AddMemberLessonAppointment(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberId") String MemberId  ,
            @Query("LessonId") String LessonId  ,
            @Query("AppointmentTeacherId") String AppointmentTeacherId  ,
            @Query("Content") String Content  ,
            @Query("token") String token  ,
            @Query("StartTime") String StartTime  ,
            @Query("EndTime") String EndTime  ,
            @Query("TipStartTime") String TipStartTime  ,
            @Query("TipInterval") String TipInterval  ,
            @Query("AppointmentCata") String AppointmentCata  ,
            @Query("AppointmentOwner") String AppointmentOwner  ,
            @Query("AppointmentStatus") String AppointmentStatus
    );


    /**
     *私教课购买
     *
     * @param APPUserId
     * @param ClubId
     * @param LessonId
     * @param TeacherId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appBuyLessonPay")
    rx.Observable<AppBuyLessonPayBean>appBuyLessonPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("LessonId") String LessonId  ,
            @Query("TeacherId") String TeacherId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );


    /**
     *小团体购买订单
     *
     * @param APPUserId
     * @param ClubId
     * @param Id
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appAddFeeMemberLessonPay")
    rx.Observable<AppBuyLessonPayBean>appAddFeeMemberLessonPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Id") String Id  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );


    /**
     * 购买操课订单
     *
     * @param APPUserId
     * @param ClubId
     * @param GroupLessonId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appBuyGroupLessonPay")
    rx.Observable<AppBuyLessonPayBean>appBuyGroupLessonPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("GroupLessonId") String GroupLessonId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     *
     * 购买会员卡
     *
     * @param APPUserId
     * @param ClubId
     * @param MemberCardTypeId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/appBuyMemberCardPay")
    rx.Observable<AppBuyLessonPayBean>appBuyMemberCardPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberCardTypeId") String MemberCardTypeId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );
    /**
     *
     * 获取私教课购买-APP支付订单信息
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param LessonId
     * @param TeacherId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("/appMember/memberLesson/appBuyLessonPay")
    rx.Observable<AppBuyMemberLessonPayBean>appBuyMemberLessonPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("LessonId") String LessonId  ,
            @Query("TeacherId") String TeacherId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") Double Price  ,
            @Query("TotalMoney") Double TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     *
     * 获取私教课续费价格列表
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param LessonId
     * @return
     */
    @GET("appMember/memberLesson/getMemberLessonAddFeePriceList")
    rx.Observable<LessonAddFeePriceBean>getMemberLessonAddFeePriceList(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("LessonId") String LessonId
    );

    /**
     *
     * 获取私教课续费-APP支付订单信息
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param Id
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appAddFeeMemberLessonPay")
    rx.Observable<AddFeeMemberLessonPayBean>getAddFeeMemberLessonPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("Id") String Id,
            @Query("Amount") String Amount,
            @Query("Price") String Price,
            @Query("TotalMoney") String TotalMoney,
            @Query("PayMode") String PayMode
    );

    /**
     * 升级会员卡订单
     *
     *
     * @param APPUserId
     * @param ClubId
     * @param MemberCardId
     * @param NewMemberCardTypeId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/memberCard/appUpMemberCardPay")
    rx.Observable<AppBuyLessonPayBean>appUpMemberCardPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberCardId") String MemberCardId  ,
            @Query("NewMemberCardTypeId") String NewMemberCardTypeId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );


// TODO: 2018/6/22  支付宝部分
    /**
     *私教课购买
     *
     * @param APPUserId
     * @param ClubId
     * @param LessonId
     * @param TeacherId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appBuyLessonPay")
    rx.Observable<PayForAliPayBean>appBuyLessonPayForAliPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("LessonId") String LessonId  ,
            @Query("TeacherId") String TeacherId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );


    /**
     *小团体购买订单
     *
     * @param APPUserId
     * @param ClubId
     * @param Id
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appAddFeeMemberLessonPay")
    rx.Observable<PayForAliPayBean>appAddFeeMemberLessonPayForAliPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("Id") String Id  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );


    /**
     * 购买操课订单
     *
     * @param APPUserId
     * @param ClubId
     * @param GroupLessonId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("appMember/memberLesson/appBuyGroupLessonPay")
    rx.Observable<PayForAliPayBean>appBuyGroupLessonPayForAliPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("GroupLessonId") String GroupLessonId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     *
     * 购买会员卡
     *
     * @param APPUserId
     * @param ClubId
     * @param MemberCardTypeId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/appBuyMemberCardPay")
    rx.Observable<PayForAliPayBean>appBuyMemberCardPayForAliPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberCardTypeId") String MemberCardTypeId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     *
     * 新购买会员卡
     * 2018/09/03 - LiuShengYuan
     *
     * @param APPUserId
     * @param Token
     * @param ClubId
     * @param MemberCardTypeId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
        @GET("sysMemberCard/appBuyMemberCardPay")
    rx.Observable<NewAppBuyMemberCardPayBean>newAppBuyMemberCardPayBean(
            @Query("APPUserId") String APPUserId  ,
            @Query("Token") String Token  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberCardTypeId") String MemberCardTypeId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     * 升级会员卡订单
     *
     *
     * @param APPUserId
     * @param ClubId
     * @param MemberCardId
     * @param NewMemberCardTypeId
     * @param Amount
     * @param Price
     * @param TotalMoney
     * @param PayMode
     * @return
     */
    @GET("sysMemberCard/memberCard/appUpMemberCardPay")
    rx.Observable<PayForAliPayBean>appUpMemberCardPayForAliPay(
            @Query("APPUserId") String APPUserId  ,
            @Query("ClubId") String ClubId  ,
            @Query("MemberCardId") String MemberCardId  ,
            @Query("NewMemberCardTypeId") String NewMemberCardTypeId  ,
            @Query("Amount") String Amount  ,
            @Query("Price") String Price  ,
            @Query("TotalMoney") String TotalMoney  ,
            @Query("PayMode") String PayMode
    );

    /**
     * 判断该APP用户是否可以进行预约
     *
     * @param APPUserId 用户id
     * @param ClubId    会所id
     * @param token
     * @return
     */
    @GET("appClub/getMemberId")
    rx.Observable<MemberIdBean> getMemberIdIsLock(
            @Query("APPUserId") String APPUserId,
            @Query("ClubId") String ClubId,
            @Query("token") String token
    );

    /*新版本更新
     * @return
     */
    @GET("appClub/getMemberId")
    rx.Observable<UpdateBean> updateVersion(

    );

}