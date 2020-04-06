package jspage.bean;

import org.json.JSONArray;
import org.json.JSONObject;

public class Content {

	   
    private JSONArray array = new JSONArray();

    public void addContent(String tag, String text) {
        JSONObject object = new JSONObject();

        if (tag.equals("code")) {
            object.append("tag", "code");
            object.append("children", convertTagCode(text));
        } else if(tag.equals("a")){
            object.append("tag", tag);
            object.append("href", text);
            object.append("children", "Original+site+"+text);
        }else{
            object.append("tag", tag);
            object.append("children", convertText(text));
        }
        array.put(object);

    }

    public static String convertTag(String tag) {
        if (tag.contains(":nth-child")) {
            tag = tag.substring(0, tag.indexOf(":nth-child"));
        }
        if (tag.contains("code")) {
            tag = "code";
        }
        if (tag.contains("ul") || tag.contains("li") || tag.contains("ol") || tag.contains("div.important__header")) {
            tag = "p";
        }
        if (tag.contains("h1") || tag.contains("h2")) {
            tag = "h3";
        }
        if (tag.contains("dt")) {
            tag = "h4";
        }
        if (tag.contains("dd")) {
            tag = "p";
        }
        return tag.trim();
    }

    private JSONArray convertTagCode(String text) {
        JSONArray arrayCode = new JSONArray();

        String[] array = text.split("\n");

        for (String str : array) {
            JSONObject jsono = new JSONObject();

            jsono.append("tag", "p");
            jsono.append("children", convertText(str));
            arrayCode.put(jsono);
        }

        return arrayCode;
    }

    private String convertText(String text) {

        return text;
    }

    public JSONObject getData() {
        JSONObject jsono = new JSONObject();
        jsono.append("tag", "");
        jsono.append("children", array);

        return jsono;
    }

}
