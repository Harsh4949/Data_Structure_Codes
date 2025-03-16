import java.util.HashMap;

public class FindItineraryforTickets {
    
    public static String getStart(HashMap<String,String> tickets){

        HashMap<String,String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            
            revMap.put(tickets.get(key), key);  // reverse the ticket map
        }

        // And Now check the String (value) present at 1st But not in 2nd Map that mens that is starting point to start juney
        //  String (value) present at 2nd Bur not in 1st that mens that is ending point to start juney not nned to imliment just for info
        // mimbai and bengilure in this case

        for (String key : tickets.keySet()) {
            
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        /* Comare
         * tickets KEy set : Chennai Mumbai Goa Delhi  -> mumbai not present it strting point always unique
         * revMap ket set : benuglure Delhi Chennai Goa
         * 
         */

        return null;
    }

    public static void main(String[] args) {
        
        HashMap<String,String> tickets= new HashMap<>();  // we need to find out the junney from src. to dest   

        //                   From ,        To              gievn 
        tickets.put("Chennai", "Bengulure");  // tickets info 
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");  

        //Mumbai->Delhi->Goa->Chennai->Bengulure
        //find out the starting point i.e Mumbai

        String start = getStart(tickets); 
        System.out.print(start);  //Mumbai

        for (int i = 0; i < tickets.size(); i++) {
            
            System.out.print("->" +tickets.get(start)); // "Mumbai"-> "Delhi"  // "Delhi", "Goa" // "Goa", "Chennai" //"Chennai", "Bengulure"
            start = tickets.get(start);
        }
    }
}
