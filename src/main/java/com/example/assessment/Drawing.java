package com.example.assessment;

import java.util.ArrayList;
import java.util.List;

// Question 2: Drawing
public class Drawing {
    public String[] colours;
    public String[] shapes;

    public static class Art {
        public String colour;
        public String shape;

        public Art(String colour, String shape) {
            this.colour = colour;
            this.shape = shape;
        }
    }

    public Drawing(String[] colours, String[] shapes) {
        this.colours = colours;
        this.shapes = shapes;
    }

    // Implementing the mix() method to return all combinations
    public List<Art> mix() {
        List<Art> combinations = new ArrayList<>();
        for (String colour : colours) {
            for (String shape : shapes) {
                combinations.add(new Art(colour, shape));
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        // Initializing test data
        Drawing draw = new Drawing(
                new String[]{"red", "blue"},
                new String[]{"circle"}
        );

        // Calling the mix method to get combinations
        List<Art> mixes = draw.mix();

        // Printing the combinations
        System.out.println("Combinations:");
        for (Art art : mixes) {
            System.out.println(art.colour + ", " + art.shape);
        }
    }
}
