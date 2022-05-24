// Name: Eduardo Teodosio Campuzano
// Description: Represents a doctor that can have patients


public class Doctor {
    private int doctorID;
    private Patient currentPatient;

    //Constructor to initialize member variables
    //Initially no patient is assigned
    public Doctor(int id) {
        this.doctorID = id;
        currentPatient = null;
    }

    //toString method returns a string containing
    //the information of a doctor
    public String toString() {
        String result = "Doctor id " + doctorID;

        if (currentPatient == null)
            result += " is not seeing any patient";
        else
            result += " is seeing a patient with id " + currentPatient.getPatientID();

        return result;
    }

    //Checks to see whether or not the Doctor has a patient
    public boolean hasPatient() {
        return currentPatient != null;
    }


    //Assigns a patient to the doctor if they do not already have one
    public boolean assignPatient(Patient patient1) {
        if (currentPatient == null) {
            currentPatient = patient1;
            return true;
        } else return false;
    }

    // Sets the doctors currents patient to null "releasing them" and returns the patient object
    public Patient releasePatient() {
        if (currentPatient != null) {
            Patient releasedPatient = currentPatient;
            currentPatient = null;
            return releasedPatient;
        } else return null;
    }

    //Method used to fetch the current patient.
    public Patient getCurrentPatient(){
        return currentPatient;
    }

    //Method used to fetch the DoctorID
    public int getDoctorID(){
        return doctorID;
    }

}
