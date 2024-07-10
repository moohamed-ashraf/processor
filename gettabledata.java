// import java.awt.TextField;
// import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class gettabledata {
 
    static TableView<PlayerData> tableView = new TableView<>();


    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // Block interactions with other windows until this one is closed
        window.setTitle("Player Data");
        window.setMinWidth(500);
        window.setMaxWidth(500);
        window.setMaxHeight(500);


        // Define columns for the player names and scores
        TableColumn<PlayerData, String> name1Column = new TableColumn<>("first name");
        name1Column.setMinWidth(200);
        name1Column.setCellValueFactory(new PropertyValueFactory<>("player1"));

        TableColumn<PlayerData, String> name2Column = new TableColumn<>("last name");
        name2Column.setMinWidth(200);
        name2Column.setCellValueFactory(new PropertyValueFactory<>("player2"));

        TableColumn<PlayerData, Integer> score1Column = new TableColumn<>("Score");
        score1Column.setMinWidth(100);
        score1Column.setCellValueFactory(new PropertyValueFactory<>("score1"));

        TableColumn<PlayerData, Integer> score2Column = new TableColumn<>("total");
        score2Column.setMinWidth(100);
        score2Column.setCellValueFactory(new PropertyValueFactory<>("score2"));


        //Name input
        //TextField playerinput = new TextField();
        //playerinput.setPromptText("name");



        // Add columns to the TableView
        tableView.getColumns().add(name1Column);
        tableView.getColumns().add(name2Column);
        tableView.getColumns().add(score1Column);
        tableView.getColumns().add(score2Column);



        // Populate the TableView
        tableView.setItems(getData());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(tableView);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }



    public static ObservableList<PlayerData> getData() {
        ObservableList<PlayerData> players = FXCollections.observableArrayList();
        players.add(new PlayerData("lol", "Ashraf", 15, 20));
        players.add(new PlayerData("Ali", "Hassan", 10, 12));
        return players;
    }


    public static class PlayerData {
        private String player1;
        private String player2;
        private int score1;
        private int score2;


        public PlayerData(String player1, String player2, int score1, int score2) {
            this.player1 = player1;
            this.player2 = player2;
            this.score1 = score1;
            this.score2 = score2;
        }

        public String getPlayer1() { return player1; }
        public void setPlayer1(String player1) { this.player1 = player1; }


        public String getPlayer2() { return player2; }
        public void setPlayer2(String player2) { this.player2 = player2; }


        public int getScore1() { return score1; }
        public void setScore1(int score1) { this.score1 = score1; }


        public int getScore2() { return score2; }
        public void setScore2(int score2) { this.score2 = score2; }
    }
}
