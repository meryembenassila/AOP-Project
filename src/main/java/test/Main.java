package test;

import Metier.Compte;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        new  Main().start();
    }

    private void start() {
        System.out.println("Démarrage de 'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code du compte  ");
        Long code = scanner.nextLong();
        System.out.println("Donner le solde initial du compte  ");
        double balance = scanner.nextDouble();
        IMetierBanque iMetierBanque = new IMetierBanqueImpl();

        Compte compte = new Compte(code, balance);

        iMetierBanque.addCompte(compte);
        while (true){
            try {
                System.out.println("Type d'opération ");

                String type = scanner.next();
                if (type.equals("quitter")) break;
                System.out.println("Montant");
                double  montant = scanner.nextDouble();
                if(type.equals("v")){
                    iMetierBanque.verser(code , montant);
                }else if (type.equals("r")){
                    iMetierBanque.retirer(code , montant);
                }
                Compte compte1 = iMetierBanque.consulter(code);
                System.out.println("Etat du compte " + compte1.toString());
            }catch (Exception e ){
                    System.out.println(e.getMessage());
            }

        }



    }
}