package shop;

import flowers.FlowerBucket;

public class BucketCreator {
    FlowerFactory flowerFactory = new FlowerFactory();

    public FlowerBucket getTulipBucket(int size){
        FlowerBucket tulipBucket = new FlowerBucket();
        for(int i = 0; i < size; i ++){
            tulipBucket.add_flower(flowerFactory.getDefaultFlower("Tulip"));
        }
        return tulipBucket;
    }

    public FlowerBucket getRoseBucket(int size){
        FlowerBucket roseBucket = new FlowerBucket();
        for(int i = 0; i < size; i ++){
            roseBucket.add_flower(flowerFactory.getDefaultFlower("Rose"));
        }
        return roseBucket;
    }

    public FlowerBucket getChamomileBucket(int size){
        FlowerBucket chamomileBucket = new FlowerBucket();
        for(int i = 0; i < size; i ++){
            chamomileBucket.add_flower(flowerFactory.getDefaultFlower("Chamomile"));
        }
        return chamomileBucket;
    }

    public FlowerBucket getMixedBucket(int size){
        FlowerBucket mixedBucket = new FlowerBucket();

        int subsize = size/3;

        for(int i = 0; i < subsize; i ++){
            mixedBucket.add_flower(flowerFactory.getDefaultFlower("Chamomile"));
            mixedBucket.add_flower(flowerFactory.getDefaultFlower("Rose"));
            mixedBucket.add_flower(flowerFactory.getDefaultFlower("Tulip"));
        }

        for(int i = 0; i < size - (subsize*3); i ++){
            mixedBucket.add_flower(flowerFactory.getDefaultFlower("Chamomile"));
        }
        return mixedBucket;
    }
}


