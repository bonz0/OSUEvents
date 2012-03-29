/**
 * 
 */
package com.osuevents;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

/**
 * @author farhang
 *
 */
public class HttpHelper {
	public static String request(HttpResponse response) {
        String result = "";
        try {
            InputStream in = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder str = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                str.append(line + "\n");
            }
            in.close();
            result = str.toString();
        } catch(Exception ex) {
            result = "Error";
            ex.printStackTrace();
        }
        return result;
    }
}