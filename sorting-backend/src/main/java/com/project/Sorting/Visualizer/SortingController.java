package com.project.Sorting.Visualizer;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SortingController {

    // Insertion Sort with intermediate steps
    @PostMapping("/sort/insertion")
    public List<List<Integer>> insertionSort(@RequestBody List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(array); // Create a copy to avoid modifying the original list
        steps.add(new ArrayList<>(arr)); // Add initial state to steps

        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j)); // Shift element to the right
                j--;
            }
            arr.set(j + 1, key);
            steps.add(new ArrayList<>(arr)); // Add each step to the steps list
        }
        return steps;
    }

    // Bubble Sort with intermediate steps
    @PostMapping("/sort/bubble")
    public List<List<Integer>> bubbleSort(@RequestBody List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(array); // Create a copy to avoid modifying the original list
        steps.add(new ArrayList<>(arr)); // Add initial state to steps

        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // Swap elements
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    steps.add(new ArrayList<>(arr)); // Add each step to the steps list
                }
            }
        }
        return steps;
    }
}
