import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Parser extends JFrame {
	HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
	
	public Parser() {
		JButton openFile = new JButton("Choose File");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readTextFile();
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(openFile);
		
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	// this method reads the chosen text file and stores the data into an arraylist
	private void readTextFile() {
		// opens a dialog box to facilitate file choosing
		JFileChooser fileChooser = new JFileChooser();
		
		// default directory will be the user's desktop
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		
		int result = fileChooser.showOpenDialog(this);
		
		// if the file to be opened successfully opens
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    String filePath = selectedFile.getAbsolutePath();
		    
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				
				String line = null;
				int i = 1;
				
				ArrayList<String> data = new ArrayList<String>();
				
				// reads the feature vectors
				while((line = br.readLine()) != null) {					
					String[] tokens = line.split(",");
					try {
						if(dictionary.containsKey(tokens[2])) dictionary.put(tokens[2], dictionary.get(tokens[2]) + 1);
						else dictionary.put(tokens[2], 1);
					} catch (Exception e) {
//						e.printStackTrace();
						System.out.println(i);
						break;
					}
					
					i++;
					
//					data.add(tokens[0] + "," + tokens[1] + "," + tokens[2] + "," + tokens[3]);
				}

//				// writes the answer to output.txt
//				FileWriter writer;
//				BufferedWriter bufferedWriter;
//				try {
//					writer = new FileWriter("output.csv");
//					bufferedWriter = new BufferedWriter(writer);
//					
//					for(int i1 = 0; i1<data.size(); i1++) {
//						bufferedWriter.write(data.get(i1));
//						bufferedWriter.newLine();
//					}
//					
//					bufferedWriter.close();
//					System.out.println("DONE");
//				} catch(IOException e1) {
//					e1.printStackTrace();
//				}
				
				// iterates through the dictionary until all words have been exhausted
				Iterator<String> keySetIterator = dictionary.keySet().iterator();
				
				int counter = 1;
				
				while(keySetIterator.hasNext()){
				  String key = keySetIterator.next();
				  
				  System.out.println(counter + " " + key + " " + dictionary.get(key));
				
				  counter++;
				}

			} catch (FileNotFoundException e) {
				System.out.println("Error: File Not Found!");
			} catch (IOException e) {
				System.out.println("Error: There is an error in the input file.");
			}
		}
	}
	
	public static void main(String[] args) {
		new Parser();
	}
}
