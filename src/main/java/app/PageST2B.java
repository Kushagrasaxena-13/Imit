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
public class PageST2B implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2B.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a StringBuilder
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");

        // Add some Head information
        htmlBuilder.append("<head>")
                .append("<title>Subtask 2.2</title>")
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
                <h1>Subtask 2.B</h1>
            </div>
        """);

        // Add Div for page Content
        htmlBuilder.append("<div class='content'>");

        // Add HTML for the page content
        htmlBuilder.append("""
            <h2>Social Challenge</h2>
            <p>Our website addresses the social challenge by focusing on a specific issue and providing a platform for awareness, education, and action. Through the targeted content and features, we aim to raise awareness about the social challenge and its impact on individuals and communities. We provide reliable information, data, and resources to educate users about the issue, its causes, and potential solutions. The website also facilitates community engagement and encourages users to take action through various initiatives, such as volunteering, signing petitions, or donating to relevant organizations. By connecting users with like-minded individuals and providing opportunities for collective action, our website promotes a sense of empowerment and encourages positive social change.</p>
            <h2>Usage</h2>
            <p>Users can utilize the website to analyze temperature patterns by accessing the relevant features and tools available. The website provides interactive charts, graphs, and visualizations that display temperature data over time. Users can input specific parameters such as date range, geographical location, and temperature units to customize their analysis. The website also offers data filtering options, allowing users to focus on specific variables or regions of interest. Users can compare temperature trends, identify patterns, and observe changes over different time periods. Additionally, the website may provide additional functionalities such as data overlays, trend predictions, and anomaly detection to enhance the analysis capabilities. By leveraging these tools, users can gain insights into temperature patterns, monitor climate changes, and make informed decisions related to climate adaptation and mitigation strategies.</p>
            <h2>Personas</h2>
    <div class='personas'>
        <div class='persona'>
            <img src='https://iosonofrancis.files.wordpress.com/2017/06/unspecified_fotor444.jpg' alt='Persona 1: Tony Edward' onclick="showDetails('tony')" style='width: 100px; height: 100px; border-radius: 50%;'>
            <p>Persona 1: Tony Edward</p>
        </div>
        <div class='persona'>
            <img src='https://c.pxhere.com/photos/a6/37/portrait_mamiya_film_kodak_medium_format_portra_k_z_pform_tum-192094.jpg!d' alt='Persona 2: David John' onclick="showDetails('david')" style='width: 100px; height: 100px; border-radius: 50%;'>
            <p>Persona 2: David John</p>
        </div>
        <div class='persona'>
            <img src='https://th.bing.com/th/id/R.6e3b89eae2d14b54b307512f8af49aaa?rik=%2fLAsbhWa7riK1A&riu=http%3a%2f%2fmaspark.org%2fwp-content%2fuploads%2f2014%2f07%2fYoung-Male-Student.jpg&ehk=S3S9w0hIgvCOjOOQgFLrZn4SxO4mU7CGAzn23wH0N5g%3d&risl=&pid=ImgRaw&r=0' alt='Persona 3: Kushar Bajaj' onclick="showDetails('kushar')" style='width: 100px; height: 100px; border-radius: 50%;'>
            <p>Persona 3: Kushar Bajaj</p>
        </div>
    </div>
            <h2>Team Members</h2>
            <ul>
                <li>Team Member 1 - Student Number 12345678</li>
                <li>Team Member 2 - Student Number 87654321</li>
                <li>Team Member 3 - Student Number 98765432</li>
            </ul>
            """);
        
        // Close Content div
        htmlBuilder.append("</div>");
        htmlBuilder.append("""
    <script>
        function showDetails(persona) {
            if (persona === 'tony') {
                // Display details for Persona 1 (Tony Edward)
                alert('Name: Tony Edward\\n\\nDescription/Attributes:\\n\\n• Tony is 35 years old, and he is Australian.\\n• He is married for 15 years and has 2 children.\\n• He is a marine engineer and working.\\n• Do consistent in discussion.\\n• His father was a marine worker, and he loved the sea and water animals, and his childhood was on coastal areas.\\n\\nNeeds:\\n\\nTony is debating climate change deniers and wants to change their views and show just how endangered our world is, and he wants it.\\n• He got all the relevant and reliable information on the website because he doesn’t have time to do his own research.\\n• Dynamic graphics that can touch people’s emotions, Tony believes that deniers may not like the science of climate change and showing them the effects through images can help.\\n• The website must be easy to navigate during the presentation because it is quite technical.\\n\\nGoals:\\n\\n• He wants to convince climate change deniers that climate change is real and pervasive.\\n• He wants to contribute to minimizing the damage caused by climate change.\\n• He is trying to protect all aquatic animals and their habitats.\\n\\nSkills/Experience:\\n\\n• Have a master’s in marine engineering.\\n• He is persuasive.\\n• He already has work experience.');
            } else if (persona === 'david') {
                // Display details for Persona 2 (David John)
                alert('Name: David John\\n\\nDescription/Attributes:\\n\\n• He is 27 years old single.\\n• He is curious and likes to learn new things.\\n• Friendly and use every opportunity to help those in need and he is caring.\\n• He works part-time at Coles while studying for his Bachelor’s in Climate Science at Deakin University.\\n• He is Australian\\n\\nNeeds:\\n\\nDavid has a project due soon in which he needs to find climate change and the effects and the reason for the increasing of ocean temperature.\\n• Need to create relevant data that shows temperature changes in various oceans.\\n• Websites that provide this data.\\n• Need to create a website about climate change and make it easy for everyone to understand.\\n\\nGoals:\\n\\n• David wants to finish his project on time and get a good grade.\\n• Wants to reduce the death of water animals because of the various changes of climate change and differences in ocean temperature.\\n• Wants to do Masters.\\n\\nSkills:\\n\\n• Skilled with researching and studying new things with the help of the Internet.\\n• Has experience in making a website and knows coding.');
            } else if (persona === 'kushar') {
                // Display details for Persona 3 (Kushar Bajaj)
                alert('Name: Kushar Bajaj\\n\\nDescription/Attributes:\\n\\n• He is 20 years old single.\\n• He is curious and likes to learn new things about the environment.\\n• Friendly in Nature and loves planting trees in his free time.\\n• He works part-time at NGO while studying for his Bachelor’s in Environmental Science at Indian Institute of Technology, Delhi.\\n• He is an Indian.\\n\\nNeeds:\\n\\nKushar has a press conference due soon about climate change, so he needs to find climate change and the effects and the reason for the increasing of ocean temperature.\\n• He needs to find out about the data regarding climate change.\\n• Need to create a website about climate change and make it easy for everyone to understand.\\n\\nGoals:\\n\\n• Wants to reduce the death of water animals because of the various changes of climate change and differences in ocean temperature.\\n• He wants to make his own organization that is working solely on climate change and increasing ocean temperatures.\\n\\nSkills:\\n\\n• Skilled Public speaker.\\n• Knows the emotion of the masses and knows how to meld the thinking of the youth.');
            }
        }
    </script>
""");


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
