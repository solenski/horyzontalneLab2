package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    private static ArrayList<Integer> initalizeSet(int elementCount)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i =0 ; i< elementCount ; i++ )
        {
            a.add(random.nextInt());
        }
        return a;
    }
    private static Random random = new Random();

    private static Set<Integer> set10 = new HashSet<Integer>(initalizeSet(10));
    private static Set<Integer> set100 = new HashSet<Integer>(initalizeSet(100));
    private static Set<Integer> set1000 = new HashSet<Integer>(initalizeSet(1000));
    private static Set<Integer> set10000 = new HashSet<Integer>(initalizeSet(10000));


    public static void main(String[] args) throws Exception {
	    Benchmark<Integer> bm = new Benchmark<Integer>();
        StringBuilder sb = new StringBuilder();
	    sb.append("set10 adding");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10.add(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10 removing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10.remove(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10 browsing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10.forEach(x-> {}); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10 checking");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10.contains(20); return null;} , 10 ).time);
        sb.append("\n");

        sb.append("set100 adding");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set100.add(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set100 removing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set100.remove(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set100 browsing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set100.forEach(x-> {}); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set100 checking");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set100.contains(20); return null;} , 10 ).time);
        sb.append("\n");


        sb.append("set1000 adding");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set1000.add(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set1000 removing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set1000.remove(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set1000 browsing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set1000.forEach(x-> {}); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set1000 checking");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set1000.contains(20); return null;} , 10 ).time);
        sb.append("\n");

        sb.append("set10000 adding");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10000.add(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10000 removing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10000.remove(20); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10000 browsing");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10000.forEach(x-> {}); return null;} , 10 ).time);
        sb.append("\n");
        sb.append("set10 checking");
        sb.append("\n");
        sb.append(bm.TestMean( () -> {set10000.contains(20); return null;} , 10 ).time);
        sb.append("\n");

        Files.write(Paths.get("doc.txt"), sb.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

    }
}
