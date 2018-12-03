
function toast(msg){
    Android.showToast(msg);
}

function onPageLoad(){
    toast('页面加载中...');
}


function loadALineChart(){
    // 必须加JOSN.parse 转换数据类型
    var option = JSON.parse(Android.getLineChartOptions());
    var chart2Doc = document.getElementById('chart2');
    var myChart2 = require('echarts').init(chart2Doc);

    myChart2.setOption(option);
//    myChart3.setOption(option);
//    myChart4.setOption(option);
//    myChart5.setOption(option);
//    document.getElementById('textcontent').innerHTML=option;
  document.getElementById('textcontent').innerHTML=JSON.stringify(option);
}

/**
type :  1 - 饼状图
        2 - 柱状图
*/
function loadAChart(type){
    var s=  Android.Persontype();
         if(s=="教练"){
//              document.getElementById('Sourcediv').style.display="none";
         }else if(s=="会籍"){
               document.getElementById('SalesvolumeDiv').style.display="none";
         }
     var option2 = JSON.parse(Android.getPieChartOptions(1001));
          option2=   getColorData(1001,option2);
          var chart2Doc = document.getElementById('chart2');
          var myChart2 = require('echarts').init(chart2Doc);
          myChart2.setOption(option2);
          document.getElementById('Sales').innerHTML=Android.getdata();


    if(s=="教练"){
       var option3 = JSON.parse(Android.getPieChartOptions(1002));
                  option3=getColorData(1002,option3);
                  var chart3Doc = document.getElementById('chart3');
                  var myChart3 = require('echarts').init(chart3Doc);
                  myChart3.setOption(option3);
           document.getElementById('Salesvolume').innerHTML=Android.getdata1();
         }


 // 必须用JSON.parse() 转换一下，才可以显示，否则数据类型会不对
     var option4 = JSON.parse(Android.getPieChartOptions(1003));
          option4=   getColorData(1003,option4);
          var chart4Doc = document.getElementById('chart4');
          var myChart4 = require('echarts').init(chart4Doc);
          myChart4.setOption(option4);
          document.getElementById('UsersVolume').innerHTML=Android.getdata2();
//
    var option5= JSON.parse(Android.getPieChartOptions(1004));
        option5=  getColorData(1004,option5);
        var chart5Doc = document.getElementById('chart5');
        var myChart5 = require('echarts').init(chart5Doc);
        myChart5.setOption(option5);
      document.getElementById('AddUsersVolume').innerHTML=Android.getdata3();



//    document.getElementById('textcontent').innerHTML=option2;
}

function loadAChart2(type){
     var s=  Android.Persontype();
         if(s=="教练"){
              document.getElementById('Sourcediv').style.display="none";
           }else if(s=="会籍"){
               document.getElementById('SalesvolumeDiv').style.display="none";
         }
     var option2 = JSON.parse(Android.getPieChartOptions(1001));
        option2=getColorData(1001,option2);
        var chart2Doc = document.getElementById('chart2');
        var myChart2 = require('echarts').init(chart2Doc);
          myChart2.setOption(option2);
       document.getElementById('Sales').innerHTML=Android.get2data();

       var option3 = JSON.parse(Android.getPieChartOptions(1002));
        option3=getColorData(1002,option3);

        var chart3Doc = document.getElementById('chart3');
        var myChart3 = require('echarts').init(chart3Doc);
        myChart3.setOption(option3);
        document.getElementById('Salesvolume').innerHTML=Android.get2data1();

 // 必须用JSON.parse() 转换一下，才可以显示，否则数据类型会不对
     var option4 = JSON.parse(Android.getLineChartOptions(0));
//          option4=   getColorData(1003,option4);
          var chart4Doc = document.getElementById('chart4');
          var myChart4 = require('echarts').init(chart4Doc);
          myChart4.setOption(option4);
                      document.getElementById('UsersVolume').innerHTML=Android.get2data2();

    var option5= JSON.parse(Android.getLineChartOptions(1));
//        option5=  getColorData(1004,option5);
        var chart5Doc = document.getElementById('chart5');
        var myChart5 = require('echarts').init(chart5Doc);
        myChart5.setOption(option5);
          document.getElementById('AddUsersVolume').innerHTML=Android.get2data3();

    var option6 = JSON.parse(Android.getPieChartOptions(1005));
        option6=getColorData(1005,option6);
        var chart6Doc = document.getElementById('chart6');


        h =option6.series[0].data.length * 30;
        chart6Doc.style.height=h +"px";

        var myChart6 = require('echarts').init(chart6Doc);
         myChart6.setOption(option6);
         document.getElementById('Source').innerHTML=Android.get2data5();


}
function loadAChartString(){

var option = JSON.parse(Android.getPieChartOptions(2));
          option=   getColorData(2,option);

return  option;
}

function getColorData(type,option){


    if(type==3 ||type==1003 ||type==1004  || type==1005  ){
      var    color=function(params)
             {
                  var colorList = ['#FF412B','#FF6801','#CCA902','#65AF34','#85DCF7', '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD', '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'] ;
                  return  colorList[params.dataIndex];

                  };
               option.series[0].itemStyle.normal.color=color;
    }

    return option;
}

function refreshChartUseStaticData(){
    var option = makeStaticOptions();
    if( typeof option === 'JSON'){//  typeof https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/typeof
        toast('数据为Json 类型');
    }else{
        toast('数据不是Json 类型');
    }
    // 从Android 代码中获取Json格式字符串
    var chart2Doc = document.getElementById('chart2');
    var myChart2 = require('echarts').init(chart2Doc);

    myChart2.setOption(option);
    document.getElementById('textcontent').innerHTML=option;


}


function makeStaticOptions(){

    var option = {
    "calculable": true,
    "toolbox": {
        "show": true,
        "feature": {
            "restore": {
                "show": true,
                "title": "还原"
            },
            "magicType": {
                "show": true,
                "title": {
                    "line": "折线图切换",
                    "stack": "堆积",
                    "bar": "柱形图切换",
                    "tiled": "平铺"
                },
                "type": ["line", "bar"]
            },
            "dataView": {
                "show": true,
                "title": "数据视图",
                "readOnly": false,
                "lang": ["Data View", "close", "refresh"]
            },
            "mark": {
                "show": true,
                "title": {
                    "mark": "辅助线开关",
                    "markClear": "清空辅助线",
                    "markUndo": "删除辅助线"
                },
                "lineStyle": {
                    "color": "#1e90ff",
                    "type": "dashed",
                    "width": 2
                }
            },
                "saveAsImage": {
                    "show": true,
                    "title": "保存为图片",
                    "type": "png",
                    "lang": ["点击保存"]
                }
            }
        },
        "tooltip": {
            "trigger": "axis",
            "formatter": "Temperature : \u003cbr/\u003e{b}km : {c}°C"
        },
        "legend": {
            "data": ["高度(km)与气温(°C)变化关系"]
        },
        "xAxis": [{
            "type": "value",
            "axisLabel": {
                "formatter": "{value} °C"
            }
        }],
        "yAxis": [{
            "type": "category",
            "boundaryGap": false,
            "axisLine": {
                "onZero": false
            },
            "axisLabel": {
                "formatter": "{value} km"
            },
            "data": [
                0, 10, 20, 30, 40, 50, 60, 70, 80
            ]
        }],
        "series": [{
            "smooth": true,
            "name": "高度(km)与气温(°C)变化关系",
            "type": "line",
            "itemStyle": {
                "normal": {
                    "lineStyle": {
                        "shadowColor": "rgba(0,0,0,0.4)"
                    }
                },
                "emphasis": {}
            },
            "data": [
                15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5
            ]
        }]
    };
    // 下面是使用Java 生成的json 数据 ，直接返回
    var op2 = {"calculable": true,"toolbox": {"feature": {"mark": {"show": true,"title": {"markUndo": "删除辅助线","markClear": "清空辅助线","mark": "辅助线开关"},"lineStyle": {"color": "#1e90ff","type": "dashed","width": 2}},"dataView": {"show": true,"title": "数据视图","readOnly": false,"lang": ["数据视图","关闭","刷新"]},"magicType": {"show": true,"title": {"bar": "柱形图切换","stack": "堆积","tiled": "平铺","line": "折线图切换"},"type": ["line","bar"]},"restore": {"show": true,"title": "还原"},"saveAsImage": {"show": true,"title": "保存为图片","type": "png","lang": ["点击保存"]}},"show": true},"tooltip": {"trigger": "axis","formatter": "Temperature : <br/>{b}km : {c}°C"},"legend": {"data": ["高度(km)与气温(°C)变化关系"]},"xAxis": [{"type": "value","axisLabel": {"formatter": "{value} °C"}}],"yAxis": [{"boundaryGap": false,"type": "category","axisLine": {"onZero": false},"axisLabel": {"formatter": "{value} km"},"data": [0,10,20,30,40,50,60,70,80]}],"series": [{"smooth": true,"name": "高度(km)与气温(°C)变化关系","type": "line","itemStyle": {"normal": {"lineStyle": {"shadowColor": "rgba(0,0,0,0.4)"}}},"data": [15,-50,-56.5,-46.5,-22.1,-2.5,-27.7,-55.7,-76.5]}]};
    return op2;
}

