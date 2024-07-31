package com.example.devicemanagment.devicemanagment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device, Long>  {
	List<Device> findByBrand(String brand);

}
