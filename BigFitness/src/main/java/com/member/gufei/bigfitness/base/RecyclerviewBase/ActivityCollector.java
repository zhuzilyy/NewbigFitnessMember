package com.member.gufei.bigfitness.base.RecyclerviewBase;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tre on 16/9/16.
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {

        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {

        activities.remove(activity);
    }

    public static void finishAllActivity() {

        for (Activity activity : activities) {

            if (!activity.isFinishing()) {

                activity.finish();
            }
        }

    }

}
