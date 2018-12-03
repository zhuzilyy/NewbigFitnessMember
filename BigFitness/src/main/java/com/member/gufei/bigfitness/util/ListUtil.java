package com.member.gufei.bigfitness.util;

import com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.FitnessRequestBean;
import com.member.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.replaceAll;

/**
 * Created by GuFei_lyf on 2017/5/2
 * 为会所,人员选择列表筛选过滤类
 *
 * 在转换为Bean的同时 过滤掉不显示人员
 */

public class ListUtil {

    public static boolean useSet(Integer[] arr, Integer targetValue) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
        return set.contains(targetValue);
    }



    /**
     * list转换  Array to list
     ** @param arr array;
     * @return list
     */
    public static ArrayList Arr2List(String[] arr) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            list.add(arr[i]);


        }
        return list;
    }



    /**
     * 筛选Bean转换  str to list  (带过滤)
     ** @param Str 预加载的数据字符串;
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> String2Bean(String Str) {


        List<FilterBean.FilterListBean> temp = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
        List<FilterBean.FilterListBean> list =  new ArrayList<FilterBean.FilterListBean>();


        if (!(temp.get(0).getIsShow()==null)) {
            //预处理 不显示人员
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getIsShow().toString().equals("T")){
                    list.add(temp.get(i));
                }
            }
        }else{

            list.addAll(temp);

        }
        return list;
    }
    /**
     * 筛选Bean转换  str to list  (全部显示)
     ** @param Str 预加载的数据字符串;
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> AllString2Bean(String Str) {


        List<FilterBean.FilterListBean> list = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
/*        for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).getIsShow().equals("T"))
                    list.remove(i);
            }*/
            return list;
    }
  /**
     * 健身需求转换  str to list  (全部显示)
     ** @param Str 预加载的数据字符串;
     * @return list  List<bean>
     */
    public static List<FitnessRequestBean.RowsBean> Fitness2Bean(String Str) {
        List<FitnessRequestBean.RowsBean> list = (List<FitnessRequestBean.RowsBean>) new Gson().fromJson(Str, new TypeToken<List<FitnessRequestBean.RowsBean>>() {
        }.getType());
        return list;
    }


    /**
     * json转换  obj to json  (带过滤)
     ** @param obj 预加载的数据字符串;
     * @return list  List<bean>
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();

        String json=gson.toJson(obj);
        return json;
    }


    /**
     * 本人需求列表转换  str to list
     ** @param s 预加载的数据字符串;
     * @return list  List<bean>
     */
    public static List toList(String s) {

        String mSub = s.substring(1,s.length()-1);
        mSub=mSub.replaceAll("\\\"","");
        String mArray[] = mSub.split(",");
        List<String> mList =new ArrayList<String>();

        for (String str : mArray)
        {
            mList.add(str);
        }
        return mList;
    }




    /**
     * id集合 拼接为,连接字符串方法
     ** @param obj  list  ID集合;
     * @return String  1,2,3,4;
     */





    public static String toidstring(List<String> obj) {

        String returnStr = "";

        List<String> tmp = new ArrayList<String>();

        for (int i = 0; i < obj.size(); i++) {
            String s = "";
            if (!obj.get(i).toString().equals("0")) {
                tmp.add(obj.get(i));
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            String s = ",";
            if (i == tmp.size() - 1) {
                s = "";
            }
            returnStr += tmp.get(i) + s;


        }


        return returnStr.replaceAll("\\\"", "");

    }

}
