package org.pokemon.entity;

/**
 * Created by ninja_chen on 13-12-24.
 */
public class Pokemon {
    private  int pokemonIndex;
    private  String name;
    private  int hp;
    private  int atk;
    private  int def;
    private  int spAtk;
    private  int spDef;
    private  int speed;

    public int getPokemonIndex() {
        return pokemonIndex;
    }

    public void setPokemonIndex(int pokemonIndex) {
        this.pokemonIndex = pokemonIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
