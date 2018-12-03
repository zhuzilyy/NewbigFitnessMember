package com.member.gufei.bigfitness.com.GuFei.Component;


import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.CardIndex.CardIndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C1.IndexFragMentC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C2.IndexFragMentC2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C3.IndexFragMentC3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C4.IndexFragMentC4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.ChildIndex.C5.IndexFragMentC5;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.Index.IndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.GymnasticsRecordFragment.GymnasticsRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyCourseFragment.PrivateRecordFragment.PrivateRecordFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyIndex.MyIndexFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyGymnasticsFragment.MyGymnasticsFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyOthersFragment.MyOthersFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyCourseFragment.MyPrivateFragment.MyPrivateFragment;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.FragMents.MyScheduleList.MyScheduleFragMent;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C1.IndexFragMentCC1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C2.IndexFragMentCC2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C3.IndexFragMentCC3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyCardList.ChildIndex.C4.IndexFragMentCC4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C1.IndexFragMentCP1;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C2.IndexFragMentCP2;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C3.IndexFragMentCP3;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C4.IndexFragMentCP4;
import com.member.gufei.bigfitness.com.GuFei.Member.Ui.Main.Index.MyCenter.MyPrivateTeaching.ChildIndex.C5.IndexFragMentCP5;
import com.member.gufei.bigfitness.com.GuFei.Moudel.FragmentModule;




import dagger.Component;

/**
 * Created by GuFei_lyf on 2017/3/21
 * Fragment的依赖
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)

public interface FragmentComponent {

    void inject(IndexFragMent indexFragment);
    void inject(CardIndexFragMent cardIndexFragMent);
    void inject(MyIndexFragMent myIndexFragMent);



    void inject(IndexFragMentC1 indexFragMentC1);
    void inject(IndexFragMentC2 indexFragMentC2);
    void inject(IndexFragMentC3 indexFragMentC3);
    void inject(IndexFragMentC4 indexFragMentC4);
    void inject(IndexFragMentC5 indexFragMentC5);

    void inject(IndexFragMentCP1 indexFragMentCP1);
    void inject(IndexFragMentCP2 indexFragMentCP2);
    void inject(IndexFragMentCP3 indexFragMentCP3);
    void inject(IndexFragMentCP4 indexFragMentCP4);
    void inject(IndexFragMentCP5 indexFragMentCP5);

    void inject(IndexFragMentCC1 indexFragMentCC1);
    void inject(IndexFragMentCC2 indexFragMentCC2);
    void inject(IndexFragMentCC3 indexFragMentCC3);
    void inject(IndexFragMentCC4 indexFragMentCC4);


    void inject(PrivateRecordFragment privateRecordFragment);
    void inject(GymnasticsRecordFragment gymnasticsRecordFragment);
    void inject(MyScheduleFragMent myScheduleFragMent);
    void inject(MyGymnasticsFragment myGymnasticsFragment);
    void inject(MyPrivateFragment myPrivateFragment);
    void inject(MyOthersFragment myOthersFragment);




//
//    void inject(SelectListFragent selectListFragent);
//
//    void inject(IndexFragMent indexFragment);
//
//    void  inject(AddressListFragMent addressListFragMent);
//
//    void  inject(MyCenterMainFragMent myCenterMainFragMent);
//
//
//    void  inject(TrainingPlanListTodayFragMent trainingPlanListTodayFragMent);
//
//    void  inject(TrainingPlanListHistoryFragMent trainingPlanListHistoryFragMent);
//
//    void  inject(MonFragment monFragment);
//
//    void inject(IndexFragment indexFragment);
//
//    void inject(DayFragment dayFragment);
//
//    void inject(ListFragment listFragment);
//
//    void inject(WeekFragment weekFragment);
//
//    void inject(Index1FragMent index1FragMent);
//    void inject(Index2FragMent index2FragMent);
//    void inject(Index3FragMent index3FragMent);
//    void inject(Index4FragMent index4FragMent);







//
//    void inject(NearFragment nearFragment);
//
//    void inject(ShoppingCartFragment shoppingCartFragment);
//
//    void inject(UserFragment userFragment);
//
//    void inject(LoginFragment loginFragment);
//
//    void inject(RegisterFragment registerFragment);
//
//    void inject(RetrieveFragment retrieveFragment);
//
//    void inject(NextFragment nextFragment);
}
