package com.assign.truckLoad.controllers;

import com.assign.truckLoad.Model.Load;
import com.assign.truckLoad.Model.LoadUpdationRequest;
import com.assign.truckLoad.Model.Shipper;
import com.assign.truckLoad.Repositories.LoadRepository;
import com.assign.truckLoad.Repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class homeController {

    @Autowired
    LoadRepository loadRepository;
    @Autowired
    ShipperRepository shipperRepository;

    @PostMapping("/load")
    public ResponseEntity<?> createNewLoad(@RequestBody Load load) {
        loadRepository.save(load);
        return ResponseEntity.ok("load details added successfully");
    }

    @GetMapping("/load")
    public ResponseEntity<?> getLoadsOfShipper(@RequestParam Long id) {
        Shipper shipper = shipperRepository.findById(id).orElse(null);
        if(shipper == null)
            return ResponseEntity.status(404).body("no shipper with id " + id);
        else
            return ResponseEntity.ok().body(shipper.getLoads());
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<?> loadById(@PathVariable("loadId") Long id) {
        Load load = loadRepository.findById(id).orElse(null);
        if(load != null)
            return ResponseEntity.ok(load);
        else
            return ResponseEntity.status(404).body("no load with id " + id);
    }

    @PutMapping("/load/{loadId}")
    public ResponseEntity<?> updateLoad(@PathVariable("loadId") Long id,
                                        @RequestBody LoadUpdationRequest load) {
        Load existingLoad = loadRepository.findById(id).orElse(null);
        if(existingLoad != null) {
            existingLoad.setLoadingPoint(load.getLoadingPoint());
            existingLoad.setUnloadingPoint(load.getUnloadingPoint());
            existingLoad.setProductType(load.getProductType());
            existingLoad.setNoOfTrucks(load.getNoOfTrucks());
            existingLoad.setComment(load.getComment());
            existingLoad.setDate(load.getDate());
            existingLoad.setWeight(load.getWeight());
            existingLoad.setTruckType(load.getTruckType());
            loadRepository.save(existingLoad);
            return ResponseEntity.ok("updated successfully");
        }
        else
            return ResponseEntity.status(404).body("no load with id " + id);
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity<?> deleteLoad(@PathVariable("loadId") Long id) {
        loadRepository.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }

}
