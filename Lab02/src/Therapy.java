public class Therapy extends Tour {

    public Therapy(int cost,String transport,boolean food,int numberOfDays){
        super(cost,transport,food,numberOfDays);
        this.type="therapy";
    }

    @Override
    public String toString(){
        return "\n"+"Tour type: "+type+super.toString();
    }
}