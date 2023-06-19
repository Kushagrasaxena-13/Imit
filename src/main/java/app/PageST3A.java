package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST3A implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3A.html";

     @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a StringBuilder
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");

        // Add some Head information
        htmlBuilder.append("<head>")
                .append("<title>Subtask 3.1</title>")
                .append("<link rel='stylesheet' type='text/css' href='common.css' />")
                .append("</head>");

        // Add the body
        htmlBuilder.append("<body>");

        // Add the topnav
        // This uses a Java v15+ Text Block
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
                <h1>Subtask 3.A</h1>
            </div>
        """);

        // Add Div for page Content
        htmlBuilder.append("<div class='content'>");

        // Add HTML for the page content
        htmlBuilder.append("""
            <h2>Calculate Average Temperature</h2>
            <form id='temperature-form'>
                <label for='start-year'>Starting Year:</label>
                <input type='number' id='start-year' name='start-year' min='1750' max='2013' required><br><br>

                <label for='time-period'>Time Period (in years):</label>
                <input type='number' id='time-period' name='time-period' min='1' required><br><br>

                <label for='region'>Geographic Region:</label>
                <select id='region' name='region' required>
                    <option value='global'>Global</option>
                    <option value='country'>Country</option>
                    <option value='state'>State</option>
                    <option value='city'>City</option>
                </select><br><br>

                <button type='submit'>Calculate</button>
            </form>

            <div id='result'></div>
            """);

        // Close Content div
        htmlBuilder.append("</div>");

        // Footer
        htmlBuilder.append("""
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """);

        // Add JavaScript code
        htmlBuilder.append("""
            <script>
                document.getElementById('temperature-form').addEventListener('submit', function(event) {
                    event.preventDefault(); // Prevent form submission

                    // Get form values
                    const startYear = parseInt(document.getElementById('start-year').value);
                    const timePeriod = parseInt(document.getElementById('time-period').value);
                    const region = document.getElementById('region').value;

                    // TODO: Perform calculations and display results
                    const averageTemperature = calculateAverageTemperature(startYear, timePeriod, region);
                    displayResult(averageTemperature);
                });

                function calculateAverageTemperature(startYear, timePeriod, region) {
                    // TODO: Implement the average temperature calculation based on the inputs
                    // Return the calculated average temperature
                }

                function displayResult(averageTemperature) {
                    // Display the result in the 'result' div
                    document.getElementById('result').innerHTML = 'Average Temperature: ' + averageTemperature;
                }
            </script>
        """);

        // Finish the HTML webpage
        htmlBuilder.append("</body>").append("</html>");

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(htmlBuilder.toString());
    }


}
