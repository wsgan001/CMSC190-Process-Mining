import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataDelimeter {
	public DataDelimeter() throws IOException {
		ArrayList<String> processes = new ArrayList<String>(Arrays.asList("get_basic_student_info","update_role","get_waitlisted","enlist_with_nstp_filter","admin_update_password","get_student_info",
																		  "retrieve_all_module","send_problem","has_finalized","cancel_waitlist","waitlist_with_nstp_filter","create_announcement","get_roles",
																		  "finalize","login","get_degrees","get_curriculums","toggle_site_status","waitlist","add_recommended_courses","enlist","search_course_offerings",
																		  "update_email","get_recommended_courses","get_classlist","add_student","is_straggler","retrieve_menu_by_id","change_allowed_units",
																		  "add_slot_up_waitlist","retrieve_all_menu","search_student","get_student_problems","toggle_straggler","get_reserved","cancel_corequisite",
																		  "get_problems","get_course_offerings","get_colleges","get_checklist","cancel_slot","create_student_account","swap_section_with_nstp_filter",
																		  "change_role","logout","get_ps_form","get_waitlisted_courses","add_role","get_section_info"));
		
		for(int i = 1; i<=15; i++) {
			ArrayList<String> data = new ArrayList<String>();
			
			File file_path;
	 		if(i < 10) file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-TO-FILTER/0" + i + ".csv");
	 		else file_path = new File(System.getProperty("user.home") + "/Desktop/DATA-TO-FILTER/" + i + ".csv");
	 		
			BufferedReader br = new BufferedReader(new FileReader(file_path));
			
			String line = null;						
			while((line = br.readLine()) != null) {
				String []  tokens = line.split(",");				
				try {
					if(processes.contains(tokens[2].trim())) data.add(tokens[0].trim() + "," + tokens[1].trim() + "," + tokens[2].trim() + "," + tokens[3].trim());
				} catch (Exception e) {}
			}
			br.close();
			
			FileWriter writer;
			BufferedWriter bufferedWriter;
			
			String filename = (i < 10)?  "0" + i + ".csv" : i + ".csv";
			try {
				writer = new FileWriter(new File(System.getProperty("user.home") + "/Desktop/DATA-FILTERED" ,filename));
				bufferedWriter = new BufferedWriter(writer);
				
				for(int i1 = 0; i1<data.size(); i1++) {
					bufferedWriter.write(data.get(i1));
					bufferedWriter.newLine();
				}
				
				bufferedWriter.close();
				System.out.println(filename + "  done! " + data.size());

			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new DataDelimeter();
	}
}
