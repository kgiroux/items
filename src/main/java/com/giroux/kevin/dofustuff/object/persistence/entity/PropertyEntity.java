package com.giroux.kevin.dofustuff.object.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "property")
public class PropertyEntity implements Serializable{

    /**
     *  serialVersionUID :
     */
    private static final long serialVersionUID = -4809179029597022320L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private ItemEntity item;

    @Column
    private int paCost;

    @Column
    private String  poRange;

    @Column
    private int ccBonus;

    @Column
    private int ccRate;

    @Column
    private int ccHits;

    @Column
    private int hitsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public int getPaCost() {
        return paCost;
    }

    public void setPaCost(int paCost) {
        this.paCost = paCost;
    }

    public String getPoRange() {
        return poRange;
    }

    public void setPoRange(String poRange) {
        this.poRange = poRange;
    }

    public int getCcBonus() {
        return ccBonus;
    }

    public void setCcBonus(int ccBonus) {
        this.ccBonus = ccBonus;
    }

    public int getCcRate() {
        return ccRate;
    }

    public void setCcRate(int ccRate) {
        this.ccRate = ccRate;
    }

    public int getCcHits() {
        return ccHits;
    }

    public void setCcHits(int ccHits) {
        this.ccHits = ccHits;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }
}
