package jspage.bean;

import jspage.parsers.AuthorParser;

public class Author {

//  {"ok":true,"result":{"short_name":"Sandbox","author_name":"Anonymous","author_url":"","access_token":"96fe1c1efdb07717a35b3cb62dd3d71865a34e7206991567d0f6e5b695fa","auth_url":"https:\/\/edit.telegra.ph\/auth\/L2dvGR10WArqGFltKn2oSDJF86Uvu7Af7OIODIOzid"}}
  private String short_name;
  private String author_name;
  private String author_url;
  private String access_token;
  private String auth_url;

  public Author() {
  }

  public Author(String short_name, String author_name, String author_url, String access_token, String auth_url) {
      this.short_name = short_name;
      this.author_name = author_name;
      this.author_url = author_url;
      this.access_token = access_token;
      this.auth_url = auth_url;

  }

  public static Author initAuthor(String queryAuthor) {
      return AuthorParser.createAuthor(queryAuthor);
  }

  public String getShort_name() {
      return short_name;
  }

  public void setShort_name(String short_name) {
      this.short_name = short_name;
  }

  public String getAuthor_name() {
      return author_name;
  }

  public void setAuthor_name(String author_name) {
      this.author_name = author_name;
  }

  public String getAuthor_url() {
      return author_url;
  }

  public void setAuthor_url(String author_url) {
      this.author_url = author_url;
  }

  public String getAccess_token() {
      return access_token;
  }

  public void setAccess_token(String access_token) {
      this.access_token = access_token;
  }

  public String getAuth_url() {
      return auth_url;
  }

  public void setAuth_url(String auth_url) {
      this.auth_url = auth_url;
  }

  @Override
  public String toString() {
      return "Author{" + "short_name=" + short_name + ", author_name=" + author_name + ", author_url=" + author_url + ", access_token=" + access_token + ", auth_url=" + auth_url + '}';
  }

	
}
