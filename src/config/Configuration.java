/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author langep16
 */
public class Configuration {

    private static final String DefaultConfigurationFileName = "config.ini";
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
        properties = new Properties();
        if (loadProperties()) {
        } else {
            loadDefaultProperties();
        }
    }

    public static boolean loadProperties() {
        boolean loadResult = true;
        try (InputStream input = new FileInputStream(DefaultConfigurationFileName)) {
            properties.load(input);
        } catch (IOException ex) {
            log.info("Konfigurationsdatei konnte nicht geladen werden.");
            loadResult = false;
        }

        return loadResult;
    }

    public static void storeProperties() {
        try (OutputStream stream = new FileOutputStream(DefaultConfigurationFileName)) {
            properties.store(stream, null);
        } catch (IOException ex) {
            log.severe("Konfigurationsdatei konnte nicht gespeichert werden.");
        }
    }

    private static void loadDefaultProperties() {
        try (InputStream input = Configuration.class.getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            System.err.printf("Standard-Konfiguration konnte nicht geladen werden: %s", ex.getMessage());
            System.exit(2);
        }
    }

    public static void setValue(Field field, String value) {
        if (field == null) {
            throw new IllegalArgumentException("Es wurde kein Feld angegeben.");
        }
        properties.put(field.getSearchKey(), value);
    }

    public static String getValue(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Es wurde kein Feld angegeben.");
        }
        final String searchKey = field.getSearchKey();

        return properties.getProperty(searchKey);
    }
}
