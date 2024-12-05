package org.makerminds.jcoaching.finalexam.controller;



	import java.util.Iterator;
import java.util.List;

	import org.makerminds.jcoaching.finalexam.model.Vehicle;

	/**
	 * responsible for processing business processes.
	 * 
	 * @author <Eljesa-Muhaxheri-Alijaj>
	 *
	 */
	public class VehicleShopProcessor {
		
		/**
		 * responsible to sell a specified vehicle by id
		 * @param vehiclesList
		 * @param vehicleChosenId
		 */
		
		public boolean sellVehicle(List<Vehicle> vehiclesList, int vehicleChosenId) {
			// TODO selling a vehicle means to remove it from the available vehicle list
			// Hint: use while loop to safely remove an oject from a lst
			boolean rez = false;
			Iterator<Vehicle> iterateInVehicleList = vehiclesList.iterator();
			while(iterateInVehicleList.hasNext()) {
				Vehicle vehicle = iterateInVehicleList.next();
				if(vehicle.getId() == vehicleChosenId) {
					iterateInVehicleList.remove();
					rez = true;
				}
			}
			return rez;
		}
	}


