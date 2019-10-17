package se.nackademin;
import javax.swing.*;

public class Input {

    //INSTANSMETODER
    public  String setInput(){
        String input;
        while (true) {
            input = JOptionPane.showInputDialog("Ange namn eller personnummer");
            if (input == null)
                System.exit(0);

            input = manageSpaces(input);

            if (input.length()<=1)
                JOptionPane.showMessageDialog(null,
                        "Felaktig inmätning, ange mer detaljer");
            else
                break;
        }//while
        return input;
    }//setInput


    public String manageSpaces(String text){
        text = text.trim();
        while (text.contains("  ")){
            text= text.replace("  ", " ");
        }//while
        return text;
    }//manageSpace

    //toLowerCase hanteras i metoden itemIsFound (check)

}//class