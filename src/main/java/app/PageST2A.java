package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageST2A implements Handler {

    public static final String URL = "/page2A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");

        // Add some Head information
        htmlBuilder.append("<head>")
                .append("<title>Subtask 2.1</title>")
                .append("<link rel='stylesheet' type='text/css' href='styles.css' />")
                .append("</head>");

        // Add the body
        htmlBuilder.append("<body>");

        // Add the topnav
        htmlBuilder.append("""
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
            </div>
        """);

        // Add header content block
        htmlBuilder.append("""
            <div class='header'>
                <h1>Subtask 2.A</h1>
            </div>
        """);

        // Add Div for page Content
        htmlBuilder.append("<div class='content'>");

        // Add HTML for the page content
        htmlBuilder.append("""
            <h2>Welcome to our Website!</h2>
            <p>Here, you will find information about population and temperature data.</p>
        """);
        // Add an Image
        htmlBuilder.append("""
            <div class='content'>
                <img src='https://images.unsplash.com/photo-1552799446-159ba9523315?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80' alt='Ocean and Land Temperature' style='display: block; margin: 0 auto; border: 1px solid #ccc; width: 100%; max-width: 800px; height: auto;'>
            </div>
        """);
        // Retrieve the available year range for population and temperature data
        int firstYear = getFirstYearFromDatabase(); // Implement this method to get the first year from your database
        int lastYear = getLastYearFromDatabase(); // Implement this method to get the last year from your database

        // Retrieve the corresponding world population and temperature during these years
        double worldPopulationFirstYear = getWorldPopulationForYear(firstYear); // Implement this method to get the world population for a specific year
        double worldPopulationLastYear = getWorldPopulationForYear(lastYear); // Implement this method to get the world population for a specific year
        double temperatureFirstYear = getTemperatureForYear(firstYear); // Implement this method to get the temperature for a specific year
        double temperatureLastYear = getTemperatureForYear(lastYear); // Implement this method to get the temperature for a specific year

        // Calculate the total number of years of available data
        int totalYears = lastYear - firstYear + 1;

        // Display the information to the user
        htmlBuilder.append("<h3>Data Summary:</h3>")
                .append("<p>Year Range for Available Data: ")
                .append(firstYear)
                .append(" - ")
                .append(lastYear)
                .append("</p>")
                .append("<p>World Population during this Period: ")
                .append(worldPopulationFirstYear)
                .append(" - ")
                .append(worldPopulationLastYear)
                .append("</p>")
                .append("<p>Temperature during this Period: ")
                .append(temperatureFirstYear)
                .append(" - ")
                .append(temperatureLastYear)
                .append("</p>")
                .append("<p>Total Number of Years of Available Data: ")
                .append(totalYears)
                .append("</p>");

        // Close Content div
        htmlBuilder.append("</div>");
        
        // Footer
        htmlBuilder.append("""
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """);

        // Add CSS Styles
        htmlBuilder.append("""
            <style>
                /* Define your custom CSS styles here */
                body {
                    background-color: #f2f2f2;
                    font-family: Arial, sans-serif;
                }
                .topnav {
                    background-color: #333;
                    overflow: hidden;
                }
                .topnav a {
                    float: left;
                    color: #f2f2f2;
                    text-align: center;
                    padding: 14px 16px;
                    text-decoration: none;
                    font-size: 17px;
                }
                .topnav a:hover {
                    background-color: #ddd;
                    color: black;
                }
                .topnav a.active {
                    background-color: #4CAF50;
                    color: white;
                }
                .header {
                    background-color: #f1f1f1;
                    padding: 20px;
                    text-align: center;
                }
                .content {
                    background-color: #fff;
                    padding: 20px;
                    margin: 20px;
                }
                .footer {
                    background-color: #f1f1f1;
                    padding: 20px;
                    text-align: center;
                }
            </style>
        """);

        

        // Finish the HTML webpage
        htmlBuilder.append("</body>").append("</html>");

        // Makes Javalin render the webpage
        context.html(htmlBuilder.toString());
    }

    // Implement the required methods to retrieve data from the database and external sources
    private int getFirstYearFromDatabase() {
        // Implement the logic to retrieve the first year from your database
        return 1750; // Replace with actual implementation
    }

    private int getLastYearFromDatabase() {
        // Implement the logic to retrieve the last year from your database
        return 2013; // Replace with actual implementation
    }

    private double getWorldPopulationForYear(int year) {
        double result = year++*2.14;
        return Double.parseDouble(String.format("%.4f", result));
    }

    private double getTemperatureForYear(int year) {
        double result=year/91;
        // Implement the logic to retrieve the temperature for a specific year from an external source or database
        return result; // Replace with actual implementation
    }
}
