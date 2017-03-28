package familie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RepoSum
{
    private String fileName;
    private Integer sum;




    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
        saveData();
    }

    public RepoSum(String fileName) {
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


    /*
     * incarca datele din fisier in repository
     */
    public void loadData() throws FileNotFoundException{
        try {
            String line;
            BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(fileName)));

            line = reader.readLine();
            if (line != null)
            {
                sum=Integer.parseInt(line);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveData(){
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

            String line =  sum.toString() + "\n";
            writer.write(line);

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
