package ua.com.alevel.helper;

import java.util.Scanner;

import static ua.com.alevel.helper.HelperPost.methodsPost;
import static ua.com.alevel.helper.HelperUser.methodsUser;
import static ua.com.alevel.helper.HelperPost.suggestPostMethod;
import static ua.com.alevel.helper.HelperUser.suggestUserMethod;

public class HelperApp {
    public static void methodsApp(String method) {
        if (method.equals("Users")) {
            methodsUser(suggestUserMethod());
        } else if (method.equals("Posts")) {
            methodsPost(suggestPostMethod());
        } else if (method.equals("Exit")) {
            System.exit(1);
        }
    }
    public static String appSuggestion () {
        System.out.println("Here you can manipulate with objects : Users, Posts. And press Exit, if not interesting");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }
}


