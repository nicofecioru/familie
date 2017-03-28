package familie;

import java.util.ArrayList;



public class Ctr implements Observable
{
    Repo rep;
    int id;
    ArrayList<Observer> obs = new ArrayList<Observer>();

    public Ctr(Repo rep) {
        super();
        this.rep = rep;
        if (rep.getLength() == 0){
            id=1;
        }
        else{
            id=rep.getLength()+1;
        }
    }
    public ArrayList<Chelt> getList(){
        return rep.getAll();
    }

    public void addChelt(String tip, Integer sum, String descr, String membru){
        Chelt c = new Chelt(id, tip, sum, descr, membru);
        id++;
        rep.addEl(c);
    }

    public Integer getSum(String s){
        Integer sum =0;
        for (Chelt c : getList()){
            if (c.getTip().equals(s)){
                sum = sum + c.getSuma();
            }
        }
        return sum;
    }

    @Override
    public void addObserver(Observer o){
        obs.add(o);
    }

    @Override
    public void notifyObservers(){
        for( Observer o: obs){
            o.update();
        }
    }

}
