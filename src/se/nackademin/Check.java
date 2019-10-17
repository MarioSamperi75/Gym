package se.nackademin;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeParseException;


public class Check {

    //INSTANSVARIABLER

    Path pathIn = Paths.get("src\\se\\nackademin\\customers2.txt");
    private String identityLine;
    private String subscriptionLine;
    String status = "Status: obehörig";
    int counter = 0;
    String statusMessage = "";
    String trainingMessage = "";

//---------------------------------------------------------------------
// CONSTRUCTOR

    public Check(String input) {

        try (BufferedReader reader = Files.newBufferedReader(pathIn);
             ) {
            while ((identityLine = reader.readLine()) != null) {
                subscriptionLine= reader.readLine();

                if (itemIsFound(identityLine, input)) {             //kund, före detta eller nuvarande
                    counter = counterUppdate(counter) ;
                    LocalDate substrictionDate = LocalDate.parse(subscriptionLine);
                    status = getStatus(substrictionDate);
                    statusMessage = getStatusMessage();
                    trainingMessage = addToRegister();
                }//if
            }//while
        }//try

        catch (NoSuchFileException e) {
            System.out.println("\nInput file not found: check file system");
            e.printStackTrace();
            System.exit(0);
         //NoSuchFile först: subklass av IOException
        }
        catch (IOException e) {
            System.out.println("\nError found in input file");
            e.printStackTrace();
        }
        catch (DateTimeParseException e) {
            System.out.println("\ninvalid date format found in input file\n");
            e.printStackTrace();
            System.exit(0);
        }
    }//constructor Check

    //-----------------------------------------------------------------------
    //INSTANSMETODER


    public boolean itemIsFound (String identityLine, String input) {
        if (identityLine.toLowerCase().contains(input.toLowerCase())) {
            return true;
        }
        return false;
    }//itemIsFound

    public String getStatus(LocalDate subscriptionDate) {
        LocalDate today = LocalDate.now();
        int elapsedYear = Period.between(subscriptionDate, today).getYears();
        if (elapsedYear>0)
            return "Före detta kund";
        else
            return "Nuvarande medlem";
    }//getStatus

    public int counterUppdate (int counter){
        return ++counter;
    }//counterUppdate

    public String getStatusMessage() {
        Splitter splitter = new Splitter(identityLine);
        String s=  String.format (this.statusMessage + "\nNamn  : %-20s\nPnr       : %-11s\nStatus : %-17s\n",
                                    splitter.getName(),splitter.getIDnumber(), status);
        return s;
    }//getInfoList

    public String addToRegister (){
        Splitter splitter = new Splitter(identityLine);
        String s = splitter.getName() + " " + LocalDate.now() + "\n";
        return s;
    }//addToRegister

}//class
