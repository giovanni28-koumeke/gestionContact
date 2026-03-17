# Gestionnaire de Contacts

Une application console simple en Java pour gérer vos contacts. Ce projet permet d'ajouter, d'afficher, de rechercher et de supprimer facilement des contacts, avec une sauvegarde persistante dans un fichier.

## 🚀 Fonctionnalités

* **Ajouter un contact :** Créez un nouveau contact avec son nom, numéro de téléphone et adresse e-mail. Le système empêche la création de doublons (contacts ayant le même nom).
* **Voir les contacts :** Affichez la liste complète de tous les contacts enregistrés avec leurs détails.
* **Rechercher un contact :** Trouvez un contact spécifique en entrant son nom.
* **Supprimer un contact :** Supprimez un contact existant à partir de son nom.
* **Sauvegarde persistante :** Les contacts sont sauvegardés dans un fichier afin d'être restaurés au prochain lancement de l'application.

## 🛠️ Prérequis

* **Java Development Kit (JDK) :** Version 8 ou supérieure.
* Un IDE Java (comme **NetBeans**, **IntelliJ IDEA**, ou **Eclipse**), ou simplement un terminal pour compiler et exécuter le code.

## 📖 Comment l'utiliser

### Avec un IDE (ex: NetBeans)

1. Clonez ce dépôt Github sur votre machine locale.
2. Ouvrez le projet dans NetBeans (`File` > `Open Project`).
3. Cliquez sur le bouton "Run Project" pour compiler et exécuter l'application.
4. Suivez les instructions affichées dans la console !

### En ligne de commande

1. Ouvrez votre terminal et naviguez vers le répertoire \`src\` du projet :
   ```bash
   cd chemin/vers/GestionnaireContacts/src
   ```
2. Compilez les fichiers Java :
   ```bash
   javac gestionnairecontacts/*.java
   ```
3. Exécutez l'application :
   ```bash
   java gestionnairecontacts.Main
   ```

## 📁 Structure du Code

- `Main.java` : Contient la boucle principale de l'application et le menu interactif (en utilisant `Scanner` et `BufferedReader`).
- `Contacts.java` : Modèle représentant un contact (nom, téléphone, email), contenant également la logique de sauvegarde (`sauvegarder`) et de restauration (`restaurer`) sur le disque.
- `ContactsManager.java` : Gère la liste des contacts et fournit les méthodes pour l'ajout, la recherche, la suppression et l'affichage des informations.

## 👨‍💻 Auteur

Créé par **giova** **Giovanni KOUMEKE**.
