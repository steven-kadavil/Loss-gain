import java.util.ArrayList;
import java.util.Scanner;

public class ER 
{
  private Patient[] beds;
  private ArrayList<Patient> waitingRoom;
  private static int patientNumber;

  Scanner kb = new Scanner(System.in);

  public ER (int numBeds) 
  {
    beds = new Patient[numBeds];
    waitingRoom = new ArrayList<Patient>();
  }

  public void startTimer(int interval)
  {
      long startTime = System.currentTimeMillis();
      while (System.currentTimeMillis() - startTime < (long)interval)
          {
              // this is just stalling lmao
          }
      doThis();
      startTimer(interval);
  }
    
  public void enter(Patient patient)
  {
    waitingRoom.add(patient);
  }

  // admitting the patient from the waiting room
  public void admit(Patient patient) 
  {
    if (checkEmptyBeds() >= 0) {
      // puts the patient into the bed
      beds[checkEmptyBeds()] = patient;

      // takes the patient out of the waiting room
      for (int i = 0; i < waitingRoom.size(); i++)
        if (patient.getIndex() == waitingRoom.get(i).getIndex())
          waitingRoom.remove(i);
    }
  }

  // discharging the patient from the ER
  public void discharge(int index) 
  {
    for (int i = 0; i < beds.length; i++)
      if (index == beds[i].getIndex())
        beds[i] = null;
  }

  public Patient locate(int index) 
  {
    for (int i = 0; i < beds.length; i++)
      if (beds[i] == null) {}
      else if (beds[i].getIndex() == index)
        return beds[i];
    return null;
  }

  public void listBeds()
  {
    for (Patient patient : beds) {
      if (patient != null) {
      System.out.print(patient.getName() + " ");
      System.out.print(patient.getCondition() + " ");
      System.out.println(patient.getIndex() + " ");
      }
    }
  }

  // returns the index of an empty bed (if available)
  public int checkEmptyBeds() 
  {
    for (int i = 0; i < beds.length; i++) {
      if (beds[i] == null) {
        beds[i] = null;
        return i;
      }
    }
    return -1;
  }

  public void fillMax() 
  {
    for (int i = 0; i < beds.length; i++)
      beds[i] = new Patient("Placeholder", new Disease("Unnamed_Disease", 50, 1));
  }
  
  public void doThis() 
  {
    for (int i = 0; i < waitingRoom.size(); i++)
    {
      waitingRoom.get(i).incrementUrgency();
      waitingRoom.get(i).incrementLength();
    }
    if (checkEmptyBeds() >= 0)
      choosePatient();
  }

  public void choosePatient() 
  {
    for (int i = 0; i < 4; i++)
    {
    
      System.out.println("(Enter " + (i+1) + ") Patient Number " + waitingRoom.get(i).getIndex() + ", " + waitingRoom.get(i).getCondition());
      System.out.println("\tWaiting for " + waitingRoom.get(i).getLength() + " hours.");
    }
      
    // longest waiting patient
    System.out.println("(Enter 5) Patient Number " + longestPatient().getName() + ", " + longestPatient().getCondition());
    System.out.println("\tWaiting for " + longestPatient().getLength() + " hours.");

    // finds longest patient
    int longVal = 0;
    for (int i = 0; i < waitingRoom.size(); i++)
      if (longestPatient().getIndex() == waitingRoom.get(i).getIndex())
        longVal = i;
        
    
    switch (kb.nextInt()) {
                case 1 : admit(beds[1]);
                    break;
                case 2 : admit(beds[2]);
                    break;
                case 3 : admit(beds[3]);
                    break;
                case 4 : admit(beds[4]);
                    break;
                case 5 : admit(beds[longVal]);
                    break;
                default : System.out.println("error");
            }
    System.out.println("Entered.");
      
  }

  public Patient longestPatient()
  {
    Patient max = waitingRoom.get(0);
    for (int i = 0; i < waitingRoom.size(); i++)
      if (waitingRoom.get(i).getLength() > max.getLength())
        max = waitingRoom.get(i);
    return max;
  }
  
  // index getter
  public static int getPatientNumber() {
    return patientNumber;
  }

  // index setter
  public static void setPatientNumber(int i) {
    patientNumber = i;
  }

  public void sort()
  {
    Patient[] sortedList = new Patient[waitingRoom.size()];
    for (int i = 0; i < sortedList.length; i++)
    {
      int a = findMax(waitingRoom);
      sortedList[i] = waitingRoom.remove(a);
    }     
  }

  public int findMax(ArrayList<Patient> p)
  {
    int maxP = 0;
      for (int i = 0; i < p.size()- 1; i++)
        if (p.get(i).getUrgency() < p.get(i+1).getUrgency())
          maxP = i + 1;
    return maxP;
  }
}