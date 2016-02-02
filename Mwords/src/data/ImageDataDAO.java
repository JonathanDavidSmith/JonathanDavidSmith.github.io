package data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ImageDataDAO implements ImageDAO
{
	private static final String FILE_NAME = "/WEB-INF/images.csv";
	private List<mwords> images = new ArrayList<>();

	@Autowired
	private ApplicationContext ac;

	@PostConstruct
	public void init()
	{
		try (InputStream is = ac.getResource(FILE_NAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));)
		{
			String line = buf.readLine();
			while ((line = buf.readLine()) != null)
			{
				String[] tokens = line.split(",");
				images.add(new mwords("animals", tokens[0]));
				images.add(new mwords("holiday", tokens[1]));
				images.add(new mwords("technology", tokens[2]));
				images.add(new mwords("food", tokens[3]));

				// images.add(new mwords(holidays, technology, food, animals));
				System.out.println(mwords.counter);
			}
		} catch (Exception e)
		{
			System.err.println(e);
		}

	}

	public void deleteAll()
	{
		images.clear();
	}

	public List<mwords> getImageByCategory(String category)
	{
		System.out.println("in method");
		List<mwords> pics = new ArrayList<>();
		for (mwords mwords : images)
		{
			if (mwords.getCategory().equals(category))
			{

				pics.add(mwords);
			}
		}
		return pics;
	}

	public List<mwords> deleteImages(String link)
	{
		mwords url = new mwords();
		for (mwords mwords : images)
		{
			if (mwords.getUrl().matches(link))
			{
				url = mwords;
			}
		}
		images.remove(url);
		return images;
	}

	@Override
	public void addImages(mwords uploadedImage)
	{
		images.add(uploadedImage);
	}

	@Override
	public List<mwords> getImages()
	{
		return images;
	}

	private void addImageToFile(mwords i)
	{
		try (FileWriter fw = new FileWriter(ac.getResource(FILE_NAME).getFile(), true);)
		{
			fw.write(i.getCSV());
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}

	@Override
	public void addImageToFile(String category)
	{
		// TODO Auto-generated method stub

	}

//	@Override
//	public void deleteImages(String category)
//	{
//		for (mwords mwords : images)
//		{
//			if (mwords.getCategory().equals(category))
//			{
//
//				images.remove(mwords);
//			}
//			continue;
//		}
//
//	}

}
