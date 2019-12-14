package com.codingdojo.javaspring.phone;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
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
    	System.out.println("Iphone Battery percentage: "+ getBatteryPercentage()+ " Iphone Version number: "+ getVersionNumber()+"Iphone carrier: "+ getCarrier());
    }
}
