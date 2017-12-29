package com.sbm.module.common.api.restinteractive.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.annotation.authorization<br/>
 * File Name:Authorization.java<br/>
 * 
 * 作成日 ：2017-8-2 上午11:09:54 <br/>
 * 
 * @author ：junkai.zhang
 */
@Documented
@Inherited
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RestInteractive {

}
