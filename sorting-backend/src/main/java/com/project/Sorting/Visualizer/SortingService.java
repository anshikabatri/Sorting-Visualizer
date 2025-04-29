package com.project.Sorting.Visualizer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public List<List<Integer>> getBubbleSortSteps(List<Integer> input) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(input); // Clone input

        steps.add(new ArrayList<>(arr)); // Initial state

        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // Swap
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);

                    // Record step
                    steps.add(new ArrayList<>(arr));
                }
            }
        }

        return steps;
    }
}
