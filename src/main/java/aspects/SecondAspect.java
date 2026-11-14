package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.Main.main(..))")
    public void pc1(){}
    @Before("pc1()")
    public  void before(){
        System.out.println("==================== Before main from Aspect with AspectJ class ============================= ");
    }
    @After("pc1()")
    public  void after(){
        System.out.println("==================== After main from Aspect with AspectJ class ============================= ");
    }

   // @Around("pc1()")
    public  void arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("==================== Before main from Aspect with AspectJ class ============================= ");
        proceedingJoinPoint.proceed();
        System.out.println("==================== After main from Aspect with AspectJ class ============================= ");
    }
}
//l'ordre des aspects par defaut sont par ordre alphabétique  si on a pas determiner un ordre