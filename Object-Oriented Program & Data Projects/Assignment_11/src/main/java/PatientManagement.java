// Name: Eduardo Teodosio Campuzano
// Description: This program manages patient queues, assigns patients to doctors,
//              release them to check out, etc.

import java.util.LinkedList;

public class PatientManagement {
    private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
    private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
    private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.

    private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out

    private Doctor[] doctorList; //an array of doctors

    //Constructor to initialize member variables
    public PatientManagement(int numOfDoctors) {
        highPriorityQueue = new LinkedList<Patient>();
        intermediateQueue = new LinkedList<Patient>();
        delayedCareQueue = new LinkedList<Patient>();
        checkOutQueue = new LinkedList<Patient>();

        //creating doctor objects
        doctorList = new Doctor[numOfDoctors];
        for (int i = 0; i < doctorList.length; i++) {
            doctorList[i] = new Doctor(i);
        }
    }

    //The printQueue prints out the content
    //of the queues and the array of doctors
    public void printPatientQueues() {
        System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
        System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
        System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
        for (int i = 0; i < doctorList.length; i++) {
            System.out.println(doctorList[i].toString());
        }
        System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
    }

    //Creates a new patient object and adds them to their respective queue and if not able to add then returns false and vice versa
    public boolean addPatient(int patientId, String conditionLevel) {
        Patient patient = new Patient(patientId, conditionLevel);
        if (conditionLevel.equals("High Priority")) highPriorityQueue.offer(patient);
        else if (conditionLevel.equals("Intermediate")) intermediateQueue.offer(patient);
        else if (conditionLevel.equals("Delayed Care")) delayedCareQueue.offer(patient);
        else return false;

        return true;
    }

    //Checks each queue in their priority order and then assigns them to a doctor if available.
    public Patient assignPatientToDoctor() {
        if (!highPriorityQueue.isEmpty()) {
            for (Doctor doc : doctorList) {
                if (!doc.hasPatient()) {
                    doc.assignPatient(highPriorityQueue.element());
                    return highPriorityQueue.poll();
                }
            }
        }
        if (!intermediateQueue.isEmpty()) {
            for (Doctor doc : doctorList) {
                if (!doc.hasPatient()) {
                    doc.assignPatient(intermediateQueue.element());
                    return intermediateQueue.poll();
                }
            }
        }
        if (!delayedCareQueue.isEmpty()) {
            for (Doctor doc : doctorList) {
                if (!doc.hasPatient()) {
                    doc.assignPatient(delayedCareQueue.element());
                    return delayedCareQueue.poll();
                }
            }
        }
        return null;
    }

    //Checks to see if the Doctor ID is valid and then moves the patient to the check out queue and returns that patient object
    public Patient releasePatientFromDoctorToCheckOutQueue(int DoctorID) {
        if (DoctorID < doctorList.length) {
            if (doctorList[DoctorID].hasPatient()) {
                checkOutQueue.offer(doctorList[DoctorID].getCurrentPatient());
                return doctorList[DoctorID].releasePatient();
            } else return null;
        }
        return null;
    }

    //Checks the check out queue to see if it is empty or not and removes the next element if not
    public Patient checkOutPatient() {
        return checkOutQueue.poll();

    }
}