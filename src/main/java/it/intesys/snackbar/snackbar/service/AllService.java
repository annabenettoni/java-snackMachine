package it.intesys.snackbar.snackbar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class AllService {

    private static final Logger log = LoggerFactory.getLogger(AllService.class);
    private final SnackService snackService;
    private final UserService userService;

    //costruttore
    public AllService(SnackService snackService, UserService userService){
        this.snackService = snackService;
        this.userService = userService;

    }

    public Boolean orderSnack(String user, String snack){
    log.info("User {} is buying {}",user, snack);

        snackService.checkSnack(snack);

        userService.correctUser(user);

        Double snackPrice = snackService.getSnackPrice(snack);
        Double userMoney = userService.getUserMoney(user);

    log.info("User {} has {} dollars", user, userMoney);

        if (snackPrice > userMoney){
            throw new IllegalArgumentException("User %s doesn't have enough money to buy %s".formatted(user, snack));

        }

        Double userUpdateWallet = userService.withdrawMoney(snackPrice, user);
        log.info("Snack {} costs {} dollars, user now has {} dollars",snack, snackPrice, userUpdateWallet);

        Integer snackAvailability = snackService.subtractSnack(snack);
        log.info("Now there are {} {} left", snackAvailability, snack);

        return true;
    }



}
