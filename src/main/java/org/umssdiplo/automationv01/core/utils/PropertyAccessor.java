package org.umssdiplo.automationv01.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyAccessor {
    private static final String BROWSER = "browser";
    private static final String BASE_URL = "baseurl";
    private static final String BASE_JIRA_URL = "baseurljira";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private static final String PROJECT_URL = "projecturl";
    private static final String JIRA_URL = "basejiraurl";

    private static final String USERNAME = "username";

    private static PropertyAccessor PropertyAccessor;
    private Properties properties;

    private PropertyAccessor(){
        try(FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (FileNotFoundException fe){
            throw new RuntimeException(fe);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static PropertyAccessor getInstance(){
        if(PropertyAccessor == null){
            PropertyAccessor = new PropertyAccessor();
        }
        return PropertyAccessor;
    }

    public int getImplicitTimeWait() {
        return Integer.parseInt(getDataProperty("implicitTimeWait"));
    }

    private String getDataProperty(String nameProperty) {
        String property = System.getProperty(nameProperty);
        if (property == null) {
            return properties.getProperty(nameProperty);
        }
        return property;
    }

    public int getExplicitTimeWait() {
        return Integer.parseInt(getDataProperty("explicitTimeWait"));
    }

    public String getBrowser() {
        return getDataProperty(BROWSER);
    }

    public String getBaseUrl() {
        return getDataProperty(BASE_URL);
    }

    public String getProjectUrl() {
        return getDataProperty(PROJECT_URL);
    }

    public String getJiraUrl() {
        return getDataProperty(JIRA_URL);
    }

    public String getBaseJiraUrl() {
        return getDataProperty(BASE_JIRA_URL);
    }

    public String getUser() {
        //return null;
        return getDataProperty(USERNAME);
    }

    public String getPassword() {

        //return null;
        return getDataProperty(PASSWORD);
    }
}
