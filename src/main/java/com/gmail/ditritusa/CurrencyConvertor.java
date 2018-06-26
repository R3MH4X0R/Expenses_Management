package com.gmail.ditritusa;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class CurrencyConvertor {

    // API Provider URL
    private static final String API_PROVIDER = "http://data.fixer.io/api/latest?access_key=d13cb8e07cc3ad33c9cdcbc200f913bc&symbols=USD,EUR,PLN";

    public double convert(String fromCurrencyCode, String toCurrencyCode) {

        if ((fromCurrencyCode != null && !fromCurrencyCode.isEmpty())
                && (toCurrencyCode != null && !toCurrencyCode.isEmpty())) {

            CurrencyConversionResponse response = getResponse(API_PROVIDER);

            if (response != null) {

                String rate = response.getRates().get(toCurrencyCode);

                return Double.valueOf((rate != null) ? rate : "0.0");
            }

        }

        return 0.0;
    }

    // Method to get the response from API
    private static CurrencyConversionResponse getResponse(String strUrl) {

        CurrencyConversionResponse response = null;

        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();

        URL url;
        try {
            url = new URL(strUrl);

            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            InputStream stream = connection.getInputStream();

            int data = stream.read();

            while (data != -1) {

                sb.append((char) data);

                data = stream.read();
            }

            stream.close();

            response = gson.fromJson(sb.toString(), CurrencyConversionResponse.class);

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

}