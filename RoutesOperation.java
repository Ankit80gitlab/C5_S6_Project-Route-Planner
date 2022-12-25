import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoutesOperation {

    List<Routes> list1 = new ArrayList<>();
    Routes r;

    public List<Routes> readFile(String fileName) {
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String str;
            while ((str = buffer.readLine()) != null) {
                str = str.replaceAll(" ", "");
                String[] array = str.split(",");
                r = new Routes(array[0], array[1], Integer.parseInt(array[2]), array[3], array[4]);
                list1.add(r);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return list1;
    }

    // Task1

    public void displayFlights() {
        System.out.println("Source               Destination     Distance in km         Travel Time         Typical Airfare");
        ArrayList<Routes> newL = (ArrayList<Routes>) list1.stream().sorted((o1, o2) -> o1.getDistance() - o2.getDistance()).collect(Collectors.toList());
        for(Routes l : newL)
        {
            System.out.format("%-20s %-20s %-20s %-20s %-20s",l.getSource(),l.getDestination(), l.getDistance(), l.getTime(), l.getAirFare());
            System.out.println();
        }
    }

    public List<Routes> showDirectFlight(String source) {
        System.out.println("Flights from " + source);
        System.out.println();
        System.out.println("Source               Destination     Distance in km         Travel Time         Typical Airfare");


        List<Routes> list2 = new ArrayList<>();
        list1.stream().filter(i -> i.getSource().equalsIgnoreCase(source)).forEach(j -> list2.add(j));
        if (list2.isEmpty()) {
            System.out.println("We are sorry. At this point of time, we dont have any information on flights originating from " + source);
        } else {
            for (Routes r : list2) {
                System.out.format("%-20s %-20s %-20s %-20s %-20s", r.getSource(), r.getDestination(), r.getDistance(), r.getTime(), r.getAirFare());
                System.out.println();
            }
        }
        return list2;
    }

    // Task3

    public void sortDirectFlight(List<Routes> list) {
        System.out.println("Flights sort by the destination");
        System.out.println();
        System.out.println("Source               Destination     Distance in km         Travel Time         Typical Airfare");


        List<Routes> list3 = new ArrayList<>();
        list.stream().sorted((o1, o2) -> o1.getDestination().compareToIgnoreCase(o2.getDestination())).forEach(i -> list3.add(i));
        if (list.isEmpty()) {
        } else {
            for (Routes r : list3) {
                System.out.format("%-20s %-20s %-20s %-20s %-20s", r.getSource(), r.getDestination(), r.getDistance(), r.getTime(), r.getAirFare());
                System.out.println();
            }
        }
    }

    // Task4

    public void intermediateFlight(List<Routes>listDirectF, String fromCity, String toCity) {

        System.out.println("Flight details - Direct Flights");
        System.out.println();

        ArrayList<Routes> directFlightList = (ArrayList<Routes>) listDirectF.stream().filter(i -> i.getSource().equalsIgnoreCase(fromCity) && i.getDestination().equalsIgnoreCase(toCity)).collect(Collectors.toList());
        if(directFlightList.isEmpty())
        {
            System.out.println("No direct flights to show");
        }
        else
        {
            for(Routes p : directFlightList)
            {
                System.out.format("%-20s %-20s %-20s %-20s %-20s", p.getSource(), p.getDestination(), p.getDistance(), p.getTime(), p.getAirFare());
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

        int n=0;
        System.out.println("Flight details - Intermediate Flights");
        System.out.println();

        ArrayList<Routes> toL=(ArrayList<Routes>) list1.stream().filter(p1 -> p1.getDestination().equalsIgnoreCase(toCity)).collect(Collectors.toList());

        for(Routes sameSource : toL)
        {
            for(Routes sameDest : listDirectF)
            {if(sameSource.getSource().equalsIgnoreCase(sameDest.getDestination()))
                {
                    System.out.format("%-20s %-20s %-20s %-20s %-20s", sameDest.getSource(), sameDest.getDestination(), sameDest.getDistance(), sameDest.getTime(), sameDest.getAirFare());
                    System.out.println();
                    System.out.format("%-20s %-20s %-20s %-20s %-20s", sameSource.getSource(), sameSource.getDestination(), sameSource.getDistance(), sameSource.getTime(), sameSource.getAirFare());
                    System.out.println();
                    n++;}
            }
        }
        if(n==0)
        {
            System.out.println("No intermediate flights to show");
        }
    }
}



 /*
            List<Routes> li1 = list1.stream().filter(i -> i.getSource().equalsIgnoreCase(fromCity) && !i.getDestination().equalsIgnoreCase(toCity)).collect(Collectors.toList());
            for (Routes r : li1) {
                if (r.getDestination().equalsIgnoreCase(r.getSource()) && r.getDestination().equalsIgnoreCase(toCity)) {
                    System.out.format("%-20s %-20s %-20s %-20s %-20s", r.getSource(), r.getDestination(), r.getDistance(), r.getTime(), r.getAirFare());
            for (int i = 0; i < list1.size(); i++) {
                String temp = list1.get(i).getDestination();
                if (list1.get(i).getSource().equalsIgnoreCase(fromCity) && !temp.equalsIgnoreCase(toCity)) {
                    for (int j = 0; j < list1.size(); j++) {
                        if (temp.equalsIgnoreCase(list1.get(j).getSource()) && list1.get(j).getDestination().equalsIgnoreCase(toCity)) {
                            System.out.format("%-20s %-20s %-20s %-20s %-20s", list1.get(i).getSource(), list1.get(i).getDestination(), list1.get(i).getDistance(), list1.get(i).getTime(), list1.get(i).getAirFare());
                            System.out.println();
                            System.out.format("%-20s %-20s %-20s %-20s %-20s", list1.get(j).getSource(), list1.get(j).getDestination(), list1.get(j).getDistance(), list1.get(j).getTime(), list1.get(j).getAirFare());
                            System.out.println();
                            n++;
           }
            if (n == 0) {
                System.out.println("No intermediate flights are available");

            }
        }
 */