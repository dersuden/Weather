package org.example.weather;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {

    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String receiveSensorData(@RequestBody Sensor sensor) {
        sensor.setTemperature(23.0);
        sensor.setWeatherCondition("sunny");
        System.out.println("Received temperature: " + sensor.getTemperature());
        System.out.println("Received weather condition: " + sensor.getWeatherCondition());

        return "{\"status\" : \"Data received successfully!\"}";

    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}
