package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomJokeSupplier {

    public List<String> jokeList = new ArrayList<>();

    public String getJoke() {

        jokeList.add("Why do Gorillas have big noses? \n Because they have big fingers");
        jokeList.add("A neutron walks into a bar and orders a drink.  He asks the bartender how much he owes. \n Bartender says \"for you Neutron, no charge \" ");
        jokeList.add("A guy walks into a bar \n He sustains a mild concussion");
        jokeList.add("What did the DNA say to the other DNA? \n Do these genes make my butt look fat?");

        Random rand = new Random();
        String joke = jokeList.get(rand.nextInt(4));
        return joke;
    }
}
