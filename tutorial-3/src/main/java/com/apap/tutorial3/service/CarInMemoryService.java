package com.apap.tutorial3.service;
import java.util.ArrayList;
import java.util.List;
import com.apap.tutorial3.model.CarModel;
import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}
	
	@Override
	public void addCar(CarModel car) {
		archiveCar.add(car);	
	}
	
	@Override
	public List<CarModel> getCarList(){
		return archiveCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
		// TODO Auto-generated method stub
		for(CarModel mbil : archiveCar) {
			if (mbil.getId().equals(id)) {
				return mbil;
			}
		}
		return null;
	}
	
	@Override
	public boolean cekMobil(String id) {
		for(CarModel mbil : archiveCar) {
			if(mbil.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateJumlah(String id, String amount) {
		CarModel mobilDipilih = getCarDetail(id);
		mobilDipilih.setAmount(Integer.parseInt(amount));
	}
	
	@Override
	public void deleteCar(String id) {
		CarModel mobilDipilih = getCarDetail(id);
		archiveCar.remove(mobilDipilih);
	}
}
