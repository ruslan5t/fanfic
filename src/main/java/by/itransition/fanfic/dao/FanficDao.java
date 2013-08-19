package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.model.bean.Fanfic;
import by.itransition.fanfic.model.bean.User;

public interface FanficDao {

	void addFanfic(Fanfic fanfic);
	
	List<Fanfic> getFanfics();

	void save(Fanfic fanfic);
	
}
