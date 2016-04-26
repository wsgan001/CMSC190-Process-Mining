import java.io.IOException;

public class Runner {
	public static void main(String[] args) throws IOException {
		new LineFilter(0.75);
		new DataDelimeter();
		int total_data =  new DataStitcher().total_data;
		new DataBuilder(0.70, 0.30, total_data);
	}
}
