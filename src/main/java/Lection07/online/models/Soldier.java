package Lection07.online.models;

import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 12.05.2021
 */

public abstract class Soldier {

    protected String name;
    protected String pet;
    protected float attack;
    protected float defense;
    protected float hp;
    private Random random = new Random();

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Soldier(String name, int attack, float defense, float hp, String pet) {
        this.name = name;
        this.pet = pet;
        this.attack = attack;
        this.defense = defense;
        if (hp < 0) {
        this.hp = -hp;
        } else {
            this.hp = hp;
        }
    }

    public Soldier(String name, int attack, float defense, float hp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        if (hp < 0) {
            this.hp = -hp;
        } else {
            this.hp = hp;
        }
    }

    public void attack(Soldier enemy) {
        if (enemy != this) {
            float dealDamage = (this.attack - (this.attack / enemy.defense)) * random.nextFloat();
            enemy.hp -= dealDamage;
            System.out.println(this.name + " deal damage > " + enemy.name + " >> " + dealDamage + " dmg.");
        } else {
            System.out.println("It's me");
        }

    }

    public void healSelf() {
        float summaryHeal = 0.5f * this.defense + 1;
        this.hp += summaryHeal;
        System.out.println(this.name + " heal self " + summaryHeal + ". My hp = " + this.hp);
    }

    public String getMeInfo() {
        return "My name is " + this.name + ". My attack " + this.attack + ". My health is " + this.hp;
    }

    public boolean isDeadHero() {
        return this.hp <= 0;
    }

    public String getName() {
        return name;
    }

    public String getPet() {
        return pet;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getHp() {
        return hp;
    }
}
