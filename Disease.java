public class Disease
{
  private String name; // name of disease/condition
  private int urgency; // level  of severity/danger 1-100
  private int recoveryTime; // in hours

  // Constructor
  public Disease(String xName, int xUrgency, int xRecoveryTime)
  {
    name = xName;
    urgency = xUrgency;
    recoveryTime = xRecoveryTime;
  }

  // Returns condition
  public String getConditionName()
  {
    return name;
  }

  // Returns urgency level
  public int getUrgencyLevel()
  {
    return urgency;
  }

  // Returns recovery time
  public int getRecoveryTime()
  {
    return recoveryTime;
  }
}