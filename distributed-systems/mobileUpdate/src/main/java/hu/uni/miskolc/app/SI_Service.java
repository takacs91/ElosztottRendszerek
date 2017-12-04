package hu.uni.miskolc.app;

import java.util.Collection;

import org.springframework.integration.annotation.Payload;

import hu.uni.miskolc.struct.Mobile;

public interface SI_Service {

	  @Payload("new java.util.Date()")
	  Collection<Mobile> listAllMobiles();

	  void addMobile(@Payload Mobile mobile);
	  Mobile getMobile(@Payload String model);
	  void deleteMobile(@Payload String name);
	
}
