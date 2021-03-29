package ua.com.alvel;

import java.sql.Connection;

public class App {

    public static void main(String[] args) {
        Connection connection = buildConnection();
        methodsApp(appSuggestion(),connection);
    }
}
