package com.discussion.community.algorithm;

import java.util.*;

public class ShowOrders {

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, HashMap<String, Integer>> orderMap = new TreeMap<>();
        Set<String> meals = new TreeSet<>();
        List<List<String>> res = new ArrayList<>();
        //name,table,meal
        for (List<String> customer : orders) {
            String meal = customer.get(2);
            meals.add(meal);

            Integer table = Integer.parseInt(customer.get(1));
            HashMap<String, Integer> order = orderMap.getOrDefault(table, new HashMap<>());
            order.put(meal, order.getOrDefault(meal, 0) + 1);
            orderMap.put(table, order);
        }
        ArrayList<String> head = new ArrayList<>(meals.size() + 1);
        head.add("Table");
        head.addAll(meals);
        res.add(head);
        for (Map.Entry<Integer, HashMap<String, Integer>> entry : orderMap.entrySet()) {
            List<String> menu = new ArrayList<>();
            menu.add(entry.getKey().toString());
            for (String meal : meals) {
                menu.add(entry.getValue().getOrDefault(meal, 0).toString());
            }
            res.add(menu);
        }
        return res;
    }
}
