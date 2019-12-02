package IOFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOFileImpl implements IOFile{
	
	private Path currentRelativePath;
	private File file;

	/**
	 * 
	 */
	public IOFileImpl() {
		this.currentRelativePath = Paths.get("");
	}

	/**
	 * 
	 * @param name
	 */
	public IOFileImpl(String name) {
		this.currentRelativePath = Paths.get("");
	}
	
	/**
	 * 
	 * @param path
	 * @param name
	 * @param data
	 */
	public void writeToFile(String path, String name, String data) {

		String pathName = this.getPathFile() + "\\" + path + name;
		this.file = new File(pathName);

		if (file.exists() && !file.isDirectory()) {
			// do something
			try {
				OutputStream outputStream = new FileOutputStream(file, true); 
				OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
				// BufferedWriter out = new BufferedWriter(writer);
				writer.write("\n");
				writer.write(data);
				writer.write("\n");
				// out.newLine();
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void clearDataInFile(String path, String name) {

		String pathName = this.getPathFile() + "\\" + path + name;
		this.file = new File(pathName);

		if (file.exists() && !file.isDirectory()) {
			PrintWriter writer;
			try {
				writer = new PrintWriter(file);
				writer.print("");
				writer.close();

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String[] readDataFile(String name, String path) {

		String pathName = this.getPathFile() + "\\" + path + name;
		this.file = new File(pathName);

		ArrayList<String> outP = new ArrayList<>();
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
				outP.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}

		return outP.toArray(new String[outP.size()]);
	}

	/**
	 * 
	 * @param name
	 */
	public void createFile(String path, String name) {
		String pathName = this.getPathFile() + "\\";
		this.file = new File(pathName);
		// Create the file
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getPathFile() {
		return currentRelativePath.toAbsolutePath().toString();
	}
}

