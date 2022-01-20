package ru.maksirep.shop_shift.model;

import javax.persistence.*;


@Entity
@Table(name = "technics")
@DiscriminatorValue("LAP")
public class Laptop extends Technics {

    public Laptop() {
    }

    @Column(name = "LaptopDiagonal")
    @Enumerated(EnumType.STRING)
    private LaptopDiagonal laptopDiagonal;

    private enum LaptopDiagonal {
        thirteen,
        fourteen,
        fifteen,
        seventeen
    }

    public void setLaptopDiagonal(LaptopDiagonal laptopDiagonal) {
        this.laptopDiagonal = laptopDiagonal;
    }

    public LaptopDiagonal getLaptopDiagonal() {
        return laptopDiagonal;
    }

    /*public void setLaptopDiagonal(int laptopDiagonal) {
        switch (laptopDiagonal) {
            case 13 -> this.laptopDiagonal = 13;
            case 14 -> this.laptopDiagonal = 14;
            case 15 -> this.laptopDiagonal = 15;
            case 17 -> this.laptopDiagonal = 17;
        }
        if (this.laptopDiagonal == 0) {
            System.exit(1);
        }


    }

    public Integer getLaptopDiagonal() {
        return laptopDiagonal;
    }*/

}
