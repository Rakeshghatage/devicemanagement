package com.example.devicemanagment.devicemanagment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepo deviceRepo;

	public Device addDevice(Device device) {
		return deviceRepo.save(device);
	}

	public Optional<Device> getDeviceById(Long id) {
		return deviceRepo.findById(id);
	}

	public List<Device> listAllDevices() {
		return deviceRepo.findAll();
	}

	public List<Device> searchDeviceByBrand(String brand) {
		return deviceRepo.findByBrand(brand);
	}

	public Device updateDevice(Long id, Device deviceDetails) {
		Device device = deviceRepo.findById(id).orElseThrow();
		device.setName(deviceDetails.getName());
		device.setBrand(deviceDetails.getBrand());
		return deviceRepo.save(device);
	}

	public void deleteDevice(Long id) {
		deviceRepo.deleteById(id);
	}

}