package flowers;

import articles.Article;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Flower extends Article {
    private FlowerType type;
    private Color color;
    private double lenghtOfStem;
    private Odor odor;
    private Country countryOfOrigin;


    public Flower(FlowerType type, Color color, double lenghtOfStem, Odor odor, Country countryOfOrigin, double price, ArrayList<String> specialAttributes) {
        this.type = type;
        this.color = color;
        this.lenghtOfStem = lenghtOfStem;
        this.odor = odor;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.specialAttributes = specialAttributes;
    }

    @Override
    public String toString() {
        return " Flower: " +
                "type = " + type +
                " • color = " + color +
                " • lenghtOfStem = " + lenghtOfStem +
                " • odor = " + odor +
                " • countryOfOrigin = " + countryOfOrigin +
                " • price = " + price +
                " • specialAttributes = " + specialAttributes +
                '\n';
    }
}




