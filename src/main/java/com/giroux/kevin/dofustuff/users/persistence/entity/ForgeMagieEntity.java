package com.giroux.kevin.dofustuff.users.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ForgeMagieEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int value;

    @Column
    private String elt;

    @Column
    private int min;

    @Column
    private int max;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="fm")
    private EffectEntity effectEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getElt() {
        return elt;
    }

    public void setElt(String elt) {
        this.elt = elt;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public EffectEntity getEffectEntity() {
        return effectEntity;
    }

    public void setEffectEntity(EffectEntity effectEntity) {
        this.effectEntity = effectEntity;
    }
}
