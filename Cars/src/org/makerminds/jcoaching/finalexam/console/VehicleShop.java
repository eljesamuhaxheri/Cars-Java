package org.makerminds.jcoaching.finalexam.console;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopPrinter;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * providing main method to start the application.
 * 
 * @author <Eljesa-Muhaxheri-Alijaj>
 *
 */

public class VehicleShop {

    private static final String VEHICLE_LIST_PATH = "/vehicle-list.txt"; 

	public static void main(String[] args)  {
		
		// file reading
		VehicleFileManager vehicleFileManager = new VehicleFileManager(VEHICLE_LIST_PATH);
		VehicleShopProcessor vp = new VehicleShopProcessor();
		List<String> vehicleDataAsStringList = null;
		try {
			
			vehicleDataAsStringList = vehicleFileManager.importVehiclesFromFile();
		}catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		// transformation into Vehicle Java Objects
		
		//VehicleTransformer vehicleTransformer = new VehicleTransformer();
		
		List<Vehicle> vehicleList = VehicleTransformer.transformDataArrayToVehicleObjects(vehicleDataAsStringList);
		
		// printing available vehicles 
		VehicleShopPrinter vehicleShopPrinter = new VehicleShopPrinter();
		vehicleShopPrinter.printAvailableVehicles(vehicleList);
		vehicleShopPrinter.printInputInfoRequest();
		
		// user interaction - selecting a vehicle to sell
		Scanner scanner = new Scanner(System.in);
		
		//vehicleShopPrinter.printVehicleIdToSellRequest(vehicleList);
		//int vehicleChosenId = scanner.nextInt();
		int input = scanner.nextInt();
		int id;
		switch(input) {
		case 1:
			vehicleShopPrinter.printVehicleIdToSellRequest();
			id = scanner.nextInt();
			
			boolean sold = vp.sellVehicle(vehicleList, id);
			if(sold) {
				vehicleShopPrinter.printVehicleSoldMessage(id);
			} else {
				vehicleShopPrinter.printNoVehicleWithThisIdMessage();
			}
			break;
			
		case 2:
			vehicleShopPrinter.printVehiclePriceRequest();
			double price = scanner.nextDouble();
			vehicleShopPrinter.printFilteredDataBasedInPrice(price, vehicleList);
			vehicleShopPrinter.printVehicleIdToSellRequest();
			id = scanner.nextInt();
			
			sold = vp.sellVehicle(vehicleList, id);
			if(sold) {
				vehicleShopPrinter.printVehicleSoldMessage(id);
			} else {
				vehicleShopPrinter.printNoVehicleWithThisIdMessage();
			}
			break;
			
		case 3:
			vehicleShopPrinter.printManufacturingFilterRequest();
			String manufacturer = scanner.next();
			vehicleShopPrinter.printFilterdDataBasedInManifacturer(manufacturer, vehicleList);
			
			vehicleShopPrinter.printVehicleIdToSellRequest();
			id = scanner.nextInt();
			
			sold = vp.sellVehicle(vehicleList, id);
			if(sold) {
				vehicleShopPrinter.printVehicleSoldMessage(id);
			} else {
				vehicleShopPrinter.printNoVehicleWithThisIdMessage();
			}
			break;
		}
		
		vehicleFileManager.rewriteFile(vehicleList);
		System.out.println("-------------------------------------------------------");
		System.out.println("--------------AVAIABLE VEHICLES AFTER SALE-------------");
		System.out.println("-------------------------------------------------------");
		
			vehicleShopPrinter.printAvailableVehicles(vehicleList);
			
			scanner.close();
			
		
		// selling a vehicle
		//VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
		//vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);
		
		// write new vehicle list back to file
		
		
		// print sold vehicle information and new vehicle list
		//vehicleShopPrinter.printVehicleSoldMessage(vehicleChosenId);
	
	}
     
}
	
	

