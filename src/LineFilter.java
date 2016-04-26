import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LineFilter {
	double percentage_to_trim;
	
	public LineFilter(double percent) throws IOException {
		this.percentage_to_trim = percent;
		ArrayList<RawData> files = new ArrayList<RawData>(Arrays.asList(new RawData("2014 11 (NOVEMBER)", 2014, 11, "01.csv"),
																		new RawData("2014 12 (DECEMBER)", 2014, 12, "02.csv"),
																		new RawData("2015 01 (JANUARY)", 2015, 1, "03.csv"),
																		new RawData("2015 02 (FEBRUARY)", 2015, 2, "04.csv"),
																		new RawData("2015 03 (MARCH)", 2015, 3, "05.csv"),
																		new RawData("2015 04 (APRIL)", 2015, 4, "06.csv"),
																		new RawData("2015 05 (MAY)", 2015, 5, "07.csv"),
																		new RawData("2015 06 (JUNE)", 2015, 6, "08.csv"),
																		new RawData("2015 07 (JULY)", 2015, 7, "09.csv"),
																		new RawData("2015 08 (AUGUST)", 2015, 8, "10.csv"),
																		new RawData("2015 09 (SEPTEMBER)", 2015, 9, "11.csv"),
																		new RawData("2015 10 (OCTOBER)", 2015, 10, "12.csv"),
																		new RawData("2015 11 (NOVEMBER)", 2015, 11, "13.csv"),
																		new RawData("2015 12 (DECEMBER)", 2015, 12, "14.csv"),
																		new RawData("2016 01 (JANUARY)", 2016, 1, "15.csv")
																		));

		for (RawData file : files) {
			ArrayList<String> data = new ArrayList<String>();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int i = 1; i<=31; i++) {
				try {
			 		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-RAW/"+ file.folder_name +"/D-"+ file.year +"-" + file.month +"-"+ i +".log");
					BufferedReader br = new BufferedReader(new FileReader(file_path));
					
					String line = null, filtered_line = null;
					ArrayList<String> temp = new ArrayList<String>();
					
					while((line = br.readLine()) != null) {
						filtered_line = line.replaceAll("\\|", ",");
						temp.add(filtered_line);
					}
					
					int counter = 1;
					int number_of_data_to_remove = (int) (temp.size() * this.percentage_to_trim);

					while(counter <= number_of_data_to_remove) {
						int index_to_remove = (int) (Math.random()*temp.size());
						temp.remove(index_to_remove);
						counter++;
					}
					
					data.addAll(temp);
					map.put(i, data.size());
					
					br.close();
				} catch(IOException e) {
//					e.printStackTrace();
					continue;
				}
			}
			
			ArrayList<Integer> key = new ArrayList<Integer>(map.keySet());
			Collections.sort(key);
			
			try {
				FileWriter writer = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-TO-FILTER", file.output_filename));
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				
				int start = 0, end = 0;
				String date;
				
				for(int j = 0; j<key.size(); j++) {
					start = end;
					end = map.get(key.get(j));
					date = file.year + "-" + file.month + "-" + key.get(j).toString();
					
					for(int i = start; i<end; i++) {
						bufferedWriter.write(date + " " + data.get(i));
						bufferedWriter.newLine();
					}
				}
					
				bufferedWriter.close();
				
				System.out.println( "[LINE FILTER] " + file.output_filename + " has been saved! " + data.size());
				
			} catch(IOException e) {
//				e.printStackTrace();
			}
		}		
	}
}
