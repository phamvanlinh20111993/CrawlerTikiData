package IOFile;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Model.TikiData;

/**
 * 
 * @author PhamVanLinh
 *
 */
public class ConvertObjectToJson {
    
    private volatile static ConvertObjectToJson convertObjectToJson;
    
    public static ConvertObjectToJson getInstanceObject() {
        if(convertObjectToJson == null) {
            synchronized (ConvertObjectToJson.class) {
                if(convertObjectToJson == null)
                    return new ConvertObjectToJson();
            }
        }
        
        return convertObjectToJson;
    }
    
    private ConvertObjectToJson() {}
	/**
	 * 
	 * @param list
	 * @return
	 */
	public String convertListObjectToPrettyJson(List<TikiData> list) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(list);
		return prettyJson;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public String convertListObjectToJson(List<TikiData> list) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObject = gson.toJson(list);
		return JSONObject;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public String convertObjectToPrettyJson(Object data) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(data);
		return prettyJson;
	}
}

