package se.nackademin;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Output {

    //INSTANSVARIABLER
    int counter;
    String status;
    String statusMessage;
    String trainingMessage;

//----------------------------------------------------------------------------------
    //CONSTRUCTOR
    public Output(int counter, String status, String statusMessage, String trainingMessage ){
        this.counter = counter;
        this.status = status;
        this.statusMessage = statusMessage;
        this.trainingMessage = trainingMessage;
        manageOutput();
    }

//----------------------------------------------------------------------------------
    //INSTANSMETODER
    public void manageOutput()  {

        switch (counter) {

            case 0:                     //INGEN motsvarande kund
                JOptionPane.showMessageDialog(null, "Kunden hittades inte\n" + status);
                break;
            case 1:                     //EN motsvarande kund: info, registrering
                printClient();
                break;
            default:                    //FLERA motsvarande kunder: info, ej registrering
                printManyClients();
        }//switch
    }


    public void printClient(){
        try (PrintWriter writer = new PrintWriter( new BufferedWriter
                (new FileWriter("src\\se\\nackademin\\trainingRegister.txt",true)))){
            if (status.equals("Före detta kund"))                   //före detta kund
                JOptionPane.showMessageDialog(null,
                        counter + " item hittades\n" + statusMessage + "\n");
            else {                                                  //nuvarande medelm
                writer.write(trainingMessage); writer.flush();
                JOptionPane.showMessageDialog(null,
                        counter + " item hittades\n" +
                                statusMessage + "\nNärvaro registreras automatiskt");

            }
        }//try
        catch (IOException e) {
            System.out.println("Error occurred in file updating ");
            e.printStackTrace();
        }
    }


    public void printManyClients(){
        JOptionPane.showMessageDialog(null,
                counter + " items hittades\n" + statusMessage +
                        "\nINGEN närvaro registreras\n(Ange fullständiga uppgifter)");

    }
}




