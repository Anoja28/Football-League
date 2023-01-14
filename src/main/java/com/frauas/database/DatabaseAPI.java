package com.frauas.database;

import java.time.Instant;
import java.time.ZoneId;
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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
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

    private static List<Player> getPlayers(MongoCursor<Document> cursor) {
        List<Player> players = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                players.add(new Player(
                        doc.getObjectId(doc),
                        doc.getString("firstName"),
                        doc.getString("lastName"),
                        Team.valueOf(doc.getString("team")),
                        doc.getInteger("number"),
                        Position.valueOf(doc.getString("position")),
                        Instant.ofEpochMilli(doc.getDate("birthDate").getTime()).atZone(ZoneId.systemDefault())
                                .toLocalDate(),
                        doc.getString("nationality")));
            }
        } finally {
            cursor.close();
        }

        return players;
    }

    public static List<Player> getPlayers() {
        connect();
        MongoCollection<Document> collection = database.getCollection("players");

        MongoCursor<Document> cursor = collection.find()
                .sort(Sorts.descending("firstName")).iterator();

        return getPlayers(cursor);
    }

    public static List<Player> getPlayers(Team team) {
        connect();
        MongoCollection<Document> collection = database.getCollection("players");

        MongoCursor<Document> cursor = collection.find()
                .filter(Filters.eq("team", team.name()))
                .sort(Sorts.descending("firstName")).iterator();

        return getPlayers(cursor);
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

    public static boolean editPlayer(Player player) {
        connect();

        MongoCollection<Document> collection = database.getCollection("players");
        try {
            Document result = collection.findOneAndUpdate(
                    Filters.eq("_id", player.id),
                    Updates.combine(
                            Updates.set("firstName", player.firstName),
                            Updates.set("lastName", player.lastName),
                            Updates.set("team", player.team.name()),
                            Updates.set("number", player.number),
                            Updates.set("position", player.position.name()),
                            Updates.set("birthDate", player.birthDate),
                            Updates.set("nationality", player.nationality)));
            System.out.println("Upserted id: " + result.get("_id"));
            return true;
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
            return false;
        }
    }
}
