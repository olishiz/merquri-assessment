package com.example.assessment;

// Question 1: Game Platform
public class GamePlatform {

    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;

        for (int inclination : inclinations) {
            if (inclination < 0) {
                // Speed increases for negative inclinations (downhill)
                speed += Math.abs(inclination); // Add the full value of the inclination
            } else if (inclination > 0) {
                // Speed decreases for positive inclinations (uphill)
                speed -= inclination; // Subtract the full value of the inclination
            }
            // Flat terrain (inclination == 0) does not change speed
        }

        return speed;
    }

    public static void main(String[] args) {
        // Test the method with the given inclinations
        System.out.println("Result: " + getFinalSpeed(60.0, new int[]{0, -30, 0, 45, 0})); // Should print 45.0
    }
}
