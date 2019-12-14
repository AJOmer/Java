package com.codingdojo.javaspring.phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String ringing = getRingTone();
        return ringing;
    }
    @Override
    public String unlock() {
        return "Unlocked";
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy batterylife: "+ getBatteryPercentage()+ "Galaxy version number: "+ getVersionNumber()+"Galaxy carrier "+ getCarrier());
    }
}
