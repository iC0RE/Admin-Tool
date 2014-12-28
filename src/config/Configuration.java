/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author langep16
 */
public class Configuration {

    private static Properties properties;
    private static final Logger log = Logger.getLogger(Configuration.class.getCanonicalName());

    // Definiert Beziehung zwischen Properties und Configuration
    public enum Field {

        UrlPrefix("database.urlPrefix"),
        Host("database.host"),
        Port("database.port"),
        Name("database.name"),
        User("database.user"),
        Password("database.password");

        private final String searchKey;

        private Field(String searchKey) {
            this.searchKey = searchKey;
        }

        public String getSearchKey() {
            return searchKey;
        }
    }

    //Vor Instanziierung ausgeführt - noch vor dem Laden durch den Class-Loader
    static {
        InputStream input = Configuration.class.getResourceAsStream("application.properties");
        properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException ex) {
            System.err.printf("Konfiguration konnte nicht geladen werden: %s", ex.getMessage());
            System.exit(2);
        }

    }

    //TEST FÜR ÄNDERUNG DER KONFIGURATION
//    public static void newConfiguration(String host, String port, String name, String user, String password) {
//        InputStream input = Configuration.class.getResourceAsStream("application.properties");
//        properties = new Properties();
//        properties.setProperty("database.host", host);
//        properties.setProperty("database.port", port);
//        properties.setProperty("database.name", name);
//        properties.setProperty("database.user", user);
//        properties.setProperty("database.password", password);
//        try {
//            properties.load(input);
//        } catch (IOException ex) {
//            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static String getValue(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Es wurde kein Feld angegeben.");
        }
        final String searchKey = field.getSearchKey();

        return properties.getProperty(searchKey);
    }
}
