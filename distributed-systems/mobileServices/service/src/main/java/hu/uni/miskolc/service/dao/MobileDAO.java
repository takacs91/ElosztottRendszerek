package hu.uni.miskolc.service.dao;

import java.util.Collection;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;

public interface MobileDAO {

    void createMobile(Mobile mobile);

    Collection<Mobile> readAllMobile();
    Collection<Mobile> readMobileByBrand(Brand brand);
    Collection<Mobile> readMobileByModel(String model, String releaseDate);

    
    Mobile findMobile(String model);
    void deleteMobile(String model);
}
