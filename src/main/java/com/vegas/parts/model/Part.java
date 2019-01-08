package com.vegas.parts.model;

import javax.persistence.*;

@Entity
@Table(name = "parts", schema = "test")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

    @Column(columnDefinition = "enum('CPU','RAM','HDD','MOTHERBOARD','CASE','SSD','GPU','SOUND_CARD')")
    @Enumerated(EnumType.STRING)
    private PartType type;

    public Part() {
    }

    public Part(String title, PartType type, int quantity) {
        this.title = title;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }

    public boolean isNecessary() {
        return PartType.isNecessary(type);
    }
}
