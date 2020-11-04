import java.util.List;
import java.util.ArrayList;

public class ClientTourBooking {

    public static void main(String[] args) throws RuntimeException{
        List<Tour> tour1=new ArrayList<>();
        List<Tour> tour2=new ArrayList<>();

        List<Client> client1=new ArrayList<>();
        List<Client> client2=new ArrayList<>();

        TourBooking booking=new TourBooking();

        ClientVouchers v1= new ClientVouchers(client1,tour1);
        booking.chooseClient(v1.getClient(),"ann");
        booking.chooseTour(v1.getTour(),"shopping","vacation");
        System.out.println(v1);

        ClientVouchers v2=new ClientVouchers(client2,tour2);
        booking.chooseClient(v2.getClient(),"tom");
        booking.chooseTour(v2.getTour(),"cruise","therapy");
        System.out.println(v2);

        booking.sortTourByCost(v2);
        System.out.println(v2);
    }
}