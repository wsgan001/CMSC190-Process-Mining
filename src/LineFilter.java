import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LineFilter {
	public LineFilter() throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		String folder_name = "2016 01 (JANUARY)";
		int year = 2016;
		int month = 1;
		String output_filename = "15.csv";
		
		for(int i = 1; i<=31; i++) {
			try {
		 		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/"+ folder_name +"/D-"+ year +"-" + month +"-"+ i +".log");
				BufferedReader br = new BufferedReader(new FileReader(file_path));
				
				String line = null, filtered_line = null;
				while((line = br.readLine()) != null) {
					filtered_line = line.replaceAll("\\|", ",");
					data.add(filtered_line);
				}
				
				map.put(i, data.size());
				br.close();
			} catch(IOException e) {
				continue;
			}
		}
		
		ArrayList<Integer> key = new ArrayList<Integer>(map.keySet());
		Collections.sort(key);
		
		try {
			FileWriter writer = new FileWriter(output_filename);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			int start = 0, end = 0;
			String date;
			
			for(int j = 0; j<key.size(); j++) {
				start = end;
				end = map.get(key.get(j));
				date = year + "-" + month + "-" + key.get(j).toString();
				
				for(int i = start; i<end; i++) {
					bufferedWriter.write(date + " " + data.get(i));
					bufferedWriter.newLine();
				}
			}
				
			bufferedWriter.close();
			
			System.out.println("DONE");
			
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		new LineFilter();
	}
}
