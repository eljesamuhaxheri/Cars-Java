package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for printing vehicle shop data.
 * 
 * @author <Eljesa-Muhaxheri-Alijaj>
 *
 */
public class VehicleShopPrinter {
	
	public  void printAvailableVehicles(List<Vehicle> vehicleList) {
		// TODO Implement print available vehicles
		
		System.out.println(" Available vehicles ");
		for(Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.getId() + ", " + vehicle.getManufacturer() + ", " 
		            + vehicle.getHorsePower() + ", " + vehicle.getModel() + " , " 
					+ vehicle.getPrice() + ", " + vehicle.getColor() + ", " + vehicle.getMileage() + ", " 
		            + vehicle.getProductionYear() + ", " + vehicle.getTransmission() +  " , " 
					+ vehicle.getFuelType());
		} 
	}

	public  void printVehicleSoldMessage(int vehicleChosenId) {
		
		// \n in a String will cause a line break
		System.out.println("\n" + "Vehicle with ID " + vehicleChosenId + " was sold.");
		
	}
	  public int avaliableVehicles(int avaliableVehicless) {
		return avaliableVehicless;
		
	}
	
	public void printVehicleIdToSellRequest() {
		// \n in a String will cause a line break
	 
		System.out.println("\n\n Please enter the number (ID) of the vehicle you want to sell: ");
	
}
	public void printVehiclePriceRequest() {
		System.out.println("Enter price filter: ");
		
	}
	public void printInputInfoRequest() {
		System.out.println("Enter 1 to directly sell the vehicle by entering its ID"
				+ "\nEnter 2 to filter vehicles by a certain price "
				+ "\nEnter 3 to filter vehicles by the given manufacturer ");
		
	}
	public void printManufacturingFilterRequest() {
		System.out.println(" Enter Manufacturing filter : ");
	}
	
	public List<String> printFilteredDataBasedInPrice(double price, List<Vehicle> vehicleList){
		boolean hasDataInThisPriceRange = false;
		List<String> vehicleInfoList = new ArrayList<String>();
		for (Vehicle vehicle : vehicleList) {
			if(vehicle.getPrice() <= price) {
				String vehicleInfo = vehicle.getId() + " , " + vehicle.getManufacturer() + ", " + vehicle.getHorsePower() + ", " + vehicle.getModel() + " , " + 
						vehicle.getPrice() + ", " + vehicle.getColor() + ", " + vehicle.getMileage() + ", " + vehicle.getProductionYear() + ", " + vehicle.getTransmission() + 
						" , " + vehicle.getFuelType();
				vehicleInfoList.add(vehicleInfo);
			System.out.println(vehicleInfo);
			hasDataInThisPriceRange = true;
 			}
			
		}
		if(! hasDataInThisPriceRange) {
			System.out.println("No vehicle available in (0.0 " + price+ ") price range");
		}
		
		return vehicleInfoList;
	}
	public List<String> printFilterdDataBasedInManifacturer(String manufacturer, List<Vehicle> vehicleList) {
		boolean hasVehicleOfThisMake = false;
		List<String> vehicleInfoList = new ArrayList<String>();
		VehicleTransformer vehicleTransformer = new VehicleTransformer();
		//VehicleTransformer vehicleTransformer = new VehicleTransformer();
		for(Vehicle vehicle : vehicleList) {
			
			if (vehicle.getManufacturer().equals(((VehicleTransformer) vehicleTransformer).getManufacturer(manufacturer))) {	
				
			hasVehicleOfThisMake = true;
			String vehicleInfo = vehicle.getId() + " , " + vehicle.getManufacturer() + ", " + vehicle.getHorsePower() + ", " + vehicle.getModel() + " , " + 
					vehicle.getPrice() + ", " + vehicle.getColor() + ", " + vehicle.getMileage() + ", " + vehicle.getProductionYear() + ", " + vehicle.getTransmission() + 
					" , " + vehicle.getFuelType();
			
			System.out.println(vehicleInfo);
			}
		}
	
	if(!hasVehicleOfThisMake) {
		System.out.println("There's no available car of this make.");
	}
	 return vehicleInfoList;
  }
	public void printNoVehicleWithThisIdMessage() {
	System.out.println("There is no vehicle with this ID");
	 }
	public void printNoVehicleAvailableMessage() {
	System.out.println("All Vehicles are sold out");
	
	   }

}
			

    
