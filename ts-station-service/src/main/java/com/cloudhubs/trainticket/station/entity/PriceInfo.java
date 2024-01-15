package com.cloudhubs.trainticket.station.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fdse
 */
@Data
@NoArgsConstructor
public class PriceInfo {

    private String id;

    private String trainType;

    private String routeId;

    private double basicPriceRate;

    private double firstClassPriceRate;

}
