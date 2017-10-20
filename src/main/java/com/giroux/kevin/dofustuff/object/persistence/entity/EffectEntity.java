package com.giroux.kevin.dofustuff.object.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "effect")
public class EffectEntity implements Serializable{


    /**
     *  serialVersionUID :
     */
    private static final long serialVersionUID = -4809179023597024020L;

    @Id
    private String internalId;

    @Column
    private int id;

    @Column
    private  String name;

    @Column
    private String type;

    @Column
    private int min;

    @Column
    private int max;

    @Column
    private String other;

    @Column
    private String emotes;

    @Column
    private String title;

    @Column
    private String spell;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="fm_id")
    private ForgeMagieEntity fm;

    @Column
    private boolean exo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", nullable = false, updatable = false)
    private ItemEntity item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getEmotes() {
        return emotes;
    }

    public void setEmotes(String emotes) {
        this.emotes = emotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public ForgeMagieEntity getFm() {
        return fm;
    }

    public void setFm(ForgeMagieEntity fm) {
        this.fm = fm;
    }

    public boolean isExo() {
        return exo;
    }

    public void setExo(boolean exo) {
        this.exo = exo;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

}
