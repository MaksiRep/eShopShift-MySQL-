package ru.maksirep.shop_shift.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("MON")
@Table(name = "technics")
public class Monitor extends Technics {

    public Monitor() {
    }

    @Column(name = "diagonal")
    private Integer diagonal;

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public Integer getDiagonal() {
        return diagonal;
    }
}
