package com.wayne.staybooking.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "stay_reserved_date")
public class StayReservedDate implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private StayReservedDateKey id;

    @MapsId("stay_id")
    @ManyToOne
    private Stay stay;

    public StayReservedDate() {}

    public StayReservedDate(StayReservedDateKey id, Stay stay) {
        this.id = id;
        this.stay = stay;
    }

    public StayReservedDateKey getId() {
        return id;
    }

    public Stay getStay() {
        return stay;
    }
}
