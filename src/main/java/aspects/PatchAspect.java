package aspects;

import Metier.Compte;
import Metier.IMetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchAspect {
    @Pointcut("execution(* Metier.IMetierBanqueImpl.retirer(..))")
    void pc1(){}


    @Around("pc1() && args(code,montant)")
    //args(code,montant) : récupère les arguments de la méthode interceptée et les associe aux paramètres code et montant de ton advice.
    public Object autourretirre(Long code , double montant,ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {//JoinPoint : permet d'obtenir des informations sur la méthode interceptée, son objet cible et ses arguments.
        IMetierBanqueImpl metierBanque = (IMetierBanqueImpl) joinPoint.getTarget();//l'ojet surlaquelle s'applique la méthode
        Compte compte = metierBanque.consulter(code);
        if(compte.getSolde()<montant) throw new RuntimeException("Solde INsuffisant");
        return proceedingJoinPoint.proceed();
    }
}
