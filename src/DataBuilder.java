import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
}
