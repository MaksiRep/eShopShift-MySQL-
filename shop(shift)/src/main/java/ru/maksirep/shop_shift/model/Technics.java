package ru.maksirep.shop_shift.model;


import javax.persistence.*;

@Entity
@Table(name = "technics")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "DTYPE",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value = "TEC")
public class Technics {

    public Technics() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer serialID;

    @Column(name = "developer")
    public String developer;

    @Column(name = "price")
    public Integer price;

    @Column(name = "counts")
    public Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getSerialID() {
        return serialID;
    }

    public void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
