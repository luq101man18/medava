package edu.uc.cs3003.medava;

// this will run the simulation of sending and recieving 
// via a transporter ( while the transporter works as a meduim )

public class HospitalRunner {
    public static void run() {
        Transporter priorityDispatch = new Transporter("Priority Dispatch", 40.0, 41.0);

        Pharmacy cvs = new Pharmacy("CVS at 7500 Beechmont Avenue");

        cvs.send(priorityDispatch);

        Hospital uc = new Hospital("World Famous University of Cincinnati Children's Hospital");

        uc.receive(priorityDispatch);
    }
}
