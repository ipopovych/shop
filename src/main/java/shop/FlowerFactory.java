package shop;

import flowers.*;

import java.util.ArrayList;

public class FlowerFactory {

    public Flower getDefaultFlower(String flowerType){
        if(flowerType == null){
            return null;
        }
        if(flowerType.equalsIgnoreCase("Tulip")){
            return new Flower(FlowerType.Tulip, Color.Blue, 10, Odor.OK, Country.NETHERLANDS, 20, new ArrayList<String>());

        } else if(flowerType.equalsIgnoreCase("Chamomile")){
            return new Flower(FlowerType.Chamomile, Color.White, 15, Odor.Good, Country.UKRAINE, 15, new ArrayList<String>());

        } else if(flowerType.equalsIgnoreCase("Rose")){
            return new Flower(FlowerType.Rose, Color.Red, 12, Odor.Good, Country.FRANCE, 25, new ArrayList<String>());
        }

        return null;
    }
}
