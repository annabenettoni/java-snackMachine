package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import it.intesys.snackbar.snackbar.repository.UserRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class SnackService {

    private static final Logger log = LoggerFactory.getLogger(SnackService.class);
    private final UserRepository userRepository;
    private final SnackRepository snackRepository;
    private final WalletRepository walletRepository;
    private final PriceRepository priceRepository;

    //costruttore
    public SnackService(UserRepository userRepository, SnackRepository snackRepository, WalletRepository walletRepository, PriceRepository priceRepository){
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;

        this.snackRepository = snackRepository;
        this.priceRepository = priceRepository;
    }

    public Boolean orderSnack(String user, String snack){
    log.info("User {} is buying {}",user, snack);
        if (!userRepository.userExists(user)) {
           throw new IllegalArgumentException("User " + user + " does not exist");
        }

        if (!snackRepository.snackExists(snack)){
            throw new IllegalArgumentException("Snack " + snack + " does not exist");
        }

        if (!snackRepository.snackAvailable(snack)){
            throw new IllegalArgumentException("Snack " + snack + " is not available");
        }



        Double snackPrice = priceRepository.getPriceBySnackId(snack);
        Double userMoney = walletRepository.getMoneyByUserId(user);

        log.info("snack {} costa {}, l'utente ha {}",snack, snackPrice, userMoney);
        if (snackPrice > userMoney){
            throw new IllegalArgumentException("User %s doesn't have enough money to buy %s".formatted(user, snack));

        }

        walletRepository.withdrawMoney(snackPrice, user);

        //scalo i soldi dal wallet dell'utente
        //scalo la disponibilità dello snack
        //verifico se lo snack cade

        return true;
    }
}
