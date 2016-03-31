import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataDelimeter {
	public DataDelimeter() throws IOException {
		for(int i = 1; i<=15; i++) {
			ArrayList<String> data = new ArrayList<String>();
			
			File file_path;
	 		if(i < 10) file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/DATA FILTERED/0" + i + ".csv");
	 		else file_path = new File(System.getProperty("user.home") + "/Desktop/DATA/DATA FILTERED/" + i + ".csv");
	 		
			BufferedReader br = new BufferedReader(new FileReader(file_path));
			
			String line = null;
			int line_number = 1;
						
			while((line = br.readLine()) != null) {
				String []  tokens = line.split(",");				
				try {
					if(
						(i == 3) &&
						(
							!("no".equals(tokens[2].trim())) &&  !("121.54.54.170".equals(tokens[2].trim())) &&
							!("121.54.54.171".equals(tokens[2].trim())) &&  !("121.54.54.172".equals(tokens[2].trim())) &&
							!("121.54.54.248".equals(tokens[2].trim())) &&  !("121.54.54.173".equals(tokens[2].trim())) &&
							!("127.0.0.1".equals(tokens[2].trim())) &&  !("202.57.45.202".equals(tokens[2].trim())) &&
							!("proceed to your respective OCS (except CAS".equals(tokens[2].trim())) &&  !("ALL".equals(tokens[2].trim())) &&
							!("121.54.54.238".equals(tokens[2].trim())) &&  !("your mini-checklist should reflect the changes that you specified in your plan of study or in your GE plan provided that they were submitted on or before the set deadline.<br/><br/>".equals(tokens[2].trim())) &&
							!("121.54.54.237".equals(tokens[2].trim())) &&  !("121.54.54.239".equals(tokens[2].trim())) &&
							!("121.54.54.236".equals(tokens[2].trim())) &&  !("202.92.144.252".equals(tokens[2].trim())) &&
							!("121.54.54.11".equals(tokens[2].trim())) &&  !("49.150.204.9".equals(tokens[2].trim())) &&
							!("121.54.54.250".equals(tokens[2].trim())) &&  !("121.54.54.227".equals(tokens[2].trim())) &&
							!("get_recommended7:22:59".equals(tokens[2].trim())) &&  !("121.54.54.169".equals(tokens[2].trim())) &&
							!("10.0.0.1".equals(tokens[2].trim())) &&  !("121.54.54.168".equals(tokens[2].trim())) &&
							!("and swap starting 9AM on January 19 (Mon). The online registration will end at 12NN on January 23 (Friday). The SystemOne DevTeam MIGHT enable Stragglers Time this semester; we will update the mechanics within the week of the online registration.".equals(tokens[2].trim())) &&  !("121.54.54.251".equals(tokens[2].trim()))
						)
					   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 6) &&
							(
								!("121.54.54.174".equals(tokens[2].trim())) &&  !("202.92.144.252".equals(tokens[2].trim())) &&
								!("121.54.54.170".equals(tokens[2].trim())) &&  !("121.54.54.172".equals(tokens[2].trim())) &&
								!("PE _-%".equals(tokens[2].trim())) &&  !("121.54.54.250".equals(tokens[2].trim())) &&
								!("Problem sent.".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 8) &&
							(
								!("plano ko sana i-retake sya ngayong mid year kaso wala siya sa recommended courses ko. Salamat!".equals(tokens[2].trim())) &&  !("202.92.144.252".equals(tokens[2].trim())) &&
								!("192.168.0.63".equals(tokens[2].trim())) &&  !("127.0.0.1".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 10) &&
							(
								!("202.92.144.252".equals(tokens[2].trim())) &&  !("141.0.12.211".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
							
					else if(
							(i == 11 || i == 12 || i == 7) &&
							(
								!("202.92.144.252".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 13) &&
							(
								!("202.92.144.252".equals(tokens[2].trim())) &&  !("172.16.4.0".equals(tokens[2].trim())) &&
								!("PE _-%".equals(tokens[2].trim())) &&  !("Problem sent.".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 14) &&
							(
								!("172.16.20.1".equals(tokens[2].trim())) &&  !("202.92.144.252".equals(tokens[2].trim())) &&
								!("172.16.6.1".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else if(
							(i == 15) &&
							(
								!("127.0.0.1".equals(tokens[2].trim())) &&  !("202.92.144.252".equals(tokens[2].trim()))
							)
						   ) data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					else data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
					
					line_number++;
			} catch (Exception e) {
				System.out.println(line_number + "  " + line);	
				e.printStackTrace();
				}
			}
			br.close();
			
			FileWriter writer;
			BufferedWriter bufferedWriter;
			
			String filename = null;
			
			if(i < 10) filename = "0" + i + ".csv";
			else filename = i + ".csv";
			
			try {
				writer = new FileWriter(filename);
				bufferedWriter = new BufferedWriter(writer);
				
				for(int i1 = 0; i1<data.size(); i1++) {
					bufferedWriter.write(data.get(i1));
					bufferedWriter.newLine();
				}
				
				bufferedWriter.close();
				System.out.println(filename + "  DONE");

			} catch(IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		new DataDelimeter();
	}
}
