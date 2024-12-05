package org.makerminds.jcoaching.finalexam.controller;


import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Color;
import org.makerminds.jcoaching.finalexam.model.FuelType;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Transmission;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for transforming vehicle data into {@link Vehicle} objects.
 * 
 * @author <Eljesa-Muhaxheri-Alijaj>
 *
 */
public class VehicleTransformer {
	
	/**
	 * transforms a data array into a {@link Vehicle} list 
	 * @param vehicle data array
	 * @return list of {@link Vehicle} objects
	 */
	
	public static List<Vehicle> transformDataArrayToVehicleObjects(List<String> vehicleDataArray) {
		// TODO take data from String list and transform to list of vehicle objects
		// TODO call method transformToVehicleObject
		// Hint: use for loop
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		for(String vehicles : vehicleDataArray) {
			vehicleList.add(transformToVehicleObject(vehicles));
			
		}
		
		
		return vehicleList;
	}

	/**
	 * transforms a vehicle data record as String into a {@link Vehicle} object
	 * @param vehicle data record as String 
	 * @return {@link Vehicle} object
	 */
	
	private static Vehicle transformToVehicleObject(String vehicleAsString) {
		
		// TODO transform the vehicle as string into a vehicle object
		// Hint: use the split(String) method of a String to define where to split the 
		// String. In this case split on every comma (,)
		//public void ManufacturerFromString() 
		
		String[] carArray = vehicleAsString.split(",");
		
		int id = Integer.valueOf(carArray[0]);
		Manufacturer manufacturer = Manufacturer.valueOf(carArray[1]);
		String model = String.valueOf(carArray[2]);
		int horsePower = Integer.valueOf(carArray[3]);
		double price = Double.valueOf(carArray[4]);
		Color color = Color.valueOf(carArray[5]);		
		int mileage = Integer.valueOf(carArray[6]);
		int productionYear = Integer.valueOf(carArray[7]);
		Transmission transmission = Transmission.valueOf(carArray[8]);
        FuelType fuelType = FuelType.valueOf(carArray[9]);
	
		
		return new Vehicle(id,manufacturer,model,horsePower,price,color,mileage,productionYear,transmission,fuelType);
		

	}
	
	public Object getManufacturer(String manufacturer) {
		//BMW,SKODA,AUDI,VW,HONDA,FORD
		
		switch(manufacturer) {
		case "SKODA":
			return Manufacturer.SKODA;
		case "AUDI":
			return Manufacturer.AUDI;
		case "VW":
			return Manufacturer.VW;
		case "BMW":
			return Manufacturer.BMW;
		case "HONDA":
			return Manufacturer.HONDA;
		
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private Color getColor(String color) {
		switch(color) {
		case "BLACK":
			return Color.BLACK;
		case "GREY":
			return Color.GREY;
		case "WHITE":
			return Color.WHITE;
		case "BLUE":
			return Color.BLUE;
		case "GREEN":
			return Color.GREEN;
		case "RED":
			return Color.RED;
		case "BROWN":
			return Color.BROWN;
		case "YELLOW":
			return Color.YELLOW;
			default:
				throw new IllegalArgumentException();
		}
	} 	
	private FuelType getFuelType(String fuelType) {
		if (fuelType.equals("DIESEL_FUEL")) {
			
			return FuelType.DIESEL_FUEL;
			
		} else if (fuelType.equals("GASOLINE")) {
			return FuelType.GASOLINE;
			
		} else {
			
			throw new IllegalArgumentException("Illegal fuel type!! ");
		}
	}
	private static Transmission getTransmission(String transmission) {
		
		if(transmission.equals("AUTOMATIC")) {
			return Transmission.AUTOMATIC;
		}
		else if(transmission.equals("MANUAL")) {
			return Transmission.MANUAL;
			
		} else {
			throw new IllegalArgumentException();
		}
	}


}
