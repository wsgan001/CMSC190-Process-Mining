import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;

public class DataConverter {
	 /**
	 * takes 2 arguments:
	 * - CSV input file
	 * - ARFF output file
	 * @param sourcepath
	 * @param destpath
	 * @throws java.lang.Exception
	 */
	public static void Convert(String sourcepath, String destpath) throws Exception {
		 // load CSV
		 CSVLoader loader = new CSVLoader();
		 loader.setSource(new File(sourcepath));
		 Instances data = loader.getDataSet();
		
		 // save ARFF
		 ArffSaver saver = new ArffSaver();
		 saver.setInstances(data);
		 saver.setFile(new File(destpath));
		
		 saver.writeBatch();
	 }
	 
	 public static void main(String args[]) throws Exception {
		 Convert("C:\\Users\\isaganimarquez\\Desktop\\DATA-PROGRESS\\06 - 04-24-2016\\data.csv", "C:\\Users\\isaganimarquez\\Desktop\\DATA-PROGRESS\\06 - 04-24-2016\\gy.arff");
	
	 }
}