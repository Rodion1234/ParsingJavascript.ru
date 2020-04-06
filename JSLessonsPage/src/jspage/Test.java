package jspage;

import java.io.FileWriter;
import java.util.List;

import jspage.bean.Author;
import jspage.bean.Page;
import jspage.parsers.JSLessonsLinkParser;
import jspage.parsers.JSLessonsParser;
import jspage.parsers.URLParser;
import jspage.telegraph.TelegraAPI;

public class Test {

	public static void main(String[] args) {
		  List<String> urlList = JSLessonsLinkParser.parse("https://learn.javascript.ru/getting-started");
	       
	        Author author = Author.initAuthor(TelegraAPI.createUser("Sandbox", "program_easily").toString());
	        int counter = 1;
	        for (String url : urlList) {
	            Page page = JSLessonsParser.parse(url);
	            page.setAuthor(author);
	            StringBuilder builder = TelegraAPI.createPage(page);
	            page.setUtlPage(URLParser.createURL(builder.toString()));

	            System.out.println("Урок "+(counter++)+": "+page.getTitle().replace("+", " ")+" - " +page.getUtlPage());
	        }



	    }
		 
	}


