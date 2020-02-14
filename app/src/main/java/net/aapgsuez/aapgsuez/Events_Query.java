package net.aapgsuez.aapgsuez;

import android.text.TextUtils;
import android.util.Log;

import net.aapgsuez.aapgsuez.Objects.EventsObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Events_Query {
    /** Tag for the log messages */
    private static final String LOG_TAG = Events_Query.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link Events_Query} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private Events_Query() {
    }

    /**
     * Query the USGS dataset and return a list of {@link EventsLoader} objects.
     */
    public static List<EventsObject> fetchEventsData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Event}s
        List<EventsObject> events = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link Event}s
        return events;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }
    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the events JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }
    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
    /**
     * Return a list of {@link EventsObject} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<EventsObject> extractFeatureFromJson(String eventJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(eventJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding earthquakes to
        List<EventsObject> events = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(eventJSON);

            // Extract the JSONArray associated with the key called "Events",
            // which represents a list of events.
            JSONArray eventsArray = baseJsonResponse.getJSONArray("Events");

            // For each event in the eventArray, create an {@link Event} object
            for (int i = 0; i < eventsArray.length(); i++) {

                // Get a single events at position i within the list of events
                JSONObject currentevent = eventsArray.getJSONObject(i);


                String name = currentevent.getString("name");
                String date = currentevent.getString("date");
                String desc = currentevent.getString("description");
                String img = currentevent.getString("image");
                String url = currentevent.getString("link");

                // Create a new {@link Events} object with the name, date, desc,img
                // and url from the JSON response.
                EventsObject eventsObject = new EventsObject(name,date,desc,img,url);

                // Add the new {@link Event} to the list of events.
                events.add(eventsObject);
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the events JSON results", e);
        }

        // Return the list of events
        return events;
    }
}
