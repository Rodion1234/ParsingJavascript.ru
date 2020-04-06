package jspage.telegraph;

import java.net.URLEncoder;

import jspage.bean.Author;
import jspage.bean.Page;
import jspage.connector.HTTPConnector;

public class TelegraAPI {
	
	//Anonim author: short_name=Sandbox&author_name=Anonymous 
    public static StringBuilder createUser(String short_name, String author_name) {
        String query = "https://api.telegra.ph/createAccount?short_name=" + short_name + "&author_name=" + author_name;

        StringBuilder builder = null;
        try {
            HTTPConnector.openConnectionGet(query);
            if (HTTPConnector.connectionIsSuccsessful()) {
                builder = HTTPConnector.readContent();
            } else {
                System.out.println("create user fail connect");
                System.out.println(HTTPConnector.readContent());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HTTPConnector.closeConnection();
        }
        return builder;
    }
    
    public static StringBuilder createPage(Page page) {

        StringBuilder builder = null;
        try {

            String query = "https://api.telegra.ph/createPage";

            String body = "access_token="+page.getAuthor().getAccess_token()
                    + "&title=" + URLEncoder.encode(page.getTitle(), "UTF-8")
                    + "&author_name=" + page.getAuthor().getAuthor_name()
                    + "&content=" + URLEncoder.encode(page.converterContentToURL(), "UTF-8")
                    + "&return_content:true";

            HTTPConnector.openConnectionPost(query, body);
            if (HTTPConnector.connectionIsSuccsessful()) {
                builder = HTTPConnector.readContent();
            } else {
                System.out.println("fail connect");
                System.out.println(HTTPConnector.readContent());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HTTPConnector.closeConnection();
        }
        return builder;
    }
   
}
