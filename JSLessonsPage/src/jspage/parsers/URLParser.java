package jspage.parsers;

import org.json.JSONObject;

public class URLParser {

	 public static String createURL(String queryAuthor) {
	     
	        
	        JSONObject object = new JSONObject(queryAuthor);
	        JSONObject result = null;
	        if(object.has("result")){
	               result = object.getJSONObject("result");
	        }else{
	            return null;
	        }
	      
	        return result.getString("url".replace("\\/", "\\\\"));
	    }
	
	
}
