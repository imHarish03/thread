package io.lab.imHarish03.core;

class Buffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        System.out.println("Producing..."+Thread.currentThread().getName());
        while (available) {
            try { wait(); } catch (InterruptedException e) { }
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer
    }

    public synchronized void consume() {
        System.out.println("Consuming..."+Thread.currentThread().getName());
        while (!available) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // Notify the producer
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) buffer.produce(i);
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) buffer.consume();
        });

        producer.start();
        consumer.start();
    }
}
