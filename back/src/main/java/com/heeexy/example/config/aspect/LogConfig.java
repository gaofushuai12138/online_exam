package com.heeexy.example.config.aspect;

import com.heeexy.example.bean.SysLog;
import com.heeexy.example.config.annotation.Log;
import com.heeexy.example.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Objects;


@Aspect
@Configuration
public class LogConfig {

    @Autowired
    private SysLogService sysLogService;


    @Pointcut("@annotation(com.heeexy.example.config.annotation.Log)")
    public void excudeService(){

    }


    @AfterReturning(pointcut = "excudeService()")
    public void doAfter(JoinPoint joinPoint){
        try {
            String methodName = joinPoint.getSignature().getName();
            Method method = currentMethod(joinPoint,methodName);
            Log log = method.getAnnotation(Log.class);
            sysLogService.addSysLog(log.moudle(),log.descrption());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
//    @Pointcut("execution(* )")

    /**
     * 获取当前执行的方法
     *
     * @param joinPoint  连接点
     * @param methodName 方法名称
     * @return 方法
     */
    private Method currentMethod(JoinPoint joinPoint, String methodName) {
        /**
         * 获取目标类的所有方法，找到当前要执行的方法
         */
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }
}
