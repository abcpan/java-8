package com.abc.test.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Test
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/30 20:30
 */
public class Test {
    public static void main(String[] args) {
        findPrices();
        testFuture();
    }

    public static void print(){
        for(int i = 0 ;i<20000;i++){
            System.out.println("我在执行相关任务");
        }
    }
    public static void testFuture(){
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> futureResult = shop.getPriceAsync("beef and tomato");
        long invocationTime = (System.nanoTime()-start)/1_000_000;
        System.out.println("invocation returned after " + invocationTime + "mecs");
        //print();

        //计算商品价格的同时
        try {
            double  price = 0;
            price = futureResult.get(2000L, TimeUnit.SECONDS);
            System.out.println("取到计算结果===>"+ price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (TimeoutException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start)/1_000_000;
        System.out.println("price return after " + retrievalTime + " msecs");
    }
    public static void findPrices(){
        long start = System.nanoTime();
        List<Shop> shops = Arrays.asList(
            new Shop("wangfujing"),
            new Shop("chunxilu"),
            new Shop("waitan"),
            new Shop("jiefangbei")
        );
        List<Future<Double>> prices = shops.stream().map(shop->shop.getPriceAsync("women")).collect(Collectors.toList());


//        prices.parallelStream().forEach(price-> {
//            try {
//                Double value = price.get();
//                System.out.println(value);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
        long performanceTime = (System.nanoTime()-start)/1_000_000;
        System.out.println("time is ===>"+performanceTime);
    }
}
