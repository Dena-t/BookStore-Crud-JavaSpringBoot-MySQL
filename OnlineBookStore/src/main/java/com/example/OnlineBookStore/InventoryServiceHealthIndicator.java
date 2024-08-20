package com.example.OnlineBookStore;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
public class InventoryServiceHealthIndicator implements HealthIndicator {
	// Simulate a check to the inventory service
	private boolean isInventoryServiceUp() {
	// Actual logic to check the service goes here.
	// For simplicity, returning true.
	return true;
	}
	@Override
	public Health health() {
	if (isInventoryServiceUp()) {
	return Health.up().withDetail("inventory", "Service is UP").build();
	} else {
	return Health.down().withDetail("inventory", "Service is DOWN").build();
	}
	}
	}