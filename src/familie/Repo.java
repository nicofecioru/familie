package familie;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;




public class Repo {
    protected ArrayList<Chelt> all = new ArrayList<Chelt>();
    private String fileName;

    public Repo(String fileName) {
        super();
        this.fileName = fileName;
        try
        {
            loadData();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return vectorul de elemente
     */
    public ArrayList<Chelt> getAll() {

        return all;
    }

    /**
     * adauga un obiect  in lista
     * @param s: Chelt el de adaugat in lista
     * @throws MyException
     */
    public void addEl(Chelt s){

        all.add(s);
        saveData();
    }

    /**
     * sterge el de pe pozitia poz
     * @param id: int id ul de pe care va fi sters elementul
     * @throws MyException
     */
    public void removeEl(int id) {
        int poz = findById(id);
        all.remove(poz);
        saveData();
    }

    public int findById(int id){

        for (int i=0; i<all.size(); i++){
            if (all.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    /*
     * incarca datele din fisier in repository
     */
    public void loadData() throws FileNotFoundException{
        try {
            String line;
            BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(fileName)));
            do {
                line = reader.readLine();
                if (line != null)
                {
                    StringTokenizer st = new StringTokenizer(line, "|");
                    if (st.countTokens() == 5){
                        try{

                            Chelt f = new Chelt(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken());
                            all.add(f);
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                    }
                }
            } while (line != null);
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     *
     * @return int dimensiunea vectorului
     */
    public int getLength() {
        return all.size();
    }


    public void saveData(){
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (Chelt f : all)
            {
                String line =  f.getId().toString() +"|" + f.getTip() + "|" +f.getSuma().toString() + "|" + f.getDescr() + "|" + f.getMembru()+ "\n";
                writer.write(line);
            }
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                throw e;
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
