package config;

import test.TestNG_Demo;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");
    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties()  {

        try {
            InputStream input = new FileInputStream(projectPath + "\\src\\test\\java\\config\\config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println("browser name: "+ browser);
            TestNG_Demo.browserName = browser;
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("config.properties not find");
            System.out.println(fileNotFoundException.getMessage());
            System.out.println(fileNotFoundException.getCause());
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setProperties(){
        try {
            OutputStream output = new FileOutputStream(projectPath + "\\src\\test\\java\\config\\config.properties");
            prop.setProperty("result", "pass");
            prop.store(output,"update browser");

        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("config.properties not find");
            System.out.println(fileNotFoundException.getMessage());
            System.out.println(fileNotFoundException.getCause());
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
