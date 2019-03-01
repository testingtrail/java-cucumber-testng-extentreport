package resources;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static ConfigFileReader configFileReader;
    private final String propertyFilePath = new File("")
            .getAbsolutePath() + "\\config\\config.properties";

    public ConfigFileReader(){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigFileReader getInstance(){
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the config.properties file for the Key:reportConfigPath");
    }

}
