import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ProcessIdentifier {
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		BufferedReader br = new BufferedReader(new FileReader(new File("processes.txt")));
		
		String line = null;				
		while((line = br.readLine()) != null) {
			if(map.containsKey(line.trim())) map.put(line.trim(), map.get(line.trim()) + 1);
			else map.put(line.trim(), 1);
		}
		
		br.close();
		
		Iterator<String> keySetIterator = map.keySet().iterator();
		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();			  
		  System.out.println(key + " " + map.get(key));
		}
	}
}
