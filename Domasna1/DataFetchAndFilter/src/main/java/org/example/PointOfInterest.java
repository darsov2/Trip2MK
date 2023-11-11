package org.example;

import java.util.List;


public class PointOfInterest {
    String type;
    String name;
    String nameEn;
    String country;
    String country_code;
    String state;
    String county;
    String city;
    String municipality;
    String postcode;
    String suburb;
    String street;
    double lon;
    double lat;
    String formatted;
    String addressLine1;
    String addressLine2;
    long osmId;
    String wikiData;
    public List<String> categories;

    public PointOfInterest(String type, String name, String nameEn, String country, String country_code, String state, String county, String city, String municipality, String postcode, String suburb, String street, double lon, double lat, String formatted, String addressLine1, String addressLine2, long osmId, String wikiData, List<String> categories) {
        this.type = type;
        this.name = name;
        this.nameEn = nameEn;
        this.country = country;
        this.country_code = country_code;
        this.state = state;
        this.county = county;
        this.city = city;
        this.municipality = municipality;
        this.postcode = postcode;
        this.suburb = suburb;
        this.street = street;
        this.lon = lon;
        this.lat = lat;
        this.formatted = formatted;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.osmId = osmId;
        this.wikiData = wikiData;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "PointOfInterest{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", county='" + county + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }

    public String toCsv() {
        StringBuilder csvBuilder = new StringBuilder();

        csvBuilder.append(escapeCsvField(type)).append(",");
        csvBuilder.append(escapeCsvField(name)).append(",");
        csvBuilder.append(escapeCsvField(nameEn)).append(",");
        csvBuilder.append(escapeCsvField(country)).append(",");
        csvBuilder.append(escapeCsvField(country_code)).append(",");
        csvBuilder.append(escapeCsvField(state)).append(",");
        csvBuilder.append(escapeCsvField(county)).append(",");
        csvBuilder.append(escapeCsvField(city)).append(",");
        csvBuilder.append(escapeCsvField(municipality)).append(",");
        csvBuilder.append(escapeCsvField(postcode)).append(",");
        csvBuilder.append(escapeCsvField(suburb)).append(",");
        csvBuilder.append(escapeCsvField(street)).append(",");
        csvBuilder.append(lon).append(",");
        csvBuilder.append(lat).append(",");
        csvBuilder.append(escapeCsvField(formatted)).append(",");
        csvBuilder.append(escapeCsvField(addressLine1)).append(",");
        csvBuilder.append(escapeCsvField(addressLine2)).append(",");
        csvBuilder.append(osmId).append(",");
        csvBuilder.append(escapeCsvField(wikiData));

        return csvBuilder.toString();
    }
    private static String escapeCsvField(String field) {
        if (field == null) {
            return "";
        }
        if (field.contains(",")) {
            return "\"" + field + "\"";
        }
        return field;
    }
}
