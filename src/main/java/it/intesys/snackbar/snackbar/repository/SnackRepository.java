package it.intesys.snackbar.snackbar.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class SnackRepository {

    private Map<String, Integer> quantityBySnackId;

    public SnackRepository() {
        quantityBySnackId = new HashMap<>();

        quantityBySnackId.put("Mars", 3);
        quantityBySnackId.put("Twix", 0);
        quantityBySnackId.put("Kinder Delice", 10);
    }

    public Boolean snackExists(String snack) {
        return quantityBySnackId.containsKey(snack);
    }

    public Boolean snackAvailable(String snack) {
        return quantityBySnackId.get(snack) > 0;
    }
}
