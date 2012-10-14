package Conf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: marky
 * Date: 10/14/12
 * Time: 2:25 PM
 */
public class PlanetNames {
    public static final String[] planetNames = new String[]{"Planet1","Planet2","Planet3"};

    public static List<String> getPlanetNamesAsList(){
        return Arrays.asList(PlanetNames.planetNames);
    }
}
