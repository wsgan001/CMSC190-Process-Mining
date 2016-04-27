import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBuilder {

	public DataBuilder(double first_half, double second_half, int total_data_points) throws IOException {
		int first_half_number = (int) ((int) total_data_points * first_half);
		int second_half_number = total_data_points - first_half_number;
		
		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED/data.csv");
		BufferedReader br = new BufferedReader(new FileReader(file_path));
		
		FileWriter writer_first_half = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED" , "data-model.csv"));
		BufferedWriter bw_first_half = new BufferedWriter(writer_first_half);

		FileWriter writer_second_half = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED" , "data-test.csv"));
		BufferedWriter bw_second_half = new BufferedWriter(writer_second_half);
		
		String line = null;
		int line_counter = 0;
		while((line = br.readLine()) != null) {
			if(line_counter < first_half_number) {
				bw_first_half.write(line);
				bw_first_half.newLine();
			}
			
			else {
				bw_second_half.write(line);
				bw_second_half.newLine();
			}
			
			line_counter++;
		}
				
		System.out.println("[DATA BUILDER] Model Data and Test Data have been built.");
		
		br.close();
		bw_first_half.close();
		bw_second_half.close();
	}
	
	public DataBuilder(int k) throws IOException {
		ArrayList<String> data = new ArrayList<String>();		
		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED/data.csv");
		BufferedReader br = new BufferedReader(new FileReader(file_path));
		
		String line = null;
		while((line = br.readLine()) != null) {
			data.add(line);
		}
		
		br.close();
		
		int size_of_each_block = data.size()/k;
		
		for(int i = 1; i<=k; i++) {
			FileWriter model_writer = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED" , "data-" + i + "-model.csv"));
			BufferedWriter bw_model = new BufferedWriter(model_writer);

			FileWriter data_writer = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-STITCHED" , "data-" + i + "-test.csv"));
			BufferedWriter bw_data = new BufferedWriter(data_writer);
			
			for(int j = 0; j<data.size(); j++) {
				if((j >= (size_of_each_block * (i-1))) && (j < (size_of_each_block * i))) {
					bw_data.write(data.get(j));
					bw_data.newLine();
				}
				
				else {
					bw_model.write(data.get(j));
					bw_model.newLine();
				}
			}
			
			System.out.println("[DATA BUILDER] data-"+ i +"-model.csv written!");
			System.out.println("[DATA BUILDER] data-"+ i +"-test.csv written!");
			
			bw_model.close();
			bw_data.close();
		}	
	}
}
