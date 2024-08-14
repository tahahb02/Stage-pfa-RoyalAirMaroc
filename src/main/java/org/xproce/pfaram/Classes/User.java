package org.xproce.pfaram.Classes;
import java.util.Objects;

public class User {
    // Booleans
    public static Boolean isUserRegistered = Boolean.FALSE;
    public static Boolean isUserLoggedIn = Boolean.FALSE;
    public static Boolean isUserSupervisor = Boolean.FALSE;
    public static Boolean isUserTechnician = Boolean.FALSE;


    // Private Attributes
    public static String nom = "";
    public static String email = "";
    public static String mot_de_passe = "";
    public static String prenom = "";
    public static String role = "";

    // Methods
    public static void setCurrentUser(String userName, String userEmail, String userMotDePasse, String userPrenom, String userRole) {
        isUserLoggedIn = Boolean.TRUE;

        nom = userName;
        email = userEmail;
        mot_de_passe = userMotDePasse;
        prenom = userPrenom;
        role = userRole;

        if(Objects.equals(role, "superviseur")) {
            isUserSupervisor = Boolean.TRUE;
        }
        else if(Objects.equals(role, "technicien")) {
            isUserTechnician = Boolean.TRUE;
        }
    };

    public static void clearCurrentUser() {
        isUserLoggedIn = Boolean.FALSE;
        isUserSupervisor = Boolean.FALSE;
        isUserTechnician = Boolean.FALSE;
        nom = "";
        email = "";
        mot_de_passe = "";
        prenom = "";
        role = "";
    }


}