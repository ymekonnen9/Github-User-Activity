import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GithubUserActivity{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    String[] inputArray = input.split(" ");
   
    try{
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
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
    }
    } catch(Exception e){
      System.out.println("Exception in GithubActivity" + e.getMessage());
    }    
    scanner.close();
  }



}