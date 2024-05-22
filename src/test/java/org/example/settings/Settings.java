package org.example.settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Settings {

    private static String filename = "src/test/resources/settings.xml";

    private static String baseUrl;

    private static String login;

    private static String password;

    private static volatile Settings instance;


    private Settings() {
        try {
            Properties properties = new Properties();
            properties.loadFromXML(new FileInputStream(filename));
            baseUrl = properties.getProperty("baseUrl");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filename);
        } catch (IOException e) {
            throw new RuntimeException("Error loading file: " + filename);
        }
    }

    public static Settings getInstance() {
        Settings localInstance = instance;
        if (localInstance == null) {
            synchronized (Settings.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Settings();
                }
            }
        }
        return localInstance;
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            getInstance();
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            getInstance();
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            getInstance();
        }
        return password;
    }


}

