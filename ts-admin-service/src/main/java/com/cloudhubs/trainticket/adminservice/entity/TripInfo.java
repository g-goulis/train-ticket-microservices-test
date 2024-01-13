package com.cloudhubs.trainticket.adminservice.entity;

import com.cloudhubs.trainticket.adminservice.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author fdse
 */
@Data
@AllArgsConstructor
public class TripInfo {
    @Valid
    @NotNull
    private String startPlace;

    @Valid
    @NotNull
    private String endPlace;

    @Valid
    @NotNull
    private String departureTime;

    public TripInfo(){
        //Default Constructor
        this.startPlace = "";
        this.endPlace = "";
        this.departureTime = "";
    }

    public String getStartPlace() {
        return StringUtils.String2Lower(this.startPlace);
    }

    public String getEndPlace() {
        return StringUtils.String2Lower(this.endPlace);
    }

//    public Date getDepartureTime(){
//        return StringUtils.String2Date(this.departureTime);
//    }
}