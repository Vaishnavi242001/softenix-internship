import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
public class Weatherforecastapp {
	
   private static JFrame frame;
   private static JTextField LocationField;
   private static JTextArea weatherdisplay;
   private static  JButton fetchButton;
   
   private static String apiKey="7324195cc417e096866112c74ce56ea9";
	
    private static String fetchWeatherdata(String city) {
        try {
        	
        URL url=new URL("http://api.openweathermap.org/data/2.5/weather?"+"appid=" + apiKey + "&q=" + city);
        HttpURLConnection  connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response="";
        String line;
        while((line=reader.readLine())!=null) {
        	response+=line;
        }
        reader.close();
        JSONObject jsonObject=(JSONObject) JSONValue.parse(response.toString());
        JSONObject mainObj=(JSONObject) jsonObject.get("main");
       Double temperatureKelvin = (Double)mainObj.get("temp");
     
        
        Long humidity=(Long)mainObj.get("humidity");
        
        
      
        JSONArray weatherArray=(JSONArray)jsonObject.get("weather");
        JSONObject weather=(JSONObject)weatherArray.get(0);
        String description=(String)weather.get("description");
         return"description:"+description+"\n temperature:"+temperatureKelvin+"kelvin\n humidity"+humidity+"%";
        		
        } catch(Exception e) {
        	return "FAILED TO FETCH THE WEATHER DATA. PLEASE CHECK YOUR CITY...";
        }
    
    	
    }

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          frame= new JFrame("weather forecast app");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 600);
         frame.setLocationRelativeTo(null);
         frame.setLayout(new FlowLayout());
         
          LocationField=new JTextField(15);
          fetchButton= new JButton("fetch weather");
          weatherdisplay= new JTextArea(10,30);
         weatherdisplay.setEditable(false);
         frame.add(new JLabel("enter the city name"));
         frame.add(LocationField);
         frame.add(weatherdisplay);
         frame.add(fetchButton);
      
         
         fetchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String city=LocationField.getText();
				String weatherinfo=fetchWeatherdata(city);
				weatherdisplay.setText(weatherinfo);
				
			}
         });
         frame.setVisible(true);
}




	
}

        
         
         
         
         


