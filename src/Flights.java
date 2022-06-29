import java.io.*;
import java.util.*;


public class Flights {
    ArrayList<Plane> FlightList = new ArrayList<>();
    public Flights(String fileName) {
        CSVReader reader = new CSVReader(fileName, false);
        while (reader.hasNext()){
            List<String> p = reader.getNext();
            FlightList.add(new Plane(p.get(0), p.get(1), Integer.parseInt(p.get(2))));
        }
    }

    public ArrayList<Plane> filter(String airline){
        ArrayList<Plane> lst = new ArrayList<>();
        for (Plane p : FlightList){
            if (p.airline.equalsIgnoreCase(airline)){
                lst.add(p);
            }
        }
        return lst;
    }

    public ArrayList<Plane> sorter(ArrayList<Plane> p){
        Collections.sort(p, new Comparator<Plane>() {
            @Override
            public int compare(Plane a, Plane b) {
                //Students write this
                //compare flight name first, then city, then time
                if(b.airline.compareTo(a.airline) == 0){
                    if(b.city.compareTo(a.city) == 0){
                        if (a.time > b.time){
                            return 1;
                        }
                        else if (a.time < b.time){
                            return -1;
                        }
                        return 0;
                    }
                    return b.city.compareTo(a.city);
                }
                return b.airline.compareTo(a.airline);
            }
        });
        return p;
    }

    public Plane findFlight(String airline, String city, int earliest, int latest){
        ArrayList<Plane> shortened = filter(airline);
        shortened = sorter(shortened);

        for(Plane p : shortened){
            if (p.city.equalsIgnoreCase(city)){
                if (p.time > earliest && p.time < latest){
                    return p;
                }
            }
        }
        return new Plane("nonexistent", "nowhere", -1);
    }
    public static void main(String[] args){
        Flights f = new Flights("src/Airport.csv");
        //System.out.println(f.findFlight("Southwest", "Denver", 0, 300));
        //System.out.println(f.findFlight("Southwest", "Denver", 0, 100));

        ArrayList<Plane> test = f.FlightList;
        f.sorter(test);
        for(Plane p : test){
            System.out.println(p);
        }

    }
}
