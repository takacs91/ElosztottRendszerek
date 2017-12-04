package hu.uni.miskolc.service;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;

public interface MobileManagerService {

    void register(Mobile mobile);
    void register(String model, String releaseDate, Brand brand);
    void deleteMobile(String model);
}
