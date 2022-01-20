package ru.maksirep.shop_shift.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("HAD")
@Table(name = "technics")
public class HardDisk extends Technics {

    public HardDisk () {}

    @Column(name = "size")
    private Integer size;

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
