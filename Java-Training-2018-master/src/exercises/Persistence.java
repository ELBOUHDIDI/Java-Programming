package exercises;


import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Persistence {

    public static void main(String[] args) {
        //testMySQL();
        testMongoDB();
    }

    static void testMySQL() {
        try {
            // LOAD CLASS MYSQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to load MySQL Driver");
        }

        Connection con;

        try {
            String jdbcUrl = "jdbc:mysql://localhost/test?serverTimezone=UTC";
            con = DriverManager.getConnection(jdbcUrl);
            if (con != null) {
                System.out.println("Connected to the database test");
            }

            String queryString = "SELECT * FROM USERS";
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery(queryString);

            while (rset.next()) {
                System.out.println("ID: " + rset.getString(1) +
                        " | NAME: " + rset.getString(2) +
                        " | AGE: " + rset.getString(3));
            }

            String insertString = "INSERT INTO `users`(`id`, `name`, `age`) VALUES (5,\"TEST\",99)";
            stmt = con.createStatement();
            int n = stmt.executeUpdate(insertString);

            System.out.println("New rows: " + n);

            rset.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    static void testMongoDB() {
        // Ref.: http://mongodb.github.io/mongo-java-driver/3.7/driver/tutorials/
        String user = "", pass = "", dbName = "", host = "";
        MongoCredential credential = MongoCredential.createCredential(user,
                dbName, pass.toCharArray());

        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(host, 61790))))
                        .credential(credential)
                        .build());

        MongoDatabase database = mongoClient.getDatabase("test-java");
        MongoCollection collection = database.getCollection("users");
        FindIterable<Document> res = collection.find();

        System.out.println("Documents in 'users'");
        for (Document r : res) {
            System.out.println(r.toString());
        }

        Document newUser = new Document("id", 3).append("name", "Sum41").append("age", 30);
        collection.insertOne(newUser); // Add it

        collection.deleteOne(new Document("id", 3)); // Delete it

        mongoClient.close();
    }
}
