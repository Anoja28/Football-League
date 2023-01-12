package com.frauas.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.frauas.models.Player;
import com.frauas.models.Position;
import com.frauas.models.Team;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.InsertOneResult;

public class DatabaseAPI {
    public static MongoDatabase database;
    public static String PASSWORD = "CNfAKHj4jjX6BsSZ";

    private static void connect() {
        if (database != null) {
            return;
        }

        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://mevius:" + PASSWORD + "@cluster0.ck8vntk.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("football-league");
    }

    public static List<Player> getPlayers() {
        connect();
        List<Player> players = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("players");

        MongoCursor<Document> cursor = collection.find()
                .sort(Sorts.descending("firstName")).iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                players.add(new Player(doc.getString("firstName"), doc.getString("lastName"),
                        Team.valueOf(doc.getString("team")), doc.getInteger("number"),
                        Position.valueOf(doc.getString("position"))));
            }
        } finally {
            cursor.close();
        }

        return players;
    }

    public static boolean createPlayer(Player player) {
        connect();

        MongoCollection<Document> collection = database.getCollection("players");
        try {
            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("firstName", player.firstName)
                    .append("lastName", player.lastName)
                    .append("team", player.team.name())
                    .append("number", player.number)
                    .append("position", player.position.name())
                    .append("birthDate", player.birthDate)
                    .append("nationality", player.nationality));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
            return true;
        } catch (MongoException me) {
            System.err.println("Unable to insert due to an error: " + me);
            return false;
        }
    }
}
