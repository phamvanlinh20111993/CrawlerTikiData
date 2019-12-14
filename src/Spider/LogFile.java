package Spider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import IOFile.ConvertObjectToJson;
import IOFile.IOFileImpl;
import Model.TikiData;

public class LogFile extends IOFileImpl {

    private volatile static LogFile logFile;

    private ConvertObjectToJson convertObjectToJson;

    // reference: https://www.geeksforgeeks.org/singleton-design-pattern/
    public static LogFile getInstance() {
        if (logFile == null) {
            // To make thread safe
            synchronized (LogFile.class) {
                // check again as multiple threads
                // can reach above step
                if (logFile == null)
                    logFile = new LogFile();
            }
        }
        return logFile;
    }

    private LogFile() {
        this.convertObjectToJson = ConvertObjectToJson.getInstanceObject();
        this.createPathFile(super.getPathFile() + "\\Data");
        // create file
        this.createFile(this.getPathFile(), this.getLogErrorFile());
        this.createFile(this.getPathFile(), this.getListUrlCrawl());
        this.createFile(this.getPathFile(), this.getStorageProductFile());
        this.createFile(this.getPathFile(), this.getProductAndCategoryFile());
        // clear file
        this.clearDataInFile(this.getPathFile(), this.getStorageProductFile());
        this.clearDataInFile(this.getPathFile(), this.getProductAndCategoryFile());
        this.clearDataInFile(this.getPathFile(), this.getListUrlCrawl());
        this.clearDataInFile(this.getPathFile(), this.getLogErrorFile());
    }

    /**
     * 
     * @param data
     */
    public void writeInLogErrorFile(String data) {
        this.writeToFile(getPathFile(), this.getLogErrorFile(), data);
    }

    /**
     * 
     * @param data
     */
    public void writeInListUrlCrawlFile(String path, String data) {
        this.writeToFile(path, this.getListUrlCrawl(), data);
    }

    /**
     * 
     * @param data
     */
    public void writeInLogErrorFile(String path, String data) {
        this.writeToFile(path, this.getLogErrorFile(), data);
    }

    /**
     * 
     * @param data
     */
    public void writeInListUrlCrawlFile(String data) {
        this.writeToFile(getPathFile(), this.getListUrlCrawl(), data);
    }

    /**
     * 
     * @param data
     */
    public void writeInStorageProductFile(Object data) {
        String json = convertObjectToJson.convertObjectToPrettyJson(data);
        this.writeToFile(getPathFile(), this.getStorageProductFile(), json);
    }

    /**
     * 
     * @param data
     */
    public void writeInStorageProductFile(String path, Object data) {
        String json = convertObjectToJson.convertObjectToPrettyJson(data);
        this.writeToFile(path, this.getStorageProductFile(), json);
    }

    /**
     * 
     * @param type
     */
    public String returnListProductByTypePath(String type) {
        // create if not exist
        this.createPathFile(this.getPathFile());

        String pathType = this.getPathFile() + "\\" + type;
        this.createPathFile(pathType);
        pathType += "\\";
        // create file
        this.createFile(pathType, this.getLogErrorFile());
        this.createFile(pathType, this.getListUrlCrawl());
        this.createFile(pathType, this.getStorageProductFile());

        return pathType;
    }

    @Override
    public String getPathFile() {
        return super.getPathFile() + "\\Data\\Day-" + this.getCurrentDateDDMMYYYY() + "\\";
    }

    /**
     * 
     * @param data
     */
    public void writeInProductAndCategoryFile(List<TikiData> data) {
        String json = convertObjectToJson.convertObjectToPrettyJson(data);
        this.writeToFile(getPathFile(), this.getProductAndCategoryFile(), json);
    }

    private String getCurrentDateDDMMYYYY() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    private String getLogErrorFile() {
        return "LogErrorFile_" + this.getCurrentDateDDMMYYYY();
    }

    private String getListUrlCrawl() {
        return "ListUrl_" + this.getCurrentDateDDMMYYYY();
    }

    private String getStorageProductFile() {
        return "TikiData_" + this.getCurrentDateDDMMYYYY();
    }

    private String getProductAndCategoryFile() {
        return "TikiDataJson_" + this.getCurrentDateDDMMYYYY();
    }

}
