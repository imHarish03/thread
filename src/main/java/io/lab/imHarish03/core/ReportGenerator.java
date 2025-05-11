package io.lab.imHarish03.core;

class ReportGenerator extends Thread {
    public void run() {
        System.out.println("Generating report...");
        try {
            Thread.sleep(5000); // Simulate long operation
        } catch (InterruptedException e) {
            System.out.println("Report generation interrupted");
        }
        System.out.println("Report generated.");
    }
}
