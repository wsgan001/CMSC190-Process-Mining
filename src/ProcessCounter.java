import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class ProcessCounter {
	public ProcessCounter() throws IOException {
		for(int i = 1; i<=15; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			File file_path;
	 		if(i < 10) file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/DATA FILTERED/0" + i + ".csv");
	 		else file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/DATA FILTERED/" + i + ".csv");
	 		
			BufferedReader br = new BufferedReader(new FileReader(file_path));
			
			int line_number = 0;
			String line = null;
			
			System.out.println("======" + i + ".csv" + "=====================================");			
			
			while((line = br.readLine()) != null) {
				String []  tokens = line.split(",");
				try {
					if(map.containsKey(tokens[2])) map.put(tokens[2], map.get(tokens[2]) + 1);
					else map.put(tokens[2], 1);
				} catch (Exception e) {
					System.out.println(line_number);
				}
				line_number++;
			}
			br.close();
			
			Iterator<String> keySetIterator = map.keySet().iterator();

			while(keySetIterator.hasNext()){
			  String key = keySetIterator.next();			  
			  System.out.println(key + " " + map.get(key));			
			}
			
			System.out.println("==================================================");			
		}
	}
	
	public static void main(String[] args) throws IOException {
		new ProcessCounter();
	}
}
