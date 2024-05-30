package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class SnackService {

    private static final Logger log = LoggerFactory.getLogger(SnackService.class);
    private final SnackRepository snackRepository;
    private final PriceRepository priceRepository;


    public SnackService(SnackRepository snackRepository, PriceRepository priceRepository) {
        this.snackRepository = snackRepository;
        this.priceRepository = priceRepository;
    }

    //controlla che lo snack esista e sia disponibile
    public void checkSnack(String snack) {

        if (!snackRepository.snackExists(snack)){
            throw new IllegalArgumentException("Snack " + snack + " does not exist");
        }

        if (!snackRepository.snackAvailable(snack)){
            throw new IllegalArgumentException("Snack " + snack + " is not available");
        }
    }

    //richiama il metodo che scala la disponibilità dello snack di 1
    public Integer subtractSnack(String snack){
        return snackRepository.subtractSnack(snack);
    }

    //restituisce il prezzo di uno snack
    public Double getSnackPrice(String snack) {
        return priceRepository.getPriceBySnackId(snack);
    }



}
