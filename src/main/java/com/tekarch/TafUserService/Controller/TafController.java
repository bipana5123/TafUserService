package com.tekarch.TafUserService.Controller;



import com.tekarch.TafUserService.Services.TafServiceImpl;
import com.tekarch.TafUserService.models.Taf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/taf")
public class TafController {

    @Autowired
    private TafServiceImpl tafService;

    @GetMapping
    public ResponseEntity<List<Taf>> getAllTaf() {
        return new ResponseEntity<>(tafService.getAllTaf(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Taf> postTaf(@RequestBody Taf taf) {
        Taf createdTafAccount = tafService.postTaf(taf);
        return new ResponseEntity<>(createdTafAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Taf> updateAccount(@RequestBody Taf taf) {
        Taf createdTafAccount = tafService.putUpdateTaf(taf);
        return new ResponseEntity<>(createdTafAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taf> getTafById(@PathVariable Long id) {
        Taf taf = tafService.getTafById(id);
        if (taf != null) {
            return new ResponseEntity<>(taf, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaf(@PathVariable Long id) {
        if(!tafService.getTafById(id).getTafId().equals(0L)) {
            tafService.deleteTaf(id);
            return ResponseEntity.ok("Account deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
    }
}
