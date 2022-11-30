package x_interview.flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        BufferedReader input = null;

        try {
            input = new BufferedReader(new FileReader(new File(args[0])));

            String firstLine = input.readLine();
            System.out.println(firstLine);
            String[] operations = firstLine.split(" ");

            //Dosyadan acc'leri okuyup onlara airportları ekledik
            List<AreaControlCenter> accs= new ArrayList<>();
            for(int i=0;i< Integer.parseInt(operations[0]);i++){
                String line = input.readLine();
                String [] accAndAirports= line.split(" ");
                AreaControlCenter areaControlCenter = new AreaControlCenter(accAndAirports[0]);
                for(int j=1;j<accAndAirports.length;j++){
                    Airport airport = new Airport(accAndAirports[j]);
                    areaControlCenter.addAirPort(airport);
                    airport.setAreaControlCenter(areaControlCenter);
                    airport.createAirTrafficCenter();
                }
                accs.add(areaControlCenter);
            }

            for(int i=0;i<Integer.parseInt(operations[1]);i++){
                String line = input.readLine();
                String [] flightInfo= line.split(" ");
                Flight flight = new Flight(flightInfo[1]);
                flight.setAdmissionTime(Integer.parseInt(flightInfo[0]));

                AreaControlCenter areaControlCenter = null;
                for(AreaControlCenter areaControlCenter1: accs){
                    if(areaControlCenter1.getCode().equals(flightInfo[2])){
                        areaControlCenter = areaControlCenter1;
                    }
                }
                Airport takeOff =null;
                for(Airport airport: areaControlCenter.getAirports()){
                    if(airport.getCode().equals(flightInfo[3])){
                        takeOff=airport;
                    }
                }
                Airport landing=null;
                for(Airport airport: areaControlCenter.getAirports()){
                    if(airport.getCode().equals(flightInfo[4])){
                        landing=airport;
                    }
                }
                flight.setLanding(landing);
                flight.setTakeOff(takeOff);

                for(int j=5 ;j<flightInfo.length;j++){
                    flight.addState(Integer.parseInt(flightInfo[j]));
                }
                flight.setCurrentState(0);

                areaControlCenter.addQueue(flight);
                areaControlCenter.incFlightNumber();
            }
            File outputFile = new File(args[1]);
            outputFile.createNewFile();
            PrintStream output = new PrintStream(outputFile);
            for(AreaControlCenter areaControlCenter:accs){
                String result = areaControlCenter.run();
                output.println(result);
            }
            output.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
