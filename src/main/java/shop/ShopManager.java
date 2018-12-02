package shop;

import articles.Article;
import articles.Order;
import delivery.OrderProcessingError;
import discounts.Discount;
import discounts.Discount20;
import flowers.Flower;
import flowers.FlowerBucket;
import lombok.SneakyThrows;
import payment.CardPayment;
import payment.CashPayment;
import payment.PaymentContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShopManager {
    private static Scanner sc = new Scanner(System.in);


    public boolean askIfDefault(){
        String question = "Do you want to choose from default bouquets?";
        return getAnswer(question);
    }

    public void meetClient(){
        System.out.println("Welcome to FlowerShop.\n" +
                "Here you can buy a separate flower\n" +
                "choose from available bouquets\n" +
                "or create your own bouquet.");
    }

    public boolean worksWithClient(){
        return getAnswer("Do you want anything else? (yes or no)");
    }

    public boolean finishClient(ArrayList<Article> orderedItems) throws OrderProcessingError {
        System.out.println("Take a look on what you've ordered: ")
        ;System.out.println(orderedItems);
        String paymentType;
        String deliveryWay;
        String deliveryAddress;

        Order order = new Order();
        order.setItems(orderedItems);

        System.out.println("Thanks for visiting us today. In total, you have to pay: " + order.getTotalPrice());
        System.out.println("Here, you can pay with credit card or cash.");
        boolean cash = getAnswer("Do you want to pay with cash? (yes or no)" );

        if (cash) {
            paymentType = "cash";
        } else{
            paymentType = "card";
        }

        order.setPayment(paymentType);

        System.out.println("Good.");
        boolean delivery = getAnswer("Do you need to use delivery services to bring your order somewhere?");
        if (delivery){
            deliveryAddress = getStringAnswer("What's the adress to deliver?");
            System.out.println("We have 3 delivery services so far.\nNova Poshta, UkrPoshta, and DHL.");
            if (getAnswer("Do you prefer NovaPoshta? (yes or no)")){
                deliveryWay = "NovaPoshta";
            } else if (getAnswer("Do you prefer UkrPoshta? (yes or no)")){
                deliveryWay = "UkrPoshta";
            } else {
                System.out.println("Good, DHL is the only choice then.");
                deliveryWay = "DHL";
            }
        } else {
            deliveryWay = "";
            deliveryAddress = "";
        }

        order.setDelivery(deliveryWay);

        boolean discount = getAnswer("Do you have our discount?");
        if (discount){
            Discount discountOrder = new Discount20(order);
            if (discountOrder.process(deliveryAddress)) {
                System.out.println("Thanks for coming. Bye!");
                return true;
            } else {
                throw new OrderProcessingError();
            }
        } else {
            if (order.process(deliveryAddress)) {
                System.out.println("Thanks for coming. Bye!");
                return true;
            } else {
                throw new OrderProcessingError();
            }
        }
    }


    public boolean firstQuestion(){
        return getAnswer("Do you want to buy a bouquet? (yes or no)");
    }


    public Article sellItem(Article item){
        System.out.println("\nHere is your last order: ");
        System.out.println(item);
        System.out.println("\nThe price is " + item.getPrice());
        return item;
    }

    public int chooseFlower(ArrayList<Flower> availableFlowers) {
        System.out.println("\nHere are all the available flowers: ");
        for (Flower avail: availableFlowers){
            System.out.println(availableFlowers.indexOf(avail) + " " + avail);
        }

        System.out.println("\nPlease enter index of the flower you want: ");

        return getIndex(availableFlowers.size());
    }

    public int chooseBucket(ArrayList<FlowerBucket> availableBuckets){
        System.out.println("\nHere are all the available bouquets: ");

        for (FlowerBucket bucket: availableBuckets){
            System.out.println( bucket + "\nIndex: " + availableBuckets.indexOf(bucket));
        }
        System.out.println("\nPlease enter index of the bouquet you want: ");

        return getIndex(availableBuckets.size());
    }


    public List<Integer> createBucket(ArrayList<Flower> available){

        System.out.println("Let's create your  own bucket");
        System.out.println("Here are the flowers available now");
        for (Flower avail: available){
            System.out.println(available.indexOf(avail) + " " + avail);
        }

        System.out.println("Please enter indexes of flowers you want separated with spaces: ");
        return getIndexList();

    }


    public boolean getAnswer(String question){
        String answer = "";
        while ( ! (answer.equals("no") || answer.equals("yes"))){
            System.out.println(question);
            answer = sc.nextLine();}

        return answer.equals("yes");
    }

    public String getStringAnswer(String question){
        System.out.println(question);
        return sc.nextLine();
    }

    public int getIndex(int maxInt){
        Scanner sc = new Scanner(System.in);
        String index = String.valueOf(maxInt);
        while (Integer.parseInt(index) >= maxInt)  {
            System.out.println("Enter valid index: ");
            index = sc.nextLine();}

        return Integer.parseInt(index);
    }

    @SneakyThrows
    public List<Integer> getIndexList(){
        List<Integer> indexes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  lines = br.readLine();

        String[] strs = lines.trim().split("\\s+");

        for (int i = 0; i < strs.length; i++) {
            indexes.add(Integer.parseInt(strs[i]));
        }
        return indexes;
    }
}

