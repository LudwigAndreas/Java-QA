package org.example.settings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private static String filename = "settings.xml";

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Settings.class.getClassLoader().getResourceAsStream(filename)) {
            if (input == null)
                throw new FileNotFoundException("File not found: " + filename);
            properties.loadFromXML(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading file: " + filename);
        }
    }

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getFirstName() {
        return properties.getProperty("firstName");
    }

    public static String getLastName() {
        return properties.getProperty("lastName");
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}

