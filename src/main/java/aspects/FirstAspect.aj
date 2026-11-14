package aspects;

public aspect FirstAspect {
    pointcut pc1():execution(* test.Main.main(..));

    before():pc1(){
        System.out.println("==================== Before main from Aspect with AspectJ syntax ============================= ");
    }
    after():pc1(){
        System.out.println(" =====================After main from Aspect with AspectJ syntax ==============================");

    }

   // void around(): pc1(){
   //     System.out.println("==================== Before main from Aspect with AspectJ syntax ============================= ");
    //    proceed();
    //    System.out.println(" =====================After main from Aspect with AspectJ syntax ==============================");
    //}
}