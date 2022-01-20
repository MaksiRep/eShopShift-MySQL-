package ru.maksirep.shop_shift.model;

import javax.persistence.*;

@Entity
@Table(name = "technics")
@DiscriminatorValue("COM")
public class Computer extends Technics {

    public Computer () {}

    @Column(name = "FormFactor")
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    private enum FormFactor {
        desktop,
        nettop,
        monoblock
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

}
