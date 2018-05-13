package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.Callable;

public class Main {

    private static ArrayList<Integer> initalizeRandom(int elementCount) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < elementCount; i++) {
            a.add(random.nextInt());
        }
        return a;
    }

    private static Random random = new Random();

    private static HashSet<Integer> set10 = new HashSet<Integer>(initalizeRandom(10));
    private static HashSet<Integer> set100 = new HashSet<Integer>(initalizeRandom(100));
    private static HashSet<Integer> set1000 = new HashSet<Integer>(initalizeRandom(1000));
    private static HashSet<Integer> set10000 = new HashSet<Integer>(initalizeRandom(10000));



    private static ArrayList<Integer> list10 = new ArrayList<Integer>(initalizeRandom(10));
    private static ArrayList<Integer> list100 = new ArrayList<Integer>(initalizeRandom(100));
    private static ArrayList<Integer> list1000 = new ArrayList<Integer>(initalizeRandom(1000));
    private static ArrayList<Integer> list10000 = new ArrayList<Integer>(initalizeRandom(10000));

    private static ArrayDeque<Integer> queue10 = new ArrayDeque<Integer>(initalizeRandom(10));
    private static ArrayDeque<Integer> queue100 = new ArrayDeque<Integer>(initalizeRandom(100));
    private static ArrayDeque<Integer> queue1000 = new ArrayDeque<Integer>(initalizeRandom(1000));
    private static ArrayDeque<Integer> queue10000 = new ArrayDeque<Integer>(initalizeRandom(10000));


    public static void main(String[] args) throws Exception {
        Benchmark<Integer> bm = new Benchmark<Integer>();
        StringBuilder sb = new StringBuilder();
        sb.append(Measure(bm, set10, "HashSet").TestAndReport());
        sb.append(Measure(bm, set100, "HashSet").TestAndReport());
        sb.append(Measure(bm, set1000, "HashSet").TestAndReport());
        sb.append(Measure(bm, set10000, "HashSet").TestAndReport());

        sb.append(Measure(bm, list10).TestAndReport());
        sb.append(Measure(bm, list100).TestAndReport());
        sb.append(Measure(bm, list1000).TestAndReport());
        sb.append(Measure(bm, list10000).TestAndReport());

        sb.append(Measure(bm, queue10).TestAndReport());
        sb.append(Measure(bm, queue100).TestAndReport());
        sb.append(Measure(bm, queue1000).TestAndReport());
        sb.append(Measure(bm, queue10000).TestAndReport());
        Files.write(Paths.get("doc.txt"), sb.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

    }

    private static Report Measure(Benchmark<Integer> bm, ArrayList<Integer> list) throws Exception {
        return new Report(new HashMap<String, Callable<BenchmarkActionResult>>() {{
            put("list" + list.size() + " adding at the beginning", () -> bm.TestMean(() -> {
                list.add(0, 20);
                return null;
            }, 10));
            put("list" + list.size() + " adding at the end", () -> bm.TestMean(() -> {
                list.add(20);
                return null;
            }, 10));
            put("list" + list.size() + " adding at random place", () -> bm.TestMean(() -> {
                list.add(Math.abs(random.nextInt()) % list.size(), 20);
                return null;
            }, 10));
            put("list" + list.size() + " removing from beginning", () -> bm.TestMean(() -> {
                list.remove(0);
                return null;
            }, 10));
            put("list" + list.size() + " removing from end", () -> bm.TestMean(() -> {
                list.remove(list.size() - 1);
                return null;
            }, 10));
            put("list" + list.size() + " removing from random", () -> bm.TestMean(() -> {
                list.remove(Math.abs(random.nextInt()) % list.size());
                return null;
            }, 10));
            put("list" + list.size() + " browsing using indexes", () -> bm.TestMean(() -> {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i);
                }
                return null;
            }, 10));
            put("list" + list.size() + " browsing using iterator", () -> bm.TestMean(() -> {
                list.forEach(x -> {
                });
                return null;
            }, 10));
        }});
    }

    private static Report Measure(Benchmark<Integer> bm, ArrayDeque<Integer> queue) throws Exception {
        return new Report(new HashMap<String, Callable<BenchmarkActionResult>>() {{
            put("queue" + queue.size() + " adding at the beginning", () -> bm.TestMean(() -> {
                queue.addFirst(20);
                return null;
            }, 10));
            put("queue" + queue.size() + " adding at the end", () -> bm.TestMean(() -> {
                queue.addLast(20);
                return null;
            }, 10));

            put("queue" + queue.size() + " removing from beginning", () -> bm.TestMean(() -> {
                queue.remove(0);
                return null;
            }, 10));
            put("queue" + queue.size() + " removing from end", () -> bm.TestMean(() -> {
                queue.remove(queue.size() - 1);
                return null;
            }, 10));
            put("queue" + queue.size() + " browsing using indexes", () -> bm.TestMean(() -> {
                for (int i = 0; i < queue.size(); i++) {
                    queue.poll();
                }
                return null;
            }, 10));
            put("queue" + queue.size() + " browsing using iterator", () -> bm.TestMean(() -> {
                queue.forEach(x -> {
                });
                return null;
            }, 10));
        }});
    }

    private static Report Measure(Benchmark<Integer> bm, Set<Integer> set, final String name) throws Exception {
        return new Report(new HashMap<String, Callable<BenchmarkActionResult>>() {{
            put(name + set.size() + " adding", () -> bm.TestMean(() -> {
                set.add(20);
                return null;
            }, 10));
            put(name + set.size() + " removing", () -> bm.TestMean(() -> {
                set.remove(20);
                return null;
            }, 10));
            put(name + set.size() + " browsing", () -> bm.TestMean(() -> {
                set.forEach(x -> {
                });
                return null;
            }, 10));
            put(name + set.size() + " checking", () -> bm.TestMean(() -> {
                set.contains(20);
                return null;
            }, 10));
        }});
    }
}
