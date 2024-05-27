package it.intesys.snackbar.snackbar.controller;

import it.intesys.snackbar.snackbar.service.AllService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController

public class SnackController {

    private final AllService allService;

    public SnackController(AllService allService) {
        this.allService = allService;
    }

    @GetMapping("/order-snack")

    public Boolean orderSnack(@RequestParam("user") String user,
                              @RequestParam("snack") String snack){
        return allService.orderSnack(user, snack);
    }
}
