package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class AdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminService.class);
    private final SnackRepository snackRepository;
    private final PriceRepository priceRepository;


    public AdminService(SnackRepository snackRepository, PriceRepository priceRepository) {
        this.snackRepository = snackRepository;
        this.priceRepository = priceRepository;
    }

    //metodo che permette di ricaricare gli snack esistenti
    public void refillSnack(String snack, Integer quantity){
        snackRepository.refillSnack(snack, quantity);
    }

    //metodo che permette di aggiungere nuovi snack
    public void addNewSnack (String snack, Integer quantity, Double price) {
        snackRepository.addNewSnackQuantity(snack, quantity);
        priceRepository.addNewSnackPrice(snack, price);

        log.info("Snack {} added. Snack price: {} dollars. Snack quantity: {}", snack, price, quantity);
    }

    //metodo che permette di modificare i prezzi degli snack
    public void changeSnackPrice(String snack, Double price) {
        priceRepository.changeSnackPrice(snack, price);

        log.info("Now {} costs {} dollars", snack, price);
    }

}
