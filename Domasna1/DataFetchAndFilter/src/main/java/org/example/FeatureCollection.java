package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureCollection {
    public String type;
    public List<Feature> features;

    public static class Feature {
        public String type;
        public Properties properties;
        public Geometry geometry;
    }

    public static class Properties {
        public String name;
        public String country;
        public String country_code;
        public String state;
        public String county;
        public String city;
        public String municipality;
        public String postcode;
        public String suburb;
        public String street;
        public double lon;
        public double lat;
        public String formatted;
        public String address_line1;
        public String address_line2;
        public List<String> categories;
        public List<String> details;
        public DataSource datasource;
    }

    public static class Geometry {
        public String type;
        public List<Double> coordinates;
    }

    public static class DataSource {
        public String sourcename;
        public String attribution;
        public String license;
        public String url;
        public RawData raw;
    }

    public static class RawData {
        public String name;
        public long osm_id;
        @JsonProperty("name:en")
        public String nameEn;
        public String tourism;
        public String historic;
        @JsonProperty("int_name")
        public String intName;
        @JsonProperty("osm_type")
        public String osmType;
        public String wikidata;
        public String wikipedia;
        @JsonProperty("historic:period")
        public String historicPeriod;
        @JsonProperty("historic:civilization")
        public String historicCivilization;
    }
}
