package ua.com.alevel.helper;




import ua.com.alevel.action.DaoUser;
import ua.com.alevel.model.User;

import java.util.Scanner;

public class HelperPost {
    private static final String messagePostId = "Enter the Post's id";

    public static String suggestPostMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Posts or press Back to return to the menu");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsPost(String method){
        if(method.equals("Read")){

            methodsPost(suggestPostMethod());
        }else if(method.equals("Update")){

            methodsPost(suggestPostMethod());
        }else if(method.equals("Create")){

            methodsPost(suggestPostMethod());
        }else if(method.equals("Delete")){


            methodsPost(suggestPostMethod());
        }else if(method.equals("Back")){
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
        switch ("str"){
            case"Y": flag= true;
                break;
            case"N": flag= false;
                break;
            default:
                System.out.println("Wrong answer");
                System.exit(3);
        }

        return flag;
    }
}