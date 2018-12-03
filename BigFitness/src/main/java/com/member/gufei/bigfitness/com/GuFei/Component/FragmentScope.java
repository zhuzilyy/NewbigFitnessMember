package com.member.gufei.bigfitness.com.GuFei.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Description
 *
 * @author GuFei
 * @version 2016 10 04 14:59
 * Fragment的依赖作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
