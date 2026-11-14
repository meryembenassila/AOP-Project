package Metier;

public interface IMetierBanque {
    void addCompte(Compte cp);
    void verser(Long cp ,double montant);
    void retirer(Long cp ,double montant);
    Compte consulter(Long cp );

}
