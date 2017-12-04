package hu.uni.miskolc.service.impl;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;
import hu.uni.miskolc.service.MobileSearchService;
import hu.uni.miskolc.service.dao.MobileDAO;

import java.util.Collection;

public class MobileSearchServiceImpl implements MobileSearchService {

    private MobileDAO dao;

    public MobileSearchServiceImpl(MobileDAO dao) {
        this.dao = dao;
    }

    public Collection<Mobile> listAllMobile() {
        return dao.readAllMobile();
    }

    public Collection<Mobile> listMobileByBrand(Brand brand) {
        return dao.readMobileByBrand(brand);
    }

    public Collection<Mobile> listMobileByModel(String model, String releaseDate) {
        return dao.readMobileByModel(model, releaseDate);
    }

	public Mobile findMobile(String model) {
		return dao.findMobile(model);
	}
    
}
