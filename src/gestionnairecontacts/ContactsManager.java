/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnairecontacts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class ContactsManager {

    private List<Contacts> LContacts;

    public ContactsManager() {
        // On charge la liste de contacts au démarrage
        this.LContacts = Contacts.restaurer();
    }

    public void AjoutContacts(String nom, String telephone, String email) {
        Contacts contact = new Contacts(nom, telephone, email);
        LContacts.add(contact);
    }

    public void AfficherContacts() {
        for (Contacts Contact : LContacts) {
            System.out.println(Contact.getNom());
            System.out.println(Contact.getTelephone());
            System.out.println(Contact.getEmail());
            System.out.println("-------------------------------");
        }
    }

    // Recherche un contact par son nom
    public void rechercherContact(String nom) {
        boolean trouve = false;
        for (Contacts Contact : LContacts) {
            if (Contact.getNom().equals(nom)) {
                trouve = true;
                System.out.println(Contact.getNom());
                System.out.println(Contact.getTelephone());
                System.out.println(Contact.getEmail());
            }
        } // gestion du cas où le contact n'est pas trouvé
        if (!trouve) {
            System.out.println("Contact non trouvé");
        }
    }

    public void supprimerContact(String nom) {
        // removeIf retourne true si au moins un élément a été supprimé (donc trouvé)
        boolean trouve = LContacts.removeIf(contact -> contact.getNom().equals(nom));

        if (!trouve) {
            System.out.println("Ce contact n'existe pas");
        } else {
            System.out.println("Contact supprimé");
        }
    }

    public List<Contacts> getContacts() {
        return this.LContacts;
    }
}
