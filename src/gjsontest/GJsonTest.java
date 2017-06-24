/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gjsontest;

import com.gjson.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author russm
 */
public class GJsonTest {
    static boolean fakeRead = true;
 
    

    static String readFile(String path, Charset encoding)
            throws IOException {
        
        if (fakeRead)
        {
            String str = "{ \"type\": \"Polygon\", \"points\": [ {\"coordinates\": [34.111489, -118.323842] }, {\"coordinates\": [34.323654, -125.851421] } ] }";
            return str;
        }
        else
        {     
            byte[] encoded = Files.readAllBytes(Paths.get(path));        
            return new String(encoded, encoding);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        GeoJSONParser geoParser = new GeoJSONParser();
        try{
            
            String jsonData = readFile("D:\\data\\data.json",StandardCharsets.UTF_8);
            Polygon myPoly = geoParser.parsePolygon(jsonData);
            myPoly.print();
            
        } catch (Exception e){            
            System.out.println("Error parsing json: " + e.getMessage());
        }
    }
    
}
