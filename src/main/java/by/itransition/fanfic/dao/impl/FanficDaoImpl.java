package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.model.bean.Fanfic;
import by.itransition.fanfic.model.bean.User;

public class FanficDaoImpl implements FanficDao {

	private List<Fanfic> fanfics = new ArrayList <Fanfic> ();
	private int curId = -1;
	
	@Override
	public void addFanfic(Fanfic fanfic) {
		fanfic.setId(++curId);
		fanfics.add(fanfic);
	}
	
	@Override
	public List<Fanfic> getFanfics() {
		return fanfics;
	}

}
