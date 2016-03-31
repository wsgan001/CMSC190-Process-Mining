import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LineFilter {
	public LineFilter() throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<Integer> threshold = new ArrayList<Integer>();
		
		for(int i = 1; i<=31; i++) {
			try {
		 		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/2015 01 (JANUARY)/D-2015-1-"+ i +".log");
				BufferedReader br = new BufferedReader(new FileReader(file_path));
				
				String line = null, filtered_line = null;
				while((line = br.readLine()) != null) {
					filtered_line = line.replaceAll("\\|", ",");
					data.add(filtered_line);
				}
				
				threshold.add(data.size());
			} catch(IOException e) {
				continue;
			}
		}
		
		try {
			FileWriter writer = new FileWriter("output.csv");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			for(int i = 0; i<data.size(); i++) {
				bufferedWriter.write("2015-01-"+ (i+1) + " " + data.get(i));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			
			System.out.println("DONE");
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new LineFilter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
