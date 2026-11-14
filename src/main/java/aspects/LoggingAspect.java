package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    long t1,t2;
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect() throws IOException {
     logger.addHandler(new FileHandler("log.xml"));
     //logger.setUseParentHandlers(false );//desactiver log dans la console
    }

    @Pointcut("execution(* Metier.IMetierBanqueImpl.*(..))")
    void pc1(){}


   /* @Before("pc1()")
    public void before(JoinPoint joinPoint){
      t1=System.currentTimeMillis();
        logger.info("-----------------------------------------------------------");
        logger.info("Avant l'execution de la méthode: " +joinPoint.getSignature());
    }

    @After("pc1()")
    public void after(JoinPoint joinPoint){
        logger.info("After l'execution de la méthode: " +joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode : " +(t2-t1));
        logger.info("-----------------------------------------------------------");
    }*/

    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        t1 = System.currentTimeMillis();

        logger.info("-----------------------------------------------------------");
        logger.info("Avant l'exécution de la méthode : " + joinPoint.getSignature());

        // Exécuter la méthode cible
        Object result = joinPoint.proceed(); //car il exsite de methode qui ont un type de retour

        t2 = System.currentTimeMillis();

        logger.info("Après l'exécution de la méthode : " + joinPoint.getSignature());
        logger.info("Durée d'exécution de la méthode : " + (t2 - t1) + " ms");
        logger.info("-----------------------------------------------------------");

        return result;
    }
}
