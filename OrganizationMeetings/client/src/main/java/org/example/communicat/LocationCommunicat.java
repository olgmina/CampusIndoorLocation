package org.example.communicat;

import org.example.entity.Location;

import java.util.List;

public interface LocationCommunicat {
    Location getLocation(int id);
    List<Location> getListLocation();
}
