package com.eureka.test.util;

import com.eureka.test.model.Player;
import com.eureka.test.model.PlayerInfo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 * @author bariskantar
 */
public class ContractFeeCalculator {

    private static final Long TRANSFER_STATIC_VALUE = 1000000L;

    public static PlayerInfo calculate(Player player){
        LocalDate today = LocalDate.now();
        LocalDate licenseStartDate = LocalDate.ofInstant(player.getLicenseStartDate().toInstant(), ZoneId.systemDefault());

        LocalDate birthDate = LocalDate.ofInstant(player.getBirthDate().toInstant(), ZoneId.systemDefault());

        Period licensePeriod = Period.between(licenseStartDate, today);


        Period birthPeriod = Period.between(birthDate, today);


        Long transferValue = licensePeriod.getMonths() * TRANSFER_STATIC_VALUE  / birthPeriod.getMonths();

        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.setTransferFee(transferValue.toString());
        playerInfo.setPlayer(player);

        playerInfo.setCommission(new Long(transferValue/10).toString());
        playerInfo.setContract(new Long(Long.valueOf(playerInfo.getTransferFee())+Long.valueOf(playerInfo.getCommission())).toString());

        return playerInfo;
    }
}
