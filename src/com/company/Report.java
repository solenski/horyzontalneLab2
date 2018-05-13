package com.company;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

public class Report {
    private HashMap<String, Callable<BenchmarkActionResult>> Measures;

    public Report(HashMap<String, Callable<BenchmarkActionResult>> measures) {
        this.Measures = measures;
    }

    public String TestAndReport() {
        StringBuilder sb = new StringBuilder();
        HashMap<String, BenchmarkActionResult> results = new HashMap<String, BenchmarkActionResult>();
        this.Measures.forEach((k, v) -> {
            sb.append(k + " ");
            try {
                BenchmarkActionResult test = v.call();
                results.put(k, test);
                sb.append(test.time);

            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append("\n");
        });
        sb.append("\n");
        return sb.toString();
    }

}
