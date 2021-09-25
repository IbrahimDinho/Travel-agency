package main.service;

import java.util.List;

import main.model.Tour;

public interface TourService {
	
	//CRUD operations to DB that I need
	
		public List<Tour> getAll();
		
		public Tour getById(int id);
		
		public void saveOrUpdate(Tour tour);
		
		public void delete(int id);
		
		public void addTourDetailsifNotExist(Tour tour);
		
		public Tour getByIdwithComments(int id);
}
