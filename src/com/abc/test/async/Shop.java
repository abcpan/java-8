package com.abc.test.async;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Shop
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/30 20:20
 */
public class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {
    }

    public Future<Double> getPriceAsync (String product){
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(()->{
//            try{
//                double price = calcPrice(product);
//                futurePrice.complete(price);
//            }catch (Exception e){
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        return futurePrice;

        //重构版
        return CompletableFuture.supplyAsync(()->this.calcPrice(product));
    }
    public static void delay(){
        try{
            Thread.sleep(1000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    private double calcPrice(String product){
        delay();
        return new Random().nextDouble() * product.charAt(0) * product.charAt(1);
    }
}
