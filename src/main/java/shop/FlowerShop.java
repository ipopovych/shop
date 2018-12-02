package shop;

import articles.Article;
import delivery.OrderProcessingError;
import flowers.*;
import lombok.Getter;
import payment.PaymentContext;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Getter
public class FlowerShop {
    private int defaultBucketSize = 10;
    private double revenue = 0;
    public ShopManager manager = new ShopManager();
    private ArrayList<FlowerBucket> defaultBuckets;
    private ArrayList<Flower> availableFlowers;

    public FlowerShop() {
        this.availableFlowers = new ArrayList<>();
        this.defaultBuckets = new ArrayList<>();
        addDefaultBuckets();
        addDefaultFlowers();
    }

    private void addDefaultFlowers() {
        FlowerFactory flowerMaker = new FlowerFactory();
        for (int i = 0; i < 5; i++) {
            this.availableFlowers.add(flowerMaker.getDefaultFlower("Chamomile"));
            this.availableFlowers.add(flowerMaker.getDefaultFlower("Rose"));
            this.availableFlowers.add(flowerMaker.getDefaultFlower("Tulip"));
        }
    }

    private void addDefaultBuckets(){
        BucketCreator bucketCreator = new BucketCreator();
        this.defaultBuckets.add(bucketCreator.getChamomileBucket(defaultBucketSize));
        this.defaultBuckets.add(bucketCreator.getRoseBucket(defaultBucketSize));
        this.defaultBuckets.add(bucketCreator.getTulipBucket(defaultBucketSize));
        this.defaultBuckets.add(bucketCreator.getMixedBucket(defaultBucketSize));
    }

    public FlowerBucket sellBucket(){
        FlowerBucket bucket;
        if(manager.askIfDefault()){
             int index = manager.chooseBucket(this.defaultBuckets);
             bucket = this.defaultBuckets.get(index);
             this.defaultBuckets.remove(index);

        } else {
            List<Integer> bucketFlowers = manager.createBucket(availableFlowers);
            bucket = new FlowerBucket();
            for (Integer index: bucketFlowers){
                bucket.add_flower(availableFlowers.get(index));
            }

            // remove flowers that were bought with the formed bucket
            bucketFlowers.sort(Comparator.reverseOrder());
            bucketFlowers.stream().mapToInt(i -> i).forEach(availableFlowers::remove);
        }

        revenue += manager.sellItem(bucket).getPrice();
        return bucket;
    }

    public Flower sellFlower(){
        int flowerIndex = manager.chooseFlower(availableFlowers);
        Flower flower = availableFlowers.get(flowerIndex);
        availableFlowers.remove(flowerIndex);
        revenue += manager.sellItem(flower).getPrice();
        return flower;
    }

    public void introduction() {
        manager.meetClient();
    }

    public Article interact() {
        Article item;

        boolean wantsBucket = manager.firstQuestion();
        if (wantsBucket){
            item = sellBucket();
        } else{
            item = sellFlower();
        }
        return item;
    }

    public ArrayList<Article> meetClient(){
        ArrayList<Article> items = new ArrayList<>();

        introduction();
        Article item = interact();

        items.add(item);

        while (manager.worksWithClient()){
            item = interact();
            items.add(item);
        }
        try {
            manager.finishClient(items);
        } catch (OrderProcessingError orderProcessingError) {
            orderProcessingError.printStackTrace();
            System.out.println("Sorry, order processing failed");
        }

        return items;
    }

}