package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.TourDetails;
import main.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService{
	
	@Autowired
	private TourDetailsRepository tourDetailsRepository;
	
	@Override
	public TourDetails getById(int id) {
		// TODO Auto-generated method stub
		return tourDetailsRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		// TODO Auto-generated method stub
		tourDetailsRepository.save(tourDetails);
		return;
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourDetailsRepository.deleteById(id);
		
	}

}
