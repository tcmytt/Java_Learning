package vn.titv.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//    @Before("execution (* vn.titv.spring.aop.service.CalculatorService.add(..))")
//    public void beforeAdd(JoinPoint joinPoint){
//        System.out.println("Running method Add of Calculator!");
//    }
//
//    @After("execution (* vn.titv.spring.aop.service.CalculatorService.add(..))")
//    public void afterAdd(JoinPoint joinPoint){
//        System.out.println("Done!");
//    }
//
//    @AfterThrowing("execution (* vn.titv.spring.aop.service.CalculatorService.*(..))")
//    public void AfterThrowing(JoinPoint joinPoint){
//        System.out.println("Error!!!!!!");
//    }

    @Pointcut("execution (* vn.titv.spring.aop.service.*.*(..)))")
    public void myPointCut(){
    }

    @Before("myPointCut()")
    public void runningOperation(JoinPoint joinPoint){
        System.out.println("Running: "+joinPoint.getSignature().getName());
    }

    @After("myPointCut()")
    public void afterOperation(JoinPoint joinPoint){
        System.out.println("Done: "+joinPoint.getSignature().getName());
    }

    @Around("myPointCut()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName=joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime= System.currentTimeMillis();
        long executionTime = endTime-startTime;
        System.out.println("Result: "+result);
        System.out.println("executionTime: " + executionTime);

        return  result;
    }
}
