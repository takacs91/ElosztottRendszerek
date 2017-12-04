package hu.uni.miskolc.service.impl;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;
import hu.uni.miskolc.service.MobileManagerService;
import hu.uni.miskolc.service.dao.MobileDAO;

public class MobileManagerServiceImpl implements MobileManagerService {

    private MobileDAO dao;

    public MobileManagerServiceImpl(MobileDAO dao) {
        this.dao = dao;
    }

    public void register(Mobile mobile) {
        dao.createMobile(mobile);
    }

    public void register(String model, String releaseDate, Brand brand) {
        Mobile mobile = new Mobile(model, releaseDate, brand);
        dao.createMobile(mobile);
    }
    
    public void deleteMobile(String model) {
		dao.deleteMobile(model);
	}
    
}
