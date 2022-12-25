import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "src/routes.csv";
        RoutesOperation obj1 = new RoutesOperation();

        List<Routes> list = obj1.readFile(fileName);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        obj1.displayFlights();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Enter the source city");
        String ip0 = sc.next();
        List<Routes> list2 = obj1.showDirectFlight(ip0);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        obj1.sortDirectFlight(list2);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Enter the destination city");
        String ip1 = sc.next();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        obj1.intermediateFlight(list2,ip0,ip1);
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
}
