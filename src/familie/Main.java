package familie;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application
{

    static ArrayList<String> s=new ArrayList<String>();

        public void createStage(Ctr ctr, String membru, RepoSum r) throws IOException{
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("chelt.fxml.fxml"));
            AnchorPane h = (AnchorPane) loader.load();
            CtrFxml taskCtr = loader.getController();
            taskCtr.setCtr(ctr, membru, r);

            ctr.addObserver(taskCtr);
            Stage stage= new Stage();
            Scene scene = new Scene(h);
            stage.setScene(scene);
            stage.setTitle(membru);
            stage.show();
        }
        @Override
        public void start(Stage stage) throws Exception {


            Repo rep = new Repo("src/familie/chelt.txt");
            RepoSum r = new RepoSum("src/familie/suma.txt");

            Ctr ctr = new Ctr(rep);
            for (String i:s){
                createStage(ctr, i,r);
            }




        }

        public static void main (String a[]) throws Exception{



                s.add("nico");


            launch(a);


        }
    }


