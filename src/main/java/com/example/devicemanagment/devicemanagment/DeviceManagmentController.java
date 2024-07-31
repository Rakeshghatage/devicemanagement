package com.example.devicemanagment.devicemanagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceManagmentController {

	@Autowired
	private DeviceService deviceService;

	@PostMapping
	public Device addDevice(@RequestBody Device device) {
		return deviceService.addDevice(device);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
		return deviceService.getDeviceById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<Device> listAllDevices() {
		return deviceService.listAllDevices();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
		return ResponseEntity.ok(deviceService.updateDevice(id, deviceDetails));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Device> partialUpdateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
		return deviceService.getDeviceById(id).map(existingDevice -> {
			if (deviceDetails.getName() != null)
				existingDevice.setName(deviceDetails.getName());
			if (deviceDetails.getBrand() != null)
				existingDevice.setBrand(deviceDetails.getBrand());
			return ResponseEntity.ok(deviceService.updateDevice(id, existingDevice));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
		deviceService.deleteDevice(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public List<Device> searchDeviceByBrand(@RequestParam String brand) {
		return deviceService.searchDeviceByBrand(brand);
	}
}