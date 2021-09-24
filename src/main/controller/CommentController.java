package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Comment;
import main.model.Tour;
import main.service.CommentService;
import main.service.TourService;

@Controller
public class CommentController {
	
	// to access DB/persistant data autowire both tourservice and commentservice
	@Autowired
	TourService tourService;
	
	@Autowired
	CommentService commentService;
	
	// Show add comment page
	@GetMapping("/addComment")
	public String showCommentForm(Model model) {
		// get tours from DB
		List<Tour> tours = tourService.getAll();
		
		// add tour and comment to model (therefore available for view)
		model.addAttribute("tours", tours);
		model.addAttribute("comment", new Comment());
		return "form-comment";
	}
	
	//process data of add comment page when submitted by the user
	
	@PostMapping("/processFormComment")
	public String addCommentData(@ModelAttribute Comment comment) {
		commentService.save(comment);
		return "home";
	}

}
