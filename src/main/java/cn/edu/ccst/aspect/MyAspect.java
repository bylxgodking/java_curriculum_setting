package cn.edu.ccst.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/28/13:36
 * @Description:
 */
public class MyAspect {

    /**
     * 定义增强的方法:如果前后都要增强的方法
     * 那么就还使用环绕通知/增强
     */
    /**
     * 自定义环绕通知
     * @param joinPoint 连接点/切入点,即目标方法
     * @return 目标方法的返回值
     */
        public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
            // 目标方法前:
            System.out.println("开启事务/权限校验" );

            // 目标方法执行
            Object ret = joinPoint.proceed( );
            System.out.println("目标方法返回值---> " + ret );
            // 目标方法后:
            System.out.println("提交事务/日志记录" );
            return ret;
        }

}
