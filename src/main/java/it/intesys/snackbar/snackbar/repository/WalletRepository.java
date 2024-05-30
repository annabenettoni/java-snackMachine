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

    public Double withdrawMoney(Double amount, String user) {
        Double userBalance = walletByUserId.get(user);

        userBalance = userBalance - amount;
        walletByUserId.put(user, userBalance);
        return userBalance;
    }

    public void refillWallet(String user, Double amount) {
        Double userBalance = walletByUserId.get(user);

        userBalance = userBalance + amount;
        walletByUserId.put(user, userBalance);
    }

}
