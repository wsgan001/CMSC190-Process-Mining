
public class RawData {
	String folder_name;
	int year;
	int month;
	String output_filename;
	
	public RawData() {}
	
	public RawData(String folder_name, int year, int month, String output_filename) {
		this.folder_name = folder_name;
		this.year = year;
		this.month = month;
		this.output_filename = output_filename;
	}
}
