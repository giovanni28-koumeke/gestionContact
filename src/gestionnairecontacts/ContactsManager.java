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

    private List<Contacts> LContacts = new ArrayList();

    public void AjoutContacts(String nom, String telephone, String email) {
        Contacts contact = new Contacts(nom, telephone, email);
        LContacts.add(contact);
    }

    public void AfficherContacts() {
        List<Contacts> contactsListe = Contacts.restaurer();
        for (Contacts Contact : contactsListe) {
            System.out.println(Contact.getNom());
            System.out.println(Contact.getTelephone());
            System.out.println(Contact.getEmail());
            System.out.println("-------------------------------");
        }
    }

    public void rechercherContact(String nom) {
        List<Contacts> contactsListe = Contacts.restaurer();
        for (Contacts Contact : contactsListe) {
            if (Contact.getNom().equals(nom)) {
                System.out.println(Contact.getNom());
                System.out.println(Contact.getTelephone());
                System.out.println(Contact.getEmail());
            }
        }
    }

    public void supprimerContact(String nom) {
        List<Contacts> contactsListe = Contacts.restaurer();
        for (Contacts Contact : contactsListe) {
            if (Contact.getNom().equals(nom)) {
                contactsListe.remove(Contact);
            }
        }
    }

    public List<Contacts> getContacts() {
        return this.LContacts;
    }
}
