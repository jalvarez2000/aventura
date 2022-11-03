package com.fresonlabs.aventura.domain.location;

import org.springframework.stereotype.Component;

@Component
public class LocationService {
    private LocationRepository locationRepository;

    LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationModel getNextLocation(LocationModel location, String direction) {
            return null;
    }
}
