import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Aufgabe5
{

    public static void main(String[] args){


        writeFile(); // Zufallszahl zwischen 1 und 50 in eine Textdatei schreiben


        System.out.println(getNumberQuantity(Integer.parseInt(JOptionPane.showInputDialog("Bitte Zahl zwischen 1 und 50 eingeben:")))); //Nutzer wird nach einer Zahl gefragt

    }

    public static int getNumberQuantity(int number){

        File file = null;   //Weg dahin
        FileReader fr = null;   //lesen des File
        BufferedReader reader = null;   //lesen der Datei


        ArrayList<Integer> list = new ArrayList<Integer>(); //ArrayList mit Integer erstellen

        try {

            file = new File("C:\\Users\\sabri\\OneDrive\\Desktop\\Softwareübung\\Aufgabe5"); // relativer pfad im project

            fr = new FileReader(file);      //fr füllen, br füllen mit fr
            reader = new BufferedReader(fr);

            while (true) {

                String line = reader.readLine(); //er liest was drinnen steht und speichert es in die Variable Null
                if (line == null) break;        // wenn line null is -abbrechen

                if (Integer.parseInt(line) == number){  //kontrolliert ob die line null ist
                    list.add(Integer.parseInt(line));   // zur Liste hinzufügen
                }

            }

        } catch(Exception ex){ //heiße Kartoffel fangen
            ex.printStackTrace(); // wenn fehler auftritt gibt es diese exception aus
        }

        return list.size(); //gibt mir die Länge der Liste zurück, sprich sagt mir wie oft es die Zahl gefunden hat

    }

    public static void writeFile(){ //beschreibt/füllt

        File file = null; //weg dorthin
        FileWriter fw = null; //befüllt den file
        BufferedWriter writer = null;

        //wird im try block befüllt

        String seperator = System.getProperty("line.separator"); //Zeilenumbruch
        Random random = new Random();   //zufallszahl

        try {

            file = new File("C:\\Users\\sabri\\OneDrive\\Desktop\\Softwareübung\\Aufgabe5"); //\\doppelt ansonsten wird eine neue Zeile gemacht

            if (!file.exists()){ //=nicht
                file.createNewFile(); //neu kreieren
            }

            fw = new FileWriter(file); //fw mit wörtern befüllen
            writer = new BufferedWriter(fw); //writer mit fw befüllen

            for (int i = 0; i < 50; i++){ //for-schleife
                int randomNumber = random.nextInt(50) + 1; //Zufallszahl
                writer.write(randomNumber + seperator); //Seperator - Zeilenumbruch
            }

            writer.close(); //writer closen

        } catch (Exception ex){
            ex.printStackTrace(); //es zeigt mir die Fehler im programm an
        }

    }

}
