package it.intesys.snackbar.snackbar.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class PriceRepository {

    private Map<String, Double> priceBySnackId;
    public PriceRepository() {

        //inizializzo la mappa
        priceBySnackId = new HashMap<>();

        priceBySnackId.put("Mars", 1.0);
        priceBySnackId.put("Twix", 1.0);
        priceBySnackId.put("Kinder Delice", 2.0);
    }

    //ritorna il prezzo di uno snack
    public Double getPriceBySnackId(String snack) {
        return priceBySnackId.get(snack);
    }

    //permette di aggiugere un nuovo snack con il relativo prezzo
    public void addNewSnackPrice(String snack, Double price) {
        priceBySnackId.put(snack, price);
    }

    //metodo che permette di modificare i prezzi degli snack
    public void changeSnackPrice(String snack, Double price) {
        priceBySnackId.put(snack, price);
    }

}
