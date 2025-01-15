package com.gtihubuseractivity.src.main.java.com.gtihubuseractivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GithubUserActivity{
  public static void main(String[] args) {

    try{
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      String[] inputArray = input.split(" ");
      scanner.close();

      if(inputArray[0].equals("github-activity") && inputArray[1] != null){

      URL url = new URL("https://api.github.com/users/"+inputArray[1]+"/events");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      
      if (conn.getResponseCode() != 200) {
          throw new RuntimeException("Failed : HTTP Error code : "
                  + conn.getResponseCode());
      }
      
      InputStreamReader in = new InputStreamReader(conn.getInputStream());
      BufferedReader br = new BufferedReader(in);
      String output;

      // while ((output = br.readLine()) != null) {
      //     System.out.println(output);
      // }
      output = br.readLine();
      // output = output.substring(1, output.length()-1);

      String jsonString = output ; //assign your JSON String here
      JSONArray arr = new JSONArray(jsonString);
      // System.out.println(arr.toString());
      // String pageName = obj.getJSONObject("payload").getString("commits");
      
       // notice that `"posts": [...]`
       System.out.println(arr.length());
       System.out.println(arr.getClass().getName());

      // for(JSONArray jsonArr: (JSONArray)arr){
      //             JSONObject payload = jsonArr.getJSONObject("payload");
      //     JSONArray commits = payload.getJSONArray("commits");

      //     if(commits == null){
      //       continue;
      //     }

      //     for (int j = 0; j < commits.length(); j++)
      //       {
      //         JSONObject commitObj = commits.getJSONObject(j);
      //         String message = commitObj.getString("message");
      //         System.out.println(message);
      //       }
      // }

      
      for(int i = 0; i< arr.length(); i++){
        JSONObject jsonObject = arr.getJSONObject(i);
        System.out.println('\n');

        JSONObject payload = jsonObject.getJSONObject("payload");
        System.out.println(payload.toString());
      
      
      }




      // for (int i = 0; i < arr.length(); i++)
      // {
      //     Object obj = arr.get(i);

      //     Object payload = obj.get;
      //     JSONArray commits = payload.getJSONArray("commits");

      //     if(commits == null){
      //       continue;
      //     }

      //     for (int j = 0; j < commits.length(); j++)
      //       {
      //         JSONObject commitObj = commits.getJSONObject(j);
      //         String message = commitObj.getString("message");
      //         System.out.println(message);
      //       }
      // }
    
    } }
    catch(Exception e){
      System.out.println("Exception in GithubActivity " + e.getMessage());
    }    
  
    

}

}