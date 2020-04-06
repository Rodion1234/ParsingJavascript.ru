package jspage.parsers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jspage.bean.Content;
import jspage.bean.Page;

public class JSLessonsParser {
	  private static Page page;
	    private static Content content;
	    
	    private static Element element;
	    private static String[] selectors;
	    private static String convertTag;

	    public static Page parse(String url) {
	        Document document;
	        
	        page = new Page();
	        content = new Content();

	        page.setUrlOriginal(url);
	        
	        try {

	            document = Jsoup.connect(url).get();
	            page.setTitle(document.title());

	            Elements paragraphs = document.getElementsByAttributeValue("itemprop", "articleBody");
	            for (Element paragraph : paragraphs) {

	                for (int i = 0; i < paragraph.childrenSize(); i++) {
	                    newParam(paragraph.child(i));
	                    recursCheck(checkCSS());
	                }
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(JSLessonsParser.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        page.setContent(content);
	        return page;
	    }

	    private static void newParam(Element el) {
	        element = el;
	        selectors = element.cssSelector().split(">");
	        convertTag = Content.convertTag(selectors[selectors.length - 1]);
	    }

	    private static void recursCheck(boolean flag) {
	        Element elemtInner = element;
	        if (flag) {
	            for (int i = 0; i < elemtInner.childrenSize(); i++) {
	                newParam(elemtInner.child(i));
	                recursCheck(checkCSS());
	            }
	        } else {
	            content.addContent(convertTag, elemtInner.text());
	        }
	    }

	    private static boolean checkCSS() {
	        if (convertTag.equals("div.important.important_smart") || convertTag.equals("div.important__content") || convertTag.equals("div.important.important_warn") || convertTag.equals("dl")) {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
