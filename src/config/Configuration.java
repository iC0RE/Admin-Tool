/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;
import java.io.InputStream;
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

    public static String getValue(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Es wurde kein Feld angegeben.");
        }
        final String searchKey = field.getSearchKey();
        
        return properties.getProperty(searchKey);
    }
}
