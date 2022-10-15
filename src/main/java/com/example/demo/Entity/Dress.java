package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Dress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;
    private int dressNumber;
    private int dressCount = 1;
    public Dress() {
    }
    public Dress(User userId, int dressNumber) {
        this.userId = userId;
        this.dressNumber = dressNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getDressNumber() {
        return dressNumber;
    }

    public void setDressNumber(int dressNumber) {
        this.dressNumber = dressNumber;
    }

    public int getDressCount() {
        return dressCount;
    }

    public void setDressCount(int dressCount) {
        this.dressCount = dressCount;
    }

    public String getPriceForOneDress() {
        return switch (this.dressNumber) {
            case 1 -> 25000 + " руб.";
            case 2 -> 32200 + " руб.";
            case 3 -> 19000 + " руб.";
            case 4 -> 40000 + " руб.";
            case 5 -> 52000 + " руб.";
            case 6 -> 36000 + " руб.";
            case 7 -> 45000 + " руб.";
            case 8 -> 21000 + " руб.";
            default -> "";
        };
    }

    public String getPriceForManyDresses() {
        return switch (this.dressNumber) {
            case 1 -> 25000 * dressCount + " руб.";
            case 2 -> 32200 * dressCount + " руб.";
            case 3 -> 19000 * dressCount + " руб.";
            case 4 -> 40000 * dressCount + " руб.";
            case 5 -> 52000 * dressCount + " руб.";
            case 6 -> 36000 * dressCount + " руб.";
            case 7 -> 45000 * dressCount + " руб.";
            case 8 -> 21000 * dressCount + " руб.";

            default -> "";
        };
    }
    public String getItemName() {
        return switch (this.dressNumber) {
            case 1 -> "Серое платье";
            case 2 -> "Желтое платье";
            case 3 -> "Зеленое платье";
            case 4 -> "Черное платье";
            case 5 -> "Фиолетовое платье";
            case 6 -> "Красное платье";
            case 7 -> "Бирюзовое платье";
            case 8 -> "Белое платье";
            default -> "";
        };
    }
    public String getPhotoAddress() {
        return "images/dress" + dressNumber + ".jpg";
    }
}
