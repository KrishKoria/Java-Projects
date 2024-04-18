package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fitness_Assessment_GUI extends JFrame {
    private JTextField ageField, genderField, heightField, weightField;
    private JButton assessButton;
    private JTextArea resultArea;

    public Fitness_Assessment_GUI() {
        setTitle("Health-related Fitness Assessment");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10)); // Added horizontal and vertical gaps for spacing

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gender (M/F):");
        genderField = new JTextField();
        JLabel heightLabel = new JLabel("Height (cm):");
        heightField = new JTextField();
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();

        assessButton = new JButton("Assess");
        assessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assessFitness();
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        mainPanel.add(ageLabel);
        mainPanel.add(ageField);
        mainPanel.add(genderLabel);
        mainPanel.add(genderField);
        mainPanel.add(heightLabel);
        mainPanel.add(heightField);
        mainPanel.add(weightLabel);
        mainPanel.add(weightField);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(assessButton);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(scrollPane);

        add(mainPanel);
    }

    private void assessFitness() {
        try {
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            // Perform fitness assessment calculations
            String assessmentResult = performAssessment(age, gender, height, weight);

            // Display assessment result
            resultArea.setText(assessmentResult);
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter valid numbers for age, height, and weight.");
        }
    }

    private String performAssessment(int age, String gender, double height, double weight) {
        // Perform a comprehensive fitness assessment
        double bmi = calculateBMI(height, weight);
        String bmiCategory = determineBMICategory(bmi);
        double bmr = calculateBMR(age, gender, height, weight);
        double dailyCalories = calculateDailyCalories(bmr);

        StringBuilder assessmentResult = new StringBuilder();
        assessmentResult.append("<html><body><h1>Fitness Assessment Results</h1>");
        assessmentResult.append("<ul>");
        assessmentResult.append("<li><strong>Age:</strong> ").append(age).append(" years</li>");
        assessmentResult.append("<li><strong>Gender:</strong> ").append(gender).append("</li>");
        assessmentResult.append("<li><strong>Height:</strong> ").append(height).append(" cm</li>");
        assessmentResult.append("<li><strong>Weight:</strong> ").append(weight).append(" kg</li><br>");
        assessmentResult.append("<li><strong>BMI:</strong> ").append(String.format("%.2f", bmi)).append(" (").append(bmiCategory).append(")</li>");
        assessmentResult.append("<li><strong>Basal Metabolic Rate (BMR):</strong> ").append(String.format("%.2f", bmr)).append(" calories/day</li>");
        assessmentResult.append("<li><strong>Daily Calorie Requirement:</strong> ").append(String.format("%.2f", dailyCalories)).append(" calories/day</li>");
        assessmentResult.append("</ul>");

        // Provide personalized recommendations based on assessment
        assessmentResult.append("<h2>Recommendations</h2><ul>");
        if (bmiCategory.equals("Overweight") || bmiCategory.equals("Obese")) {
            assessmentResult.append("<li>Focus on a balanced diet with reduced calorie intake.</li>");
            assessmentResult.append("<li>Incorporate regular exercise, including cardiovascular and strength training.</li>");
        } else if (bmiCategory.equals("Underweight")) {
            assessmentResult.append("<li>Increase calorie intake with nutrient-dense foods.</li>");
            assessmentResult.append("<li>Include healthy fats, proteins, and carbohydrates in your diet.</li>");
        } else {
            assessmentResult.append("<li>Maintain a balanced diet and regular exercise routine for overall health.</li>");
        }
        assessmentResult.append("</ul></body></html>");

        return assessmentResult.toString();
    }

    private double calculateBMI(double height, double weight) {
        // Calculate BMI (Body Mass Index)
        return weight / ((height / 100) * (height / 100)); // Height in meters
    }

    private String determineBMICategory(double bmi) {
        // Determine BMI category based on BMI value
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private double calculateBMR(int age, String gender, double height, double weight) {
        // Calculate Basal Metabolic Rate (BMR)
        // Use Harris-Benedict equation
        double bmr;
        if (gender.equalsIgnoreCase("M")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
        return bmr;
    }

    private double calculateDailyCalories(double bmr) {
        // Calculate Daily Calorie Requirement based on BMR
        // Adjust for activity level
        // For simplicity, let's assume moderate activity level
        return bmr * 1.55;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fitness_Assessment_GUI().setVisible(true);
            }
        });
    }
}