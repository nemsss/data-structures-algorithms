package DataStructures;


public class MotorcycleOilChangeApp {
    //we will use a 12 piece socket set for this job
    private BasicMap<String, String> toolset = new BasicMap<>(12);

    public static void main(String [] args) {
        MotorcycleOilChangeApp app = new MotorcycleOilChangeApp();
        app.changeOil();
    }

    public void changeOil() {
        buildToolset();

        //remove skid plate to getLinked at the oil pan
        removeSkidPlate();

        System.out.println("1/2sae- "+toolset.getLinked("1/2sae"));

        //drain the oil by removing the drain plug and refill
        drainAndReplaceOil();

        //replace the skid plate
        replaceSkidPlate();

        emptyToolset();

        System.out.println();
    }

    /**
     * This loads the toolbox with all the needed tools
     */
    private void buildToolset() {
        toolset.putLinked("8mm", "8mm Socket");
        toolset.putLinked("10mm", "10mm Socket");
        toolset.putLinked("12mm", "12mm Socket");
        toolset.putLinked("14mm", "14mm Socket");
        toolset.putLinked("17mm", "17mm Socket");
        toolset.putLinked("1/4sae", "1/4sae Socket");
        toolset.putLinked("3/8sae", "3/8sae Socket");
        toolset.putLinked("1/2sae", "1/2sae Socket");
        toolset.putLinked("5/8sae", "5/8sae Socket");
        toolset.putLinked("3/4sae", "3/4sae Socket");
        toolset.putLinked("1/4d", "1/4 socket wrench");
        toolset.putLinked("2de", "2 inch Drive extension");
        System.out.println("Toolset size: " + toolset.size());
    }

    private void emptyToolset() {
        toolset.deleteLinked("8mm");
        toolset.deleteLinked("10mm");
        toolset.deleteLinked("12mm");
        toolset.deleteLinked("14mm");
        toolset.deleteLinked("17mm");
        toolset.deleteLinked("1/4sae");
        toolset.deleteLinked("3/8sae");
        toolset.deleteLinked("1/2sae");
        toolset.deleteLinked("5/8sae");
        toolset.deleteLinked("3/4sae");
        toolset.deleteLinked("1/4d");
        toolset.deleteLinked("2de");
        System.out.println("Toolset size: " + toolset.size());
    }

    private void removeSkidPlate() {
        //getLinked the 10mm socket and wrench
        String socket = toolset.getLinked("10mm");
        String wrench = toolset.getLinked("1/4d");
        System.out.println("Removed 4 skid plate nuts with the " + socket + " and " + wrench);
    }

    private void replaceSkidPlate() {
        //getLinked the 10mm socket and wrench
        String socket = toolset.getLinked("10mm");
        String wrench = toolset.getLinked("1/4d");
        System.out.println("Replaced 4 skid plate nuts with the " + socket + " and " + wrench);
    }

    private void drainAndReplaceOil() {
        //this motorcycle's drain plug nut is 17mm.  That's a strange size, check to see if the toolset has it
        System.out.println("Toolset has 17mm socket: " + toolset.containsValue("17mm Socket") + " - " + toolset.containsKey("17mm"));

        String socket = toolset.getLinked("17mm");
        String wrench = toolset.getLinked("1/4d");
        System.out.println("Removed oil drain plug with " + socket + " and " + wrench);
        System.out.println("Drained 1.7 quarts of oil");
        System.out.println("Replaced oil drain plug with " + socket + " and " + wrench);
        System.out.println("Added 1.7 quarts of oil");
    }
}
