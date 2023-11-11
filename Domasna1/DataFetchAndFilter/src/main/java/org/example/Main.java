package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.PipeAndFilter.Filter;
import org.example.PipeAndFilter.Pipe;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;



public class Main {

    public static List<PointOfInterest> getDataForCategory(String category)
    {
        try
        {
            URL url = new URL("https://api.geoapify.com/v2/places?categories=" + category + "&filter=rect:20.481057895411816,42.476142929772465,23.006820850389268,40.75021027841885&limit=500&apiKey=397af912864046059345cd7e6bbe3c06");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            String inline = "";
            BufferedReader scanner = new BufferedReader(new InputStreamReader(url.openStream()));
            inline = scanner.lines().collect(Collectors.joining("\n"));
            scanner.close();

            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            FeatureCollection featureCollection = objectMapper.readValue(inline, FeatureCollection.class);
            //  String s = jsonTree.get("name").asText();
            List<PointOfInterest> pois = featureCollection.features.stream()
                    .map(x -> new PointOfInterest("", x.properties.name, x.properties.datasource.raw.nameEn,
                            x.properties.country, x.properties.country_code, x.properties.state,
                            x.properties.county, x.properties.city, x.properties.municipality, x.properties.postcode,
                            x.properties.suburb, x.properties.street, x.properties.lat, x.properties.lon,
                            x.properties.formatted, x.properties.address_line1, x.properties.address_line2,
                            x.properties.datasource.raw.osm_id, x.properties.datasource.raw.wikidata, x.properties.categories)).collect(Collectors.toList());
            return pois;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }

    public static void convertToCsv(List<PointOfInterest> pois)
    {
        File csvFile = new File("out.csv");
        try {
            csvFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(csvFile, StandardCharsets.UTF_8)));
            pw.println("type,name,nameEn,country,country_code,state,county,city,municipality,postcode,suburb,street,lon,lat,formatted,addressLine1,addressLine2,osmId,wikiData");
            pois.stream().map(PointOfInterest::toCsv).forEach(pw::println);
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        File categories = new File("src\\osm_categories.txt");
        BufferedReader br = new BufferedReader(new FileReader(categories));
        List<PointOfInterest> pois = br.lines().map(Main::getDataForCategory).filter(Objects::nonNull).flatMap(Collection::stream).toList();

        Filter<PointOfInterest> deleteNullNames = x -> {
            if(x != null && (x.name !=null || x.nameEn != null))
            {
                return x;
            }
            return null;
        };

        Filter<PointOfInterest> deleteForeignPois = x -> {
            if(x != null && (x.country_code == null || x.country_code.equals("mk")))
            {
                return x;
            }
            return null;
        };

        Pipe<PointOfInterest> pipe = new Pipe<>();
        pipe.addFilter(deleteNullNames);
        pipe.addFilter(deleteForeignPois);

        //Zaradi ednostavnost se koristi stream biblioteka od Java so ist koncept - PointOfInterest objektite
        //od lista se pustaat niz potok kade pretrpuvaat odredeni transformacii (filtriranje, mapiranje)
        //i povtorno so sobiraat vo lista
        //List<PointOfInterest> customPipeAndFilter = pipe.runFilters(pois).stream().filter(Objects::nonNull).toList();


        List<PointOfInterest> filteredPois = pois.stream().filter(x -> x.name !=null || x.nameEn != null)
                .filter(x -> x.country_code == null || x.country_code.equals("mk")).toList();

        convertToCsv(filteredPois);

    }
}