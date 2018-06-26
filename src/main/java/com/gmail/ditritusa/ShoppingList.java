package com.gmail.ditritusa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoppingList {
    private List<Product> products = new ArrayList<Product>();
    private CurrencyConvertor cc = new CurrencyConvertor();
    private DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());


    public void add(String[] splited) {
        Product product = new Product();
        product.setDate(LocalDate.parse(splited[1]));
        product.setAmount(Double.parseDouble(splited[2]));
        product.setCurrency(splited[3]);
        if (splited.length == 6) {
            product.setProduct(splited[4] + " " + splited[5]);

        } else {
            product.setProduct(splited[4]);
        }
        products.add(product);
        System.out.println("Added");

    }

    public void list() {
        formatSymbols.setDecimalSeparator('.');
        formatSymbols.setGroupingSeparator(' ');

        DecimalFormat df = new DecimalFormat("##.##", formatSymbols);

        if (products.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Product product : products) {

                System.out.print(product.getDate());
                System.out.println();
                System.out.print(product.getProduct() + " " + df.format(product.getAmount()) + " " + product.getCurrency());
                System.out.println();
                System.out.println();
            }
        }

    }

    public void convertor(String fromCurrency) {
        formatSymbols.setDecimalSeparator('.');
        formatSymbols.setGroupingSeparator(' ');

        DecimalFormat df = new DecimalFormat("##.##", formatSymbols);

        double conversionRate;
        double amount;
        double result = 0.0;
        for (Product product : products) {
            conversionRate = cc.convert(fromCurrency, product.getCurrency());
            amount = product.getAmount();
            result += conversionRate * amount;
        }
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        result = bd.doubleValue();
        System.out.println(df.format(result) + " EUR");


    }

    public void clear(String date) {
        products.removeIf(product -> product.getDate().equals(LocalDate.parse(date)));
        System.out.println("Removed");

    }

}
