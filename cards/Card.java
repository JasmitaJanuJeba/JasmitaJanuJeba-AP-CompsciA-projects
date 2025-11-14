package cards;

public class Card {

//instance variables
private int suit;
private int value;
private static String[] SUITS = {"♦","♥","♣","♠"};
private static String[] VALUE = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"};

//constructor
public Card(int suit, int value){
    this.suit = suit;
    this.value = value;
}

//methods 
public int getValue(){
    return value;
}
public String toString(){
    return " "+SUITS[suit]+VALUE[value];
}

}
