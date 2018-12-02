package flowers;

import articles.Article;
import lombok.Getter;

import java.util.ArrayList;


@Getter
public class FlowerBucket extends Article {
    public double price;
    public int size;
    public ArrayList<Flower> bucket;

    public FlowerBucket(){
        this.bucket = new ArrayList<>();
    }
    public void add_flower(Flower flower) {
        price += flower.getPrice();
        bucket.add(flower);
        size += 1;
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("\n\nFlowerBucket:" +
                "\nprice: " + price +
                "\nflowers: " );
        for (Flower flower: bucket){
            b.append( " • ");
            b.append(flower.getType());
            b.append( " • ");
        }
        return b.toString();
    }
}