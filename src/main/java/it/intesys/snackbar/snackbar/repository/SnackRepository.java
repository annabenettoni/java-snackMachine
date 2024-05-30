package it.intesys.snackbar.snackbar.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class SnackRepository {

    private static final Logger log = LoggerFactory.getLogger(SnackRepository.class);
    private Map<String, Integer> quantityBySnackId;

    public SnackRepository() {
        quantityBySnackId = new HashMap<>();

        quantityBySnackId.put("Mars", 3);
        quantityBySnackId.put("Twix", 1);
        quantityBySnackId.put("Kinder Delice", 10);
    }

    //funzione che richiama la "mappa" quantityBySnackId
    public Integer getSnackRepository(String snack) {
        return quantityBySnackId.get(snack);
    }

    //controlla che lo snack esista
    public Boolean snackExists(String snack) {
        return quantityBySnackId.containsKey(snack);
    }

    //controlla che lo snack sia disponibile
    public Boolean snackAvailable(String snack) {
        return quantityBySnackId.get(snack) > 0;
    }

    //toglie lo snack appena preso dalla quantità disponibile
    public Integer subtractSnack(String snack) {
        quantityBySnackId.put(snack, quantityBySnackId.get(snack) -1);
        return quantityBySnackId.get(snack);
    }

    //permette di aggiugere un nuovo snack con la relativa quantità
    public Integer addNewSnackQuantity(String snack, Integer quantity) {
        quantityBySnackId.put(snack, quantity);
        return quantityBySnackId.get(snack);
    }



//    public Integer subtractSnack(Boolean orderSnack, String snack) {
//
//        if (orderSnack){
//            Integer snackBalance = quantityBySnackId.get(snack);
//            snackBalance = snackBalance - 1;
//            quantityBySnackId.put(snack, snackBalance);
//            return snackBalance;
//
//        } else {
//            Integer snackBalance = quantityBySnackId.get(snack);
//            quantityBySnackId.put(snack, snackBalance);
//            return snackBalance;
//        }
//    }

    //permette di aggiungere snack già esistenti
    public void refillSnack(String snack, Integer quantity) {
        if (snackExists(snack)){
            Integer snackCount = quantityBySnackId.get(snack);
            snackCount = snackCount + quantity;
            quantityBySnackId.put(snack, snackCount);
            log.info("Now there are {} {}", snackCount, snack);
        } else throw new IllegalArgumentException("Snack " + snack + " does not exist");
    }
}
