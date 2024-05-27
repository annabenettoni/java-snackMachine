package it.intesys.snackbar.snackbar.repository;



import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WalletRepository {

    private Map<String, Double> walletByUserId;
    public WalletRepository() {

        //inizializzo la mappa
        walletByUserId = new HashMap<>();

        walletByUserId.put("Anna", 5.0);
        walletByUserId.put("Pietro", 5.0);
        walletByUserId.put("Talha", 0.20);
    }

    public Double getMoneyByUserId(String user){
        return walletByUserId.get(user);
    }

}