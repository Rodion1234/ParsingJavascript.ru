package jspage.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JSLessonsLinkParser {

	  public static List<String> parse(String url) {
	        Document document;
	        List<String> urlList = new ArrayList<>();
	        try {

	            document = Jsoup.connect(url).get();

	            Elements paragraphs = document.getElementsByClass("lessons-list__lessons");
	            for (Element paragraph : paragraphs) {

	                for (int i = 0; i < paragraph.childrenSize(); i++) {
	                    urlList.add("https://learn.javascript.ru"+recursCheck(paragraph.child(i)));
	                }
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(JSLessonsParser.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return urlList;
	    }
	    
	    private static String recursCheck(Element elem) {

	        if (elem.childrenSize()!=0) {
	            for (int i = 0; i < elem.childrenSize(); i++) {
	              return recursCheck(elem.child(i));
	            }
	        } else {
	            return elem.attr("href");
	        }
	        return null;
	    }

	
}
