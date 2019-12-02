package IOFile;

public interface IOFile {
	/**
	 * 
	 * @param path
	 * @param name
	 * @param data
	 */
	public void writeToFile(String path, String name, String data);
	
	/**
	 * 
	 * @param path
	 * @param name
	 */
	public void clearDataInFile(String path, String name);
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @return
	 */
	public String[] readDataFile(String name, String path);
	
	/**
	 * 
	 * @param path
	 * @param name
	 */
	public void createFile(String path, String name);
}
