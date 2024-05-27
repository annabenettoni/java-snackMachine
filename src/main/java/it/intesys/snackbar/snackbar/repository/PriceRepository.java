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

    public Double getPriceBySnackId(String snack) {
        return priceBySnackId.get(snack);
    }

}
