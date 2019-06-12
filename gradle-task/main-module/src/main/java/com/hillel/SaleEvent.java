package com.hillel;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SaleEvent {

    private String id;
    private String streetAddress;
    private String city;

    public static void main(String[] args) {
        SaleEvent saleEvent = new SaleEvent();
        saleEvent.setId("100");
        saleEvent.setStreetAddress("123 Main St.");
        saleEvent.setCity("Naperville");

        System.out.println(saleEvent.toString());

        JsonDisplay jsonDisplay = new JsonDisplay();
        System.out.println(jsonDisplay.showJson(saleEvent));
    }
}
