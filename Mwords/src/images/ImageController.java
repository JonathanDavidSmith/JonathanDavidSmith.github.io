//	Originally my idea for this project was to be a basic image host.  I had decided on utilizing web URLs as the source for the images. I placed 36 different 
//URLs in a csv file and had my "imageDataDAO" import and place the files in an array list.  
//#1 personal lesson:  Using the URLs instead of internal files was a much bigger challenge for me.  As far as the logic is concerned, I don't believe it would
//be any more difficult to for a more experienced developer to use URLs vs jpegs, but i had a difficult time with it. 
//The images will display in their perspective categories... Holidays, Technology, Animals, and Food (not in that order).  The person viewing can click on 
//each category and see the images displayed.  Additionally, they can upload their own url to be seen with the other images.
//This was also a challenge.  For lack of time on my part, the code only allows for an image to be uploaded into the "Holiday" category.  
//The user can also delete images.  I began with a deleteAll method to wipe out the entire arraylist.  That works very well. 
//Sunday afternoon i began to work on code that would allow the user to delete one image at a time.  The logic uses the URL address itself
//as the name for the file through href.  The user can click on any chosen image and it will be deleted.  However, the output after that would 
//show ALL the images in the csv file instead of just the images in their perspective categories.  
//It was already late Sunday evening and was ready to go home (I was still at skill distillery at 7pm sunday night)
//SO... i decided to just keep the deleteAll method in place.  Its not ideal, but does complete the CRUD requirements.
//Hopefully i'll be able to modify this application in the near future to improve on its potential. 

package images;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.ImageDAO;
import data.mwords;


@Controller
public class ImageController
{	
	@Autowired
	private ImageDAO ImageDataDAO;

	@RequestMapping(path="holiday.do",
			method=RequestMethod.GET)
	public ModelAndView getByHoliday(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("imageResults.jsp");
//			mv.setViewName("delete.jsp");
			mv.addObject("image", ImageDataDAO.getImageByCategory("holiday"));
			return mv;
	}
	@RequestMapping(path="technology.do",
			method=RequestMethod.GET)
	public ModelAndView getByTechnology(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("imageResults.jsp");
			mv.addObject("image", ImageDataDAO.getImageByCategory("technology"));
			return mv;
	}
	@RequestMapping(path="food.do",
			method=RequestMethod.GET)
	public ModelAndView getByFood(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("imageResults.jsp");
			mv.addObject("image", ImageDataDAO.getImageByCategory("food"));
			return mv;
	}
	@RequestMapping(path="animals.do",
			method=RequestMethod.GET)
	public ModelAndView getByAnimal(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("imageResults.jsp");
			mv.addObject("image", ImageDataDAO.getImageByCategory("animals"));
			return mv;
	}
	
	@RequestMapping(path="NewImage.do", method=RequestMethod.GET)
	public ModelAndView newImage() {
		ModelAndView mv = new ModelAndView();
		mwords m = new mwords();
		mv.addObject("upload", m);
		mv.setViewName("newUpload.jsp");
		return mv;
	 }
	
	@RequestMapping(path="NewImage.do", method=RequestMethod.POST)
	public String addBook(@Valid mwords m) {
		ImageDataDAO.addImages(m);
		return "index.html";
	}

	@RequestMapping(path="deleteholiday.do",
			method=RequestMethod.GET)
	public ModelAndView deleteholiday(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("imageResults.jsp");
//			The two commented lines below were for me to being deleting the images one at a time.  It works, however
//			due to running out of time, I wasn't able to get the images to display correctly in their perspective categories.			
//			so I stuck with my .deleteAll method. The deleteAll wipes out the entire arraylist,			
//			mv.setViewName("delete.jsp");   
//			mv.addObject("image", ImageDataDAO.getImageByCategory("holiday"));
			ImageDataDAO.deleteAll();
			return mv;
	}
	
	@RequestMapping(path="deleteImage.do",
			method=RequestMethod.GET)
	public ModelAndView deleteImage(@RequestParam("photoLink") String link){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete.jsp");
		List<mwords> images = ImageDataDAO.deleteImages(link);
		mv.addObject("image", images);

//			mv.addObject("image", "Image does not exist" );
		return mv;
	}
	
	@RequestMapping(path="deletetechnology.do",
			method=RequestMethod.GET)
	public ModelAndView deleteTechnology(){
			ModelAndView mv = new ModelAndView();
			ImageDataDAO.deleteAll();
			mv.setViewName("imageResults.jsp");
//			mv.addObject("image","Image does not exist" );
			return mv;
	}
	@RequestMapping(path="deletefood.do",
			method=RequestMethod.GET)
	public ModelAndView deleteFood(){
			ModelAndView mv = new ModelAndView();
			ImageDataDAO.deleteAll();
			mv.setViewName("imageResults.jsp");
//			mv.addObject("image", "Image does not exist");
			return mv;
	}
	@RequestMapping(path="deleteanimals.do",
			method=RequestMethod.GET)
	public ModelAndView deleteAnimal(){
			ModelAndView mv = new ModelAndView();
			ImageDataDAO.deleteAll();
			mv.setViewName("imageResults.jsp");
//			mv.addObject("image", "Image does not exist");
			return mv;
	}
	
	
}
