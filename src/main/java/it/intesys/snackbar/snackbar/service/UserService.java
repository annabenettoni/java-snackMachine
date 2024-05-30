package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.UserRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component

public class UserService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public UserService(UserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }

    public Double getUserMoney(String user) {
        return walletRepository.getMoneyByUserId(user);
    }

    public void correctUser(String user){
        if (!userRepository.userExists(user)) {
            throw new IllegalArgumentException("User " + user + " does not exist");
        }
    }

    public Double withdrawMoney(Double amount, String user) {
        return walletRepository.withdrawMoney(amount, user);
    }

    public void refillWallet(String user, Double amount){
        walletRepository.refillWallet(user, amount);
    }
}
