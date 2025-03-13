package com.mtgapp.mtgapp;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardInfoAPI {

    public static void fetchDeckInfo(Deck deck) {

    }

    public static void getCardInfo(Card card) throws IOException {

            OkHttpClient client = new OkHttpClient();
            String url = "https://api.scryfall.com/cards/named?fuzzy=" + card.getName().replace(" ", "+");
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();

            // Parse JSON
            Gson gson = new Gson();
            Card cardInfo = gson.fromJson(jsonData, Card.class);

            card.copyFrom(cardInfo);

            // Raw fetch the image URL from JSON
            Pattern pattern = Pattern.compile("\"large\":\"(https://[^\"]+)\"");
            Matcher matcher = pattern.matcher(jsonData);
            if (matcher.find()) {
                String largeImageUrl = matcher.group(1);
                card.setImage_uri(largeImageUrl);
            } else {
                System.err.println("Large image URL not found");
            }

            System.out.println("Card info for: " + cardInfo.getName() + " imported successfully.");

/*
        String largeImageUrl = card.getImageUris().getLarge();
        System.out.println("Large Image URL: " + largeImageUrl);

 */
    }


    public static void main(String[] args) throws IOException {

    }


}
