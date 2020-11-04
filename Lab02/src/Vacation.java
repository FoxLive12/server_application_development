public class Vacation extends Tour {

    public Vacation(int cost,String transport,boolean food,int numberOfDays){
        super(cost,transport,food,numberOfDays);
        this.type="vacation";
    }

    @Override
    public String toString(){
        return "\n"+"Tour type:"+type+super.toString();
    }
}
