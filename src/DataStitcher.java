import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataStitcher {
	int total_data = 0;
	
	public DataStitcher() throws IOException {
		int no_of_files = 4;
		
		for(int i = 1; i<=no_of_files; i++) {
			ArrayList<String> data = new ArrayList<String>();
			
			File file_path;
	 		if(i < 10) file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-FILTERED/0" + i + ".csv");
	 		else file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-FILTERED/" + i + ".csv");
	 		
			BufferedReader br = new BufferedReader(new FileReader(file_path));
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				String []  tokens = line.split(",");				
				data.add(tokens[0].trim() + "," + tokens[1].trim() + "," + tokens[2].trim() + "," + tokens[3].trim());
			}
			
			br.close();
			
			FileWriter writer;
			BufferedWriter bufferedWriter;
			
			String filename = "data.csv";
			
			writer = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED" ,filename), true);
			bufferedWriter = new BufferedWriter(writer);

			for(int j = 0; j<data.size(); j++) {
				bufferedWriter.write(data.get(j));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			
			total_data += data.size();
			
			System.out.println(file_path.getName() + " has been stiched to data.csv.");
		}
		
		System.out.println("Stitching Complete!");
		System.out.println("Total Data: " + total_data);
		System.out.println("70% of Total Data: " + (total_data*0.7));
		System.out.println("30% of Total Data: " + (total_data*0.3));
	}
}
