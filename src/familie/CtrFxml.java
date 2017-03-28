
package familie;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CtrFxml implements Observer
{
    @FXML
    private TableView<Chelt> table ;


    @FXML
    private TableColumn <Chelt,String> tip;

    @FXML
    private TableColumn <Chelt,String> descriere;

    @FXML
    private TableColumn <Chelt,Integer> suma;

    @FXML
    private TableColumn <Chelt,String> membru;

    @FXML
    private Button generate;

    @FXML
    private Button add;

    @FXML
    private TextField tipNou;

    @FXML
    private ChoiceBox t;

    @FXML
    private TextField sumaNoua;

    @FXML
    private TextField descrNou;

    @FXML
    private Label sum;

    private Ctr ctr;

    private String membruCurent;

    private RepoSum rep;

    ObservableList<Chelt> model;


    /**
     * seteaza tipul coloanelor
     */
    @FXML
    private void initialize() {

        tip.setCellValueFactory(new PropertyValueFactory<Chelt,String>("tip"));
        descriere.setCellValueFactory(new PropertyValueFactory<Chelt,String>("descr"));
        membru.setCellValueFactory(new PropertyValueFactory<Chelt,String>("membru"));
        suma.setCellValueFactory(new PropertyValueFactory<Chelt,Integer>("suma"));
        t.setItems(FXCollections.observableArrayList(
                "Distractie", "Hrana ",
                "Imbracaminte", "Cosmetice", "cheltuieli")
            );

    }

    /**
     *
     * @param ctr controller grasp
     * incarca datele in tabel cu datele din lista din controller
     *
     */
    public void setCtr( Ctr ctr, String m, RepoSum r) {
        this.ctr=ctr;
        membruCurent = m;
        rep=r;
        sum.setText(r.getSum().toString());
        model = FXCollections.observableArrayList((List<Chelt>)ctr.getList());
        table.setItems(model);
    }

    @Override
    public void update(){
        model.setAll(ctr.getList());
        sum.setText(rep.getSum().toString());
    }

    @FXML
    public void handleAdd(){
        if (Integer.parseInt(sum.getText()) >= Integer.parseInt(sumaNoua.getText())){
            ctr.addChelt(t.getValue().toString(), Integer.parseInt(sumaNoua.getText()), descrNou.getText(), membruCurent);
            rep.setSum(Integer.parseInt(sum.getText()) - Integer.parseInt(sumaNoua.getText()));
            ctr.notifyObservers();

        }

    }

    @FXML
    public void handleGenerate(){
        Stage stage= new Stage();
        Label l = new Label("Suma cheltuita pe "+t.getValue().toString() + " este "+ ctr.getSum(t.getValue().toString()).toString());
        Scene scene = new Scene(l);
        stage.setScene(scene);
        stage.setTitle(t.getValue().toString());
        stage.show();

    }
}
