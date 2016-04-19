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
		double percentage_to_trim = 0.54;
		
//		String folder_name = "2014 11 (NOVEMBER)";
//		int year = 2014;
//		int month = 11;
//		String output_filename = "01.csv";

//		String folder_name = "2014 12 (DECEMBER)";
//		int year = 2014;
//		int month = 12;
//		String output_filename = "02.csv";

		String folder_name = "2015 01 (JANUARY)";
		int year = 2015;
		int month = 1;
		String output_filename = "03.csv";

//		String folder_name = "2015 02 (FEBRUARY)";
//		int year = 2015;
//		int month = 2;
//		String output_filename = "04.csv";

//		String folder_name = "2015 03 (MARCH)";
//		int year = 2015;
//		int month = 3;
//		String output_filename = "05.csv";

//		String folder_name = "2015 04 (APRIL)";
//		int year = 2015;
//		int month = 4;
//		String output_filename = "06.csv";
				
//		String folder_name = "2015 05 (MAY)";
//		int year = 2015;
//		int month = 5;
//		String output_filename = "07.csv";

//		String folder_name = "2015 06 (JUNE)";
//		int year = 2015;
//		int month = 6;
//		String output_filename = "08.csv";

//		String folder_name = "2015 07 (JULY)";
//		int year = 2015;
//		int month = 7;
//		String output_filename = "09.csv";

//		String folder_name = "2015 08 (AUGUST)";
//		int year = 2015;
//		int month = 8;
//		String output_filename = "10.csv";

//		String folder_name = "2015 09 (SEPTEMBER)";
//		int year = 2015;
//		int month = 9;
//		String output_filename = "11.csv";

//		String folder_name = "2015 10 (OCTOBER)";
//		int year = 2015;
//		int month = 10;
//		String output_filename = "12.csv";

//		String folder_name = "2015 11 (NOVEMBER)";
//		int year = 2015;
//		int month = 11;
//		String output_filename = "13.csv";

//		String folder_name = "2015 12 (DECEMBER)";
//		int year = 2015;
//		int month = 12;
//		String output_filename = "14.csv";

//		String folder_name = "2016 01 (JANUARY)";
//		int year = 2016;
//		int month = 1;
//		String output_filename = "15.csv";
		
		for(int i = 1; i<=31; i++) {
			try {
		 		File file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/"+ folder_name +"/D-"+ year +"-" + month +"-"+ i +".log");
				BufferedReader br = new BufferedReader(new FileReader(file_path));
				
				String line = null, filtered_line = null;
				ArrayList<String> temp = new ArrayList<String>();
				
				while((line = br.readLine()) != null) {
					filtered_line = line.replaceAll("\\|", ",");
					temp.add(filtered_line);
				}
				
				int counter = 1;
				int number_of_data_to_remove = (int) (temp.size() * percentage_to_trim);
				while(counter <= number_of_data_to_remove) {
					int index_to_remove = (int) (Math.random()*temp.size());
					temp.remove(index_to_remove);
					counter++;
				}
				
				data.addAll(temp);
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
			
			System.out.println(output_filename + " HAS BEEN SAVED!");
			
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		new LineFilter();
	}
}
