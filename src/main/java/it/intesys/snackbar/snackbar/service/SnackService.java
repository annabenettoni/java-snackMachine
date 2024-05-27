package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import org.springframework.stereotype.Component;

@Component

public class SnackService {

    private final SnackRepository snackRepository;
    private final PriceRepository priceRepository;


    public SnackService(SnackRepository snackRepository, PriceRepository priceRepository) {
        this.snackRepository = snackRepository;
        this.priceRepository = priceRepository;
    }

    public Double getSnackPrice(String snack) {
        return priceRepository.getPriceBySnackId(snack);
    }

    public void checkSnack(String snack) {

        if (!snackRepository.snackExists(snack)){
            throw new IllegalArgumentException("Snack " + snack + " does not exist");
        }

        if (!snackRepository.snackAvailable(snack)){
            throw new IllegalArgumentException("Snack " + snack + " is not available");
        }

    }
}
