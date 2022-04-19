package org.example.communicat;

import org.example.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class LocationImplCommunicate implements LocationCommunicat{
    @Autowired
    RestTemplate restTemplate;
    public final String serverUrl = "http://localhost:8081/api/location";

    public LocationImplCommunicate() {
    }

    @Override
    public Location getLocation(int id) {
        Location location = restTemplate.getForObject(serverUrl + "/" + id, Location.class);
        return location;
    }

    @Override
    public List<Location> getListLocation() {
        ResponseEntity<List<Location>> responseEntity =
                restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Location>>() {
                });
        return responseEntity.getBody();
    }
}
