package hu.uni.miskolc.systems;

import hu.uni.miskolc.model.Brand;
import hu.uni.miskolc.model.Mobile;
import hu.uni.miskolc.systems.gateway.MobileSearchGateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/si-config.xml");

		MobileSearchGateway gateway = (MobileSearchGateway) context.getBean("MobileSearchGateway",
				MobileSearchGateway.class);

		for (Mobile mobile : gateway.listAllMobile()) {
			System.out.println(mobile.getModel()/* + " " + mobile.getReleaseDate()*/);
		}

		//gateway.addMobile(new Mobile("S6", "2015", Brand.Samsung));
		//gateway.addMobile(new Mobile("G3", "2014", Brand.LG));
		//System.out.println(gateway.getModel("G3").getReleaseDate());
		//gateway.deleteModel("G3");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = "";

			try {
				command = bufferedReader.readLine();
			} catch (IOException exception) {
				exception.printStackTrace();
				break;
			}

			if (command.equals("delete")) {
				String model = "";
				System.out.print("Model: ");
				try {
					model = bufferedReader.readLine();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				try {
				if (!model.equals("")) {
					gateway.deleteMobile(model);
				}
				}catch(org.springframework.http.converter.HttpMessageNotReadableException e) {}
			}
			
			if (command.equals("list")) {
				for (Mobile mobile : gateway.listAllMobile()) {
					System.out.println(mobile.getModel()/* + " " + mobile.getReleaseDate()*/);
				}
			}
		}

	}
}
