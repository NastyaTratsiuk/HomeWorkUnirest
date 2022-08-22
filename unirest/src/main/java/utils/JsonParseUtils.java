package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class JsonParseUtils {

    public static String getElementFromJsonParse(String jsonFile, String valueFile){
        ISettingsFile environment = new JsonSettingsFile(jsonFile);
         return environment.getValue(valueFile).toString();
    }

}
