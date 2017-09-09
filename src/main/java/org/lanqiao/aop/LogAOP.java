package org.lanqiao.aop;


import org.aspectj.lang.JoinPoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * Created by Administrator on 2017/9/6.
 */
public class LogAOP {
    //要记录的日志内容
    String strLog=null;
    Logger logger= Logger.getLogger(LogAOP.class);
    //前置通知
    public void somethingBefore(JoinPoint joinpoint){
        System.out.println("进入了前置通知");
        //
        strLog="log Begining method:"
                +joinpoint.getTarget().getClass().getName()+"."
                +joinpoint.getSignature().getName();
        logger.info(strLog);
    }
    //后置通知
    public void somethingAfter(JoinPoint joinpoint){
        System.out.println("进入了后置通知");
        //
        strLog="log Begining method:"
                +joinpoint.getTarget().getClass().getName()+"."
                +joinpoint.getSignature().getName();
        logger.info(strLog);
    }
    //环绕通知
    public Object somethingAround(ProceedingJoinPoint pjp) throws Throwable{
        //获取当前系统时间
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end=System.currentTimeMillis();
        logger.info("该方法执行了"+(end-start));
        return retVal;
    }

}
