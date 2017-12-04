package hu.uni.miskolc.dao;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;
import hu.uni.miskolc.service.dao.MobileDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MobileDAODummy implements MobileDAO {

    private Collection<Mobile> mobiles;

    public MobileDAODummy() {
    	mobiles = new HashSet<Mobile>();
    	mobiles.add(new Mobile("G2Mini", "2014", Brand.LG));
    	mobiles.add(new Mobile("GalaxyS8", "2017", Brand.Samsung));
    	mobiles.add(new Mobile("G4", "2015", Brand.LG));
    	mobiles.add(new Mobile("P10", "2017", Brand.Huawei));
    }

    public void createMobile(Mobile mobile) {
    	mobiles.add(mobile);
    }

    public Collection<Mobile> readAllMobile() {
        return new ArrayList<Mobile>(mobiles);
    }

    public Collection<Mobile> readMobileByBrand(Brand brand) {
        Collection<Mobile> result = new HashSet<Mobile>();
        for(Mobile mobile : mobiles){
            if(mobile.getBrand() == brand){
                result.add(mobile);
            }
        }
        return result;
    }

    public Collection<Mobile> readMobileByModel(String model, String releaseDate) {
        Collection<Mobile> result = new HashSet<Mobile>();
        for(Mobile mobile : mobiles){
            if(mobile.getModel().equals(model) || mobile.getReleaseDate().equals(releaseDate)){
                result.add(mobile);
            }
        }
        return result;
    }
    
    public Mobile findMobile(String model) {
    	Mobile result=null;
        for(Mobile mobile : mobiles){
            if(mobile.getModel().equals(model) || mobile.getReleaseDate().equals(model)){
                result=mobile;break;
            }
        }
        return result;
    }
    
    public void deleteMobile(String model) {
        Iterator<Mobile> iter = mobiles.iterator();
        while(iter.hasNext()){
            if(iter.next().getModel().equals(model)){
                iter.remove();
            }
        }
    }
}
