package data;

import javax.validation.constraints.NotNull;

public class mwords
{
	public static int counter = 0;
		
	@NotNull
	private String category = "holiday";
	@NotNull
	private String url = "Enter image URL";
	public mwords(){
		
	}
	public mwords(String category, String url){
		this.category = category;
		this.url = url; 
		counter++;
	}
	
	
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	@Override
	public String toString()
	{
		return "mwords [category=" + category + ", url=" + url + "]";
	}
	public String getCSV()
	{
		return url;
	}
}
