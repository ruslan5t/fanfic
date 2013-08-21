package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Service
public class FanficServiceImpl implements FanficService {

	@Autowired
	private FanficDao fanficDao;

	@Override
	@Transactional
	public void addFanfic(Fanfic fanfic) {
		fanficDao.addFanfic(fanfic);
	}

	@Override
	@Transactional
	public List<Fanfic> getAllFanfics() {
		return fanficDao.getAllFanfics();
	}

	@Override
	@Transactional
	public void save(Fanfic fanfic) {
		fanficDao.save(fanfic);
	}

	@Override
	@Transactional
	public List<Fanfic> search(String searchQuery) {
		return fanficDao.search(searchQuery);
	}

	@Override
	@Transactional
	public void removeFanficById(int id) {
		fanficDao.removeFanficById(id);
	}

	@Override
	@Transactional
	public Fanfic getFanficById(int id) {
		return fanficDao.getFanficById(id);
	}

}
