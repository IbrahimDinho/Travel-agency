package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import main.model.Tour;
import main.service.TourDetailsService;
import main.service.TourService;

public class TourDetailsController {

	@Autowired
	private TourService tourService;
	
	@Autowired
	private TourDetailsService tourDetailsService;
	
	@GetMapping("/showTourDetails/{tourId}")
	public String showTourDetails(@PathVariable int tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if (tour != null) {
			tourService.addTourDetailsifNotExist(tour);
			model.addAttribute("tour",tour);
			
		}
		return "redirect:/showOffer";
	}
		
	public String editTourDetails() {
		return "";
		
	}
	
}
