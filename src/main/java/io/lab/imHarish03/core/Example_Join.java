package io.lab.imHarish03.core;

public class Example_Join {
    public static void main(String[] args) {
        ReportGenerator report = new ReportGenerator();
        report.start();

        try {
            report.join(); // Wait until report generation is finished
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Sending report to user now...");
    }
}
