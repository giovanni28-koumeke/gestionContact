/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionnairecontacts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class Contacts implements Serializable{
    private String nom;
    private String telephone;
    private String email;
    
    
    public Contacts(String nom, String telephone, String email){
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
   public static void sauvegarder(List<Contacts> contacts) throws IOException {
    String filePath = "gestionContacts.ser";
    try (FileOutputStream fichier = new FileOutputStream(filePath);
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier)) {
        objectOutputStream.writeObject(contacts);
        objectOutputStream.flush();
    } // flux fermés automatiquement
}

    public static List<Contacts> restaurer() {
        String filePath = "gestionContacts.ser";
        try (FileInputStream fichier = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fichier)) {
            @SuppressWarnings("unchecked")
            List<Contacts> contacts = (List<Contacts>) objectInputStream.readObject();
            return contacts;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Si le fichier n'existe pas ou si une erreur survient, renvoyer une liste vide.
            return new ArrayList<>();
        }
    }}
