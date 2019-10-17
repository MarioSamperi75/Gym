package se.nackademin;

public class Splitter {

    //INSTANSVARIABEL

    private String identityLine;

//---------------------------------------------------------------------
    // CONSTRUCTOR

    public Splitter(String identityLine) {
        this.identityLine = identityLine;
    }

//---------------------------------------------------------------------
    // INSTANSMETODER

    public String getIDnumber() {
        String IDnumber = identityLine.substring(0, identityLine.indexOf(",")).trim();
        return IDnumber;
    }

    public String getName() {
        String name = identityLine.substring(identityLine.indexOf(",") + 1).trim();
        return name;
    }

}
