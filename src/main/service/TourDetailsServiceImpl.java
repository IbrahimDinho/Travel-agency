package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDetailsDAO;
import main.model.TourDetails;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService{
	
	@Autowired
	private TourDetailsDAO tourDetailsDAO;
	
	@Override
	public TourDetails getById(int id) {
		// TODO Auto-generated method stub
		return tourDetailsDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		// TODO Auto-generated method stub
		tourDetailsDAO.saveOrUpdate(tourDetails);
		return;
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourDetailsDAO.delete(id);
		
	}

}
