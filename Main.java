import java.util.Scanner;

class Main 
{
    static ER emergencyRoom = new ER(50);
    static Database database = new Database();
    static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String endKey = "";
        // START PROGRAM
        //emergencyRoom.startTimer(10000);
        System.out.println("\033[32;1;4mWelcome to the LGS\033[0m");
        //emergencyRoom.startLoop();
        while (!endKey.equals("stop"))
        {
          System.out.println("\033[37;1;4mACTIONS\033[0m");
          System.out.println("\n1. Enter patient (press P)");
          System.out.println("2. Locate patient (press L)");
          System.out.println("3. Discharge Patient (Press D");
          System.out.println("4. List Patients (Press B)");
          System.out.println("5. Check for empty rooms (Press C)\n");

            // ASKS FOR INPUTS
            switch (kb.next().toUpperCase()) 
            {
                case "P" : 

                  if (emergencyRoom.checkEmptyBeds() < 0)
                  {
                    System.out.println("\nPlease enter the |patient name| |condition|");
                    String name = kb.next();
                    Disease condition = database.findDisease(kb.next());
                    Patient p = new Patient(name, condition);
                    emergencyRoom.enter(p);
                    System.out.println("Patient has been added to the waiting room.");
                  }
                  else
                    enterPatient();
                
                    break;
                
                case "D" : dischargePatient();
                    break;
                case "L" : locatePatient();
                    break;
                case "B" : emergencyRoom.listBeds();
                    break;
                case "X" : emergencyRoom.choosePatient();
                    break;
                case "V" : emergencyRoom.fillMax();
                    break;
                case "C" : 

                    if (emergencyRoom.checkEmptyBeds() > 0)
                    {
                      // doThis();
                    }
                
                    break;
                
                
                default : System.out.println("Please enter a proper key");
            }
        }
    }

    public static void enterPatient()
    {
        System.out.println("\nPlease enter the |patient name| |condition|");

        String name = kb.next();
        Disease condition = database.findDisease(kb.next());
        Patient p = new Patient(name, condition);
        emergencyRoom.admit(p);
      System.out.println(name+ " is located at bed " + p.getIndex());
    }

    public static void dischargePatient()
    {
        System.out.println("Please enter the |patient index|");
        emergencyRoom.discharge(kb.nextInt());
    }

    public static void locatePatient()
    {
        System.out.println("Please enter the |patient index|");
        Patient person = emergencyRoom.locate(kb.nextInt());
        System.out.println(person.getName() + ", " + person.getCondition());
    }

}