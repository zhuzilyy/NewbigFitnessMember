package com.member.gufei.bigfitness.com.GuFei.Model.local;

import java.util.List;

/**
 * Created by GuFei_lyf on 2017/6/5
 */

public class CustomerIntroducerBean {

    /**
     * message :
     * result : [{"Name":"scott","ID":18,"Tel":"18842904041"},{"Name":"乔巴","ID":19,"Tel":"13604040101"},{"Name":"费欧娜","ID":20,"Tel":"15685423562"},{"Name":"方便面","ID":21,"Tel":"13666669999"},{"Name":"小A","ID":22,"Tel":"13100000000"},{"Name":"小白1","ID":23,"Tel":"15998887639"},{"Name":"scott1","ID":24,"Tel":"18842904042"},{"Name":"小白","ID":25,"Tel":"13940206542"},{"Name":"果冻","ID":26,"Tel":"13322228888"},{"Name":"小公举","ID":27,"Tel":"18698841230"},{"Name":"鲁尼","ID":28,"Tel":"13000000000"},{"Name":"小公举","ID":69,"Tel":"18698845765"},{"Name":"虾条","ID":45,"Tel":"17555449999"},{"Name":"德莱厄斯","ID":29,"Tel":"15100000000"},{"Name":"乔治","ID":46,"Tel":"13604040606"},{"Name":"大名","ID":30,"Tel":"15899996666"},{"Name":"雪碧","ID":31,"Tel":"18878787878"},{"Name":"可乐","ID":32,"Tel":"13555757575"},{"Name":"小D","ID":33,"Tel":"13400000000"},{"Name":"薯条","ID":34,"Tel":"13244445555"},{"Name":"小C","ID":35,"Tel":"13300000000"},{"Name":"酸奶","ID":36,"Tel":"17858586565"},{"Name":"小白3","ID":37,"Tel":"15340206542"},{"Name":"小公主","ID":38,"Tel":"18692365412"},{"Name":"佩奇","ID":39,"Tel":"13604040505"},{"Name":"小B","ID":40,"Tel":"13200000000"},{"Name":"小白5","ID":41,"Tel":"15997888888"},{"Name":"小白5","ID":42,"Tel":"15997888888"},{"Name":"小白5","ID":43,"Tel":"15997888888"},{"Name":"小白2","ID":44,"Tel":"13940206543"},{"Name":"小白","ID":47,"Tel":"15740000000"},{"Name":"雪糕","ID":48,"Tel":"13232323232"},{"Name":"小Q","ID":49,"Tel":"13200005555"},{"Name":"胜美","ID":58,"Tel":"17854217896"},{"Name":"西蓝花","ID":50,"Tel":"13322222222"},{"Name":"小樱","ID":51,"Tel":"18698846765"},{"Name":"小F","ID":52,"Tel":"13222223333"},{"Name":"小白6","ID":53,"Tel":"15988888888"},{"Name":"小Z","ID":54,"Tel":"18800008888"},{"Name":"小Z","ID":55,"Tel":"18800008888"},{"Name":"小鸽子","ID":56,"Tel":"18696969639"},{"Name":"妖妖","ID":57,"Tel":"14754789541"},{"Name":"关关","ID":60,"Tel":"17142714525"},{"Name":"小白7","ID":59,"Tel":"13940206541"},{"Name":"阿米尔、汗","ID":61,"Tel":"13604040102"},{"Name":"王敬白","ID":62,"Tel":"15998887638"},{"Name":"薯片","ID":63,"Tel":"15941412525"},{"Name":"冰淇淋","ID":64,"Tel":"18567678989"},{"Name":"蚯蚓","ID":65,"Tel":"13154789632"},{"Name":"微微","ID":66,"Tel":"15840111111"},{"Name":"小M","ID":67,"Tel":"13600007878"},{"Name":"565","ID":68,"Tel":"13999996555"},{"Name":"小白","ID":70,"Tel":"15998887631"},{"Name":"小白","ID":71,"Tel":"15998887631"},{"Name":"小白3","ID":72,"Tel":"15998887633"},{"Name":"小白1","ID":73,"Tel":"15998887632"},{"Name":"1","ID":74,"Tel":"13272458963"},{"Name":"2","ID":75,"Tel":"15887985555"},{"Name":"小白7","ID":88,"Tel":"15998887640"},{"Name":"家家","ID":76,"Tel":"15657894567"},{"Name":"zz","ID":77,"Tel":"15998887637"},{"Name":"小龙","ID":96,"Tel":"18699999999"},{"Name":"小白5","ID":78,"Tel":"15998887634"},{"Name":"啊","ID":79,"Tel":"15789652222"},{"Name":"小白6","ID":80,"Tel":"15998887635"},{"Name":"小可爱","ID":81,"Tel":"18698874569"},{"Name":"飞特","ID":82,"Tel":"13505056666"},{"Name":"顶顶顶顶","ID":83,"Tel":"13000001234"},{"Name":"测试","ID":84,"Tel":"13000000011"},{"Name":"LOCK","ID":85,"Tel":"13200005858"},{"Name":"测试啊！","ID":86,"Tel":"13066669999"},{"Name":"公海客户1","ID":87,"Tel":"13698745698"},{"Name":"小白20","ID":89,"Tel":"15998887620"},{"Name":"小a","ID":90,"Tel":"13698745896"},{"Name":"XI哦","ID":91,"Tel":"13000009999"},{"Name":"小p","ID":92,"Tel":"13656987589"},{"Name":"羚羊","ID":93,"Tel":"13645678900"},{"Name":"瞪羚","ID":94,"Tel":"18696676767"},{"Name":"小E","ID":95,"Tel":"13300002222"},{"Name":"跳跳糖","ID":97,"Tel":"13601010909"},{"Name":"萧峰","ID":98,"Tel":"13569874585"},{"Name":"小YY","ID":99,"Tel":"13099900000"},{"Name":"小白21","ID":105,"Tel":"15998887643"},{"Name":"小白24","ID":100,"Tel":"15998887646"},{"Name":"请问全球","ID":101,"Tel":"13233212333"},{"Name":"123","ID":102,"Tel":"13231232321"},{"Name":"測試定金1","ID":103,"Tel":"15998887645"},{"Name":"小白23","ID":104,"Tel":"15998887646"}]
     * code : 0
     */

    private String message;
    private int code;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * Name : scott
         * ID : 18
         * Tel : 18842904041
         */

        private String Name;
        private int ID;
        private String Tel;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }
    }
}
