package jspage.parsers;

import org.json.JSONObject;

import jspage.bean.Author;

public class AuthorParser {

    public static Author createAuthor(String queryAuthor) {
  
    //  {"ok":true,"result":{"short_name":"Sandbox","author_name":"Anonymous","author_url":"","access_token":"96fe1c1efdb07717a35b3cb62dd3d71865a34e7206991567d0f6e5b695fa","auth_url":"https:\/\/edit.telegra.ph\/auth\/L2dvGR10WArqGFltKn2oSDJF86Uvu7Af7OIODIOzid"}}

    	Author author = new Author();
        
        JSONObject object = new JSONObject(queryAuthor);
        JSONObject result = object.getJSONObject("result");
        
        author.setShort_name(result.getString("short_name"));
        author.setAuthor_name(result.getString("author_name"));
        author.setAuthor_url(result.getString("author_url"));
        author.setAccess_token(result.getString("access_token"));
        author.setAuth_url(result.getString("auth_url"));

        return author;
    }
}
