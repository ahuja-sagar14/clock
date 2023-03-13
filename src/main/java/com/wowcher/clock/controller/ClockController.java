package com.wowcher.clock.controller;

import com.wowcher.clock.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clock")
public class ClockController {

    @Autowired
    ClockService clockService;

    @GetMapping("/convert")
    public ResponseEntity<String> convertTime(@RequestParam("time") String time) {
        return ResponseEntity.ok(clockService.convertTime(time));
    }
}
