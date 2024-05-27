package it.intesys.snackbar.snackbar.service;


//import it.intesys.snackbar.snackbar.repository.UserRepository;
//import it.intesys.snackbar.snackbar.repository.WalletRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class AllService {

    private static final Logger log = LoggerFactory.getLogger(AllService.class);
    private final SnackService snackService;
    private final UserService userService;
    private final WalletRepository walletRepository;
//    private final UserRepository userRepository;
//    private final WalletRepository walletRepository;
//    private final SnackRepository snackRepository;
//    private final PriceRepository priceRepository;

    //costruttore
    public AllService(SnackService snackService, UserService userService, WalletRepository walletRepository){
        this.snackService = snackService;
        this.userService = userService;

        this.walletRepository = walletRepository;
    }

    public Boolean orderSnack(String user, String snack){
    log.info("User {} is buying {}",user, snack);

        snackService.checkSnack(snack);
        userService.correctUser(user);

        Double snackPrice = snackService.getSnackPrice(snack);
        Double userMoney = userService.getUserMoney(user);

        log.info("snack {} costa {}, l'utente ha {}",snack, snackPrice, userMoney);

        if (snackPrice > userMoney){
            throw new IllegalArgumentException("User %s doesn't have enough money to buy %s".formatted(user, snack));

        }

        userService.withdrawMoney(snackPrice, user);


        //scalo i soldi dal wallet dell'utente
        //scalo la disponibilità dello snack
        //verifico se lo snack cade

        return true;
    }
}
