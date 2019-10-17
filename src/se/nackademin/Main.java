package se.nackademin;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
    }//main

    public Main() {
        while (true) {
            Input i = new Input();
            Check c = new Check(i.setInput());
            //Splitter s från check
            Output o = new Output(c.counter, c.status, c.statusMessage, c.trainingMessage);
        }//while(true)
    }//Constructror Main

}//ClassMain












