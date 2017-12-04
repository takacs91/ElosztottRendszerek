package hu.uni.miskolc.systems.gateway;

import org.springframework.integration.annotation.Payload;

import hu.uni.miskolc.model.Mobile;

import java.util.Collection;

public interface MobileSearchGateway {

    @Payload("new java.util.Date()")
    Collection<Mobile> listAllMobile();

    /**
     * @param mobile
     */
    void addMobile(@Payload Mobile mobile);
    Mobile getMobile(@Payload String model);
    void deleteMobile(@Payload String model);
}
