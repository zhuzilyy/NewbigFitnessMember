package com.member.gufei.bigfitness.com.GuFei.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by GuFei_lyf on 2017/3/21
 * Activity的依赖作用域
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {

}

