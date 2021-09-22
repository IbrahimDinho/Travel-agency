package main.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.model.Tour;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourDAO tourDAO;
	
	@Override
	public List<Tour> getAll() {
		// TODO Auto-generated method stub
		return tourDAO.getAll();
	}

	@Override
	public Tour getById(int id) {
		// TODO Auto-generated method stub
		return tourDAO.getById(id);
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
	

}
