package com.assessment;

import com.assessment.model.Fruit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please provide the csv file path");
            System.exit(1);
        }

        String filePath = args[0];
        File file = new File(filePath);

        Map<Fruit, Integer> fruits = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.lines().skip(1).forEach(line -> {
                String[] columns = line.split(",");
                Fruit fruit = parseFruit(columns);

                int size = fruits.getOrDefault(fruit, 0);
                fruits.put(fruit, size + Integer.parseInt(columns[1].trim()));
            });
        } catch (FileNotFoundException e) {
            System.err.println("File not found : " + filePath);
            System.exit(1);
        }

        printTotalFruits(fruits);
        printTypesOfFruits(fruits);
        printNumberOfTypesOfFruits(fruits);
        printCharacteristics(fruits);
        printOlderFruits(fruits);
    }

    private static void printOlderFruits(Map<Fruit, Integer> fruits) {
        System.out.println("\nHave any fruit been in the basket for over 3 days");
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> nameToSizeMap = new HashMap<>();
        for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            Fruit fruit = entry.getKey();
            if (fruit.getDays() > 3) {
                int size = nameToSizeMap.getOrDefault(fruit.getName(), 0);
                nameToSizeMap.put(fruit.getName(), size + entry.getValue());
            }
        }

        boolean first = true;
        for (Map.Entry<String, Integer> entry : nameToSizeMap.entrySet()) {
            String name = entry.getKey();
            int size = entry.getValue();
            if (!first) {
                sb.append(" and ");
            }
            sb.append(size).append(" ").append(name).append(size > 1 ? "s" : "");
            first = false;
        }
        sb.append(" are over 3 days old");
        System.out.println(sb);
    }

    private static void printCharacteristics(Map<Fruit, Integer> fruits) {
        System.out.println("\nThe characteristics (size, color, shape, etc.) of each fruit by type");
        fruits.forEach((fruit, size) -> System.out.println(size + " " + fruit.getName() + ": " + fruit.getShape() + ", " + fruit.getColor() + ", " + fruit.getDays() + " days"));
    }

    private static void printNumberOfTypesOfFruits(Map<Fruit, Integer> fruits) {
        Map<String, Integer> nameToSizeMap = new HashMap<>();
        for (Map.Entry<Fruit, Integer> e : fruits.entrySet()) {
            int size = nameToSizeMap.getOrDefault(e.getKey().getName(), 0);
            nameToSizeMap.put(e.getKey().getName(), size + e.getValue());
        }
        System.out.println("\nThe number of each type of fruit in descending order");
        nameToSizeMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void printTypesOfFruits(Map<Fruit, Integer> fruits) {
        long types = fruits.keySet().stream().map(Fruit::getName).distinct().count();
        System.out.println("\nTypes of fruit: " + types);
    }

    private static void printTotalFruits(Map<Fruit, Integer> fruits) {
        int total = fruits.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nTotal number of fruit: " + total);
    }

    private static Fruit parseFruit(String[] columns) {
        return new Fruit(
                columns[0].trim(),
                columns[2].trim(),
                columns[3].trim(),
                Integer.parseInt(columns[4].trim())
        );
    }
}
