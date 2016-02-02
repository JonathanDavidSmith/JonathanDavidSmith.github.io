package data;

import java.awt.Image;
import java.util.List;

public interface ImageDAO
{
	public  List<mwords> getImages();
	public List<mwords> getImageByCategory(String category);
	public void addImageToFile(String category);
	public void addImages(mwords category);
	public List<mwords> deleteImages(String category);
	public void deleteAll();

	
}
