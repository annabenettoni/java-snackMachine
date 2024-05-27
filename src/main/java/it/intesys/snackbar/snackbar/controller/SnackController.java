package it.intesys.snackbar.snackbar.controller;

import it.intesys.snackbar.snackbar.service.SnackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController

public class SnackController {

    private final SnackService snackService;

    public SnackController(SnackService snackService) {
        this.snackService = snackService;
    }

    @GetMapping("/order-snack")

    public Boolean orderSnack(@RequestParam("user") String user,
                              @RequestParam("snack") String snack){
        snackService.orderSnack(user, snack);
        return snackService.orderSnack(user, snack);
    }
}
