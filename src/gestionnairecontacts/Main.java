/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionnairecontacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author giova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nom;
        String telephone;
        String email;
        ContactsManager cm = new ContactsManager();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        Scanner sc = new Scanner(System.in);

        int choix;

        do {
            System.out.println("\n--- GESTIONNAIRE DE CONTACTS ---");
            System.out.println("1 - Ajouter un contact");
            System.out.println("2 - Voir les contacts");
            System.out.println("3 - Rechercher un contact");
            System.out.println("4 - Supprimer un contact");
            System.out.println("5 - Quitter");
            System.out.println("Votre choix : ");

            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    try {
                        System.out.println("Entrez le nom : ");
                        nom = br.readLine();
                        // interdiction d'enrégistrer un contact avec un nom deja existant
                        boolean existe = false;
                        for (Contacts c : cm.getContacts()) {
                            if (c.getNom().equals(nom)) {
                                existe = true;
                                break;
                            }
                        }

                        if (existe) {
                            System.out.println("Ce contact existe deja");
                        } else {
                            System.out.println("Entrez le telephone : ");
                            telephone = br.readLine();
                            System.out.println("Entrez l'email : ");
                            email = br.readLine();

                            System.out.println("voullez-vous sauvegarder ce contact ?(oui / non)");
                            String reponse = br.readLine();
                            if (reponse.equals("oui")) {
                                try {
                                    // Ajout du contact à la liste des contacts seulement si l'utilisateur décide de
                                    // suvegarder
                                    cm.AjoutContacts(nom, telephone, email);
                                    Contacts.sauvegarder(cm.getContacts());
                                    System.out.println("sauvegarde réussi");
                                } catch (IOException e) {
                                    System.out.println("Erreur lors de la sauvegarde");
                                }
                            } else {
                                System.out.println("La sauvegarde n'est pas faite ");
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("revoyer correctement vos entrées");
                    }
                    break;
                case 2:
                    cm.AfficherContacts();
                    break;
                case 3:
                    try {
                        System.out.println("Entrez le nom : ");
                        nom = br.readLine();
                        cm.rechercherContact(nom);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Entrez le nom : ");
                        nom = br.readLine();
                        cm.supprimerContact(nom);
                        // sans la sauvegarde le contact est enlevé de la liste mais pas du fichier
                        Contacts.sauvegarder(cm.getContacts());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:

                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.");
            }
        } while (choix != 5);
    }
}
