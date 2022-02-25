package Utilities;


import Enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

        private static final Properties properties = new Properties();

        static {

            try (FileInputStream file = new FileInputStream("src/test/resources/config/config.properties")) {
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String get(ConfigProperties key) {
            return properties.getProperty(key.name().toLowerCase());
        }
}
