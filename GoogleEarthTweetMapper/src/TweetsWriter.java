import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TweetsWriter {
	
	public static void main(String[] args) {
		
		File file = new File("Twitter.kml");
		try { 
            BufferedReader reader = new BufferedReader(new FileReader("E:\\Graduate_major\\Salzburg\\basic software development\\GoogleEarthTweetMapper\\twitter.csv"));
            reader.readLine();
            String line; 
            
            file.createNewFile();
  	      	// creates a FileWriter Object
			FileWriter writer = new FileWriter(file);
			
            String kml_file = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					 +"<kml xmlns=\"http://earth.google.com/kml/2.1\">\r\n"  
					 +"xmlns=\"http://www.opengis.net/kml/2.2\"\r\n"
					 +"<Document>\r\n";
            while((line=reader.readLine())!=null){ 
                String item[] = line.split(";");
                        
                kml_file += "<Placemark>\r\n"
   					 + "<description>"+item[5]+"Create at:"+item[6]+"</description>\r\n"
   					 + "<Point>\r\n"
   					 + "<coordinates>"+item[1]+","+item[2]+"</coordinates>\r\n"
   					 + "</Point>\r\n"
   					 + "</Placemark>\r\n";
            } 
            reader.close();
            
            kml_file += "</Document>\r\n" + 
		      		"</kml>\r\n" + 
		      		""; 
            writer.write(kml_file); 
		    writer.flush();
		    writer.close();		    
            		
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
		
		String[] cmd = new String[2];
		cmd[0] = "C:\\Program Files\\Google\\Google Earth Pro\\client\\googleearth.exe";
		cmd[1] = "E:\\Graduate_major\\Salzburg\\basic software development\\GoogleEarthTweetMapper\\Twitter.kml";
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    } 

}



 