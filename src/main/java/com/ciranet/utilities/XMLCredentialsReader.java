package com.ciranet.utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.ciranet.constants.Constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLCredentialsReader {

    public static class userCredentials {
        private String usertype;
        private String username;
        private String password;

        public userCredentials(String usertype, String username, String password) {
            this.usertype = usertype;
            this.username = username;
            this.password = password;
        }

        public String getUsertype() {
            return usertype;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "Usertype: " + usertype + ", Username: " + username + ", Password: " + password;
        }
    }

    public static List<userCredentials> readCredentials() throws Exception {
        List<userCredentials> credentialsList = new ArrayList<>();
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file from the classpath
            InputStream inputStream = XMLCredentialsReader.class.getClassLoader()
                    .getResourceAsStream(Constants.USER_CREDENTIALS_PATH);

            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + Constants.USER_CREDENTIALS_PATH);
            }

            // Parse the XML file and load it into a Document
            Document document = builder.parse(inputStream);

            // Normalize the XML structure
            document.getDocumentElement().normalize();

            // Get the list of <user> elements
            NodeList userList = document.getElementsByTagName("user");

            for (int i = 0; i < userList.getLength(); i++) {
                Node userNode = userList.item(i);

                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;

                    // Get the usertype, username and password elements
                    String usertype = userElement.getElementsByTagName("usertype").item(0).getTextContent();
                    String username = userElement.getElementsByTagName("username").item(0).getTextContent();
                    String password = userElement.getElementsByTagName("password").item(0).getTextContent();

                    // Add the credentials to the list
                    credentialsList.add(new userCredentials(usertype, username, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to handle it in calling methods
        }
        return credentialsList;
    }

    public static userCredentials findUserByUsername(String username) throws Exception {
        List<userCredentials> credentialsList = readCredentials();
        for (userCredentials credentials : credentialsList) {
            if (credentials.getUsername().equalsIgnoreCase(username)) {
                return credentials;
            }
        }

        throw new RuntimeException("User does not exist: " + username);
    }  
}