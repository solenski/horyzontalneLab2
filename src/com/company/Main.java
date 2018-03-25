package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Main {

    private static ArrayList<Integer> initalizeRandom(int elementCount)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i =0 ; i< elementCount ; i++ )
        {
            a.add(random.nextInt());
        }
        return a;
    }
    private static Random random = new Random();

    private static Set<Integer> set10 = new HashSet<Integer>(initalizeRandom(10));
    private static Set<Integer> set100 = new HashSet<Integer>(initalizeRandom(100));
    private static Set<Integer> set1000 = new HashSet<Integer>(initalizeRandom(1000));
    private static Set<Integer> set10000 = new HashSet<Integer>(initalizeRandom(10000));

    private static List<Integer> list10 = new ArrayList<Integer>(initalizeRandom(10));
    private static List<Integer> list100 = new ArrayList<Integer>(initalizeRandom(100));
    private static List<Integer> list1000 = new ArrayList<Integer>(initalizeRandom(1000));
    private static List<Integer> list10000 = new ArrayList<Integer>(initalizeRandom(10000));

    private static Queue<Integer> queue10 = new ArrayDeque<Integer>(initalizeRandom(10));
    private static Queue<Integer> queue100 = new ArrayDeque<Integer>(initalizeRandom(100));
    private static Queue<Integer> queue1000 = new ArrayDeque<Integer>(initalizeRandom(1000));
    private static Queue<Integer> queue10000 = new ArrayDeque<Integer>(initalizeRandom(10000));


    public static void main(String[] args) throws Exception {
	    Benchmark<Integer> bm = new Benchmark<Integer>();
        StringBuilder sb = new StringBuilder();
        MeasureAndSave(bm, sb, "set10 adding", set10, "set10 removing", "set10 browsing", "set10 checking");

        MeasureAndSave(bm, sb, "set100 adding", set100, "set100 removing", "set100 browsing", "set100 checking");


        MeasureAndSave(bm, sb, "set1000 adding", set1000, "set1000 removing", "set1000 browsing", "set1000 checking");

        MeasureAndSave(bm, sb, "set10000 adding", set10000, "set10000 removing", "set10000 browsing", "set10 checking");

        Files.write(Paths.get("doc.txt"), sb.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

    }

    private static void MeasureAndSave(Benchmark<Integer> bm, StringBuilder sb, String s, List<Integer> set, String s2, String s3, String s4) throws Exception {
        sb.append(s);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.add(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s2);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.remove(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s3);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.forEach(x -> {
            });
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s4);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.contains(20);
            return null;
        }, 10).time);
        sb.append("\n");
    }

    private static void MeasureAndSave(Benchmark<Integer> bm, StringBuilder sb, String s, Queue<Integer> queue, String s2, String s3, String s4) throws Exception {
        sb.append(s);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            queue.add(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s2);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            queue.remove(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s3);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            queue.forEach(x -> {
            });
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s4);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            queue.contains(20);
            return null;
        }, 10).time);
        sb.append("\n");
    }


    private static void MeasureAndSave(Benchmark<Integer> bm, StringBuilder sb, String s, Set<Integer> set, String s2, String s3, String s4) throws Exception {
        sb.append(s);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.add(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s2);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.remove(20);
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s3);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.forEach(x -> {
            });
            return null;
        }, 10).time);
        sb.append("\n");
        sb.append(s4);
        sb.append("\n");
        sb.append(bm.TestMean(() -> {
            set.contains(20);
            return null;
        }, 10).time);
        sb.append("\n");
    }
}
