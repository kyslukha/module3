package ua.com.alevel.helper;


import ua.com.alevel.action.DaoFollowers;
import ua.com.alevel.action.DaoUser;
import ua.com.alevel.dao.*;
import ua.com.alevel.model.User;

import java.util.*;

public class HelperUser {

    private static final String messageUserIdUpdate = "Enter the User's id";
    private static final String messageToGetIdUpdate = "Enter User's id for update ";
    private static final String messageToUpdateName = "Enter User's name";
    private static final String messageLoginUpdate ="Enter login";
    private static final String messageMailUpdate = "Enter Mail User's";
    private static final String messageAgeUpdate = "How old is User?";
    private static final String messageUserIdNew ="Enter Id for New User";
    private static final String messageToNewName = "Enter name for New User";
    private static final String messageLoginNew = "Enter new login";
    private static final String messageMailNew = "Enter New Mail";
    private static final String messageAgeNew = "Age of new User";
    private static final String messageDeleteId = "What's Id do you want delete?";
    public static String suggestUserMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Users or press Back to return to the menu");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsUser(String method) {
        if (method.equals("Read")) {

            DaoUser.showUser();
            methodsUser(suggestUserMethod());
        } else if (method.equals("Update")) {
            Integer userIdTOUpdate = getUserInteger(messageUserIdUpdate);
            String userFullName = getUserString(messageToUpdateName);
            String loginUpdate = getUserString(messageLoginUpdate);
            String emailUpdate = getUserString(messageMailUpdate);
            Integer ageUpdate = getUserInteger(messageAgeUpdate);
            List<User> subscriptionsUpdate = DaoUser.findById(userIdTOUpdate).getSubscriptions();
            boolean authorUpdate =DaoUser.findById(userIdTOUpdate).getAuthor();
            boolean moderatorUpdate = DaoUser.findById(userIdTOUpdate).getModerator();
            List<User> followers = DaoUser.findById(userIdTOUpdate).getFollowers();
            User updateUser= new User(userIdTOUpdate, userFullName,loginUpdate,emailUpdate,ageUpdate,subscriptionsUpdate,authorUpdate,moderatorUpdate,followers);
            DaoUser.update( updateUser);
            methodsUser(suggestUserMethod());
        } else if (method.equals("Create")) {
            Integer userIdNew = getUserInteger(messageUserIdNew);
            String userFullNameNew = getUserString(messageToNewName);
            String loginNew = getUserString(messageLoginNew);
            String emailNew = getUserString(messageMailNew);
            Integer ageNew = getUserInteger(messageAgeNew);
            List<User> subscriptionsNew = new ArrayList<>();
            boolean authorNew =false;
            boolean moderatorNew = false;
            List<User> followersNew = new ArrayList<>();
            User userNew= new User(userIdNew, userFullNameNew,loginNew,emailNew,ageNew,subscriptionsNew, authorNew, moderatorNew,followersNew);
            DaoUser.create(userNew);
            methodsUser(suggestUserMethod());
        } else if (method.equals("Delete")) {
        Integer deleteId = getUserInteger(messageDeleteId);

            methodsUser(suggestUserMethod());
        } else if (method.equals("Back")) {
            HelperApp.methodsApp(HelperApp.appSuggestion());
        }
    }


    private static String getUserString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private static Integer getUserInteger(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Integer integer = scanner.nextInt();
        return integer;
    }

    private static Boolean getUserBoolean(String message) {
        System.out.println(message);
        Boolean flag = null;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        switch ("str") {
            case "Y":
                flag = true;
                break;
            case "N":
                flag = false;
                break;
            default:
                System.out.println("Wrong answer");
                System.exit(3);
        }

        return flag;
    }
}
