import java.util.HashMap;

public class FindItineraryforTickets {
    
    public static String getStart(HashMap<String,String> tickets){



        return null;
    }
    
    public static void main(String[] args) {
        
        HashMap<String,String> tickets= new HashMap<>();  // we need to find out the junney from src. to dest

        tickets.put("Chennai", "Bengulure");  // tickets info 
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");  

        //Mumbai->Delhi->Goa->Chennai->Bengulure
        //find out the starting point i.e Mumbai

        String start = getStart();

    }
}
