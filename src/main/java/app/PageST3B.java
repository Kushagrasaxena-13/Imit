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
public class PageST3B implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3B.html";

     @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a StringBuilder
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");

        // Add some Head information
        htmlBuilder.append("<head>")
                .append("<title>Subtask 3.2</title>")
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
                <h1>Subtask 3.B</h1>
            </div>
        """);

        // Add Div for page Content
        htmlBuilder.append("<div class='content'>");

        // Add HTML for the page content
        htmlBuilder.append("""
            <h2>Find Similar Time Periods</h2>
            <form id='similarity-form'>
                <label for='start-year'>Starting Year:</label>
                <input type='number' id='start-year' name='start-year' min='1750' max='2013' required><br><br>

                <label for='time-period'>Time Period (in years):</label>
                <input type='number' id='time-period' name='time-period' min='1' required><br><br>

                <label for='region'>Geographic Region:</label>
                <select id='region' name='region' required>
                    <option value='country'>Country</option>
                    <option value='state'>State</option>
                    <option value='city'>City</option>
                </select><br><br>

                <label for='similarity-type'>Similarity Type:</label>
                <select id='similarity-type' name='similarity-type' required>
                    <option value='temperature'>Temperature</option>
                    <option value='population'>Population</option>
                    <option value='temperature-population'>Temperature and Population</option>
                </select><br><br>

                <label for='similarity-measure'>Similarity Measure:</label>
                <select id='similarity-measure' name='similarity-measure' required>
                    <option value='absolute'>Absolute Values</option>
                    <option value='relative'>Relative Change</option>
                </select><br><br>

                <label for='number-of-regions'>Number of Similar Regions:</label>
                <input type='number' id='number-of-regions' name='number-of-regions' min='1' required><br><br>

                <button type='submit'>Find Similar Regions</button>
            </form>

            <div id='result'></div>

            <script>
                const similarityForm = document.getElementById('similarity-form');
                similarityForm.addEventListener('submit', function(event) {
                    event.preventDefault();

                    // Retrieve form values
                    const startYear = parseInt(document.getElementById('start-year').value);
                    const timePeriod = parseInt(document.getElementById('time-period').value);
                    const region = document.getElementById('region').value;
                    const similarityType = document.getElementById('similarity-type').value;
                    const similarityMeasure = document.getElementById('similarity-measure').value;
                    const numberOfRegions = parseInt(document.getElementById('number-of-regions').value);

                    // Perform calculations and display results
                    const similarRegions = findSimilarRegions(startYear, timePeriod, region, similarityType, similarityMeasure, numberOfRegions);
                    displayResult(similarRegions);
                });

                function findSimilarRegions(startYear, timePeriod, region, similarityType, similarityMeasure, numberOfRegions) {
                    // TODO: Implement the logic to find similar regions based on the selected criteria
                    // Return an array of objects containing the details of the similar regions
                }

                function displayResult(similarRegions) {
                    // Display the result in the 'result' div
                    const resultDiv = document.getElementById('result');
                    resultDiv.innerHTML = '';

                    if (similarRegions.length === 0) {
                        resultDiv.innerHTML = 'No similar regions found.';
                    } else {
                        const resultList = document.createElement('ul');
                        for (const region of similarRegions) {
                            const regionItem = document.createElement('li');
                            regionItem.textContent = `Region: ${region.name}, Start Year: ${region.startYear}, End Year: ${region.endYear}, Similarity Score: ${region.similarityScore}`;
                            resultList.appendChild(regionItem);
                        }
                        resultDiv.appendChild(resultList);
                    }
                }
            </script>
        """);

        // Close Content div
        htmlBuilder.append("</div>");

        // Footer
        htmlBuilder.append("""
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """);

        // Finish the HTML webpage
        htmlBuilder.append("</body>").append("</html>");

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(htmlBuilder.toString());
    }
}
