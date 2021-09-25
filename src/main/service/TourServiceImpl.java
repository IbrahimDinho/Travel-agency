package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.dao.UserDAO;
import main.model.Tour;
import main.model.TourDetails;
import main.model.User;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourDAO tourDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<Tour> getAll() {
		// TODO Auto-generated method stub
		return tourDAO.getAll();
	}

	@Override
	public Tour getById(int id) {
		// TODO Auto-generated method stub
		return tourDAO.getById(id);
		
//		Tour tour = tourDAO.getById(id);
//		// allows you to get allow comments related to tour instead of eager fetch. +invoke any operation easiest is size
//		tour.getComments().size();
//		return tour;
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		// TODO Auto-generated method stub
		tourDAO.saveOrUpdate(tour);
		return;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourDAO.delete(id);
		return;
	}

	@Override
	public void addTourDetailsifNotExist(Tour tour) {
		// TODO Auto-generated method stub
		if (tour.getTourDetails() == null) {
			tour.setTourDetails(new TourDetails());
			saveOrUpdate(tour);
		}
	}

	@Override
	public Tour getByIdwithComments(int id) {
		// TODO Auto-generated method stub
		return tourDAO.getByIdwithComments(id);
	}

	@Override
	public void addUserToTour(int id, int userId) {
		// TODO Auto-generated method stub
		Tour tour = getById(id);
		if (tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		User user = userDAO.getById(userId);
		if (user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
	}
	

}
