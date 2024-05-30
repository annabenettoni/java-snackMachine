package it.intesys.snackbar.snackbar.controller;

import it.intesys.snackbar.snackbar.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController

public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/refill-snack")

    public void refillSnack(@RequestParam("snack") String snack,
                            @RequestParam("quantity") int quantity) {
        adminService.refillSnack(snack, quantity);
    }

    @GetMapping("/add-snack")

    public void addNewSnack(@RequestParam("snack") String snack,
                         @RequestParam("quantity") int quantity,
                         @RequestParam("price") Double price){
        adminService.addNewSnack(snack, quantity, price);
    }


    @GetMapping("/change-snack-price")

    public void changeSnackPrice(@RequestParam("snack") String snack,
                                 @RequestParam("price") Double price){
        adminService.changeSnackPrice(snack, price);
    }
}
