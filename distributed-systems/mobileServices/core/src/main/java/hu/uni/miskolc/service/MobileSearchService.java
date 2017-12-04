package hu.uni.miskolc.service;

import java.util.Collection;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;

public interface MobileSearchService {

    Collection<Mobile> listAllMobile();
    Collection<Mobile> listMobileByBrand(Brand brand);
    Collection<Mobile> listMobileByModel(String model, String releaseDate);
    Mobile findMobile(String model);

}
