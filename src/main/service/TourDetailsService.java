package main.service;

import main.model.TourDetails;

public interface TourDetailsService {
	
	// Service layer does Transaction management
	public TourDetails getById(int id);
	
	public void saveOrUpdate(TourDetails tourDetails);
	
	public void delete(int id);

}
