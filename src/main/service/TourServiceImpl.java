package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Tour;
import main.model.User;
import main.repository.TourRepository;
import main.repository.UserRepository;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Tour> getAll() {
		// TODO Auto-generated method stub
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(int id) {
		// TODO Auto-generated method stub
		return tourRepository.getOne(id);
		
//		Tour tour = tourDAO.getById(id);
//		// allows you to get allow comments related to tour instead of eager fetch. +invoke any operation easiest is size
//		tour.getComments().size();
//		return tour;
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		// TODO Auto-generated method stub
		tourRepository.save(tour);
		return;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourRepository.deleteById(id);
		return;
	}



	@Override
	public Tour getByIdwithComments(int id) {
		// TODO Auto-generated method stub
		return tourRepository.getByIdwithComments(id);
	}

	@Override
	public void addUserToTour(int id, int userId) {
		// TODO Auto-generated method stub
		Tour tour = getById(id);
		if (tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		User user = userRepository.getOne(userId);
		if (user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
	}
	

}
