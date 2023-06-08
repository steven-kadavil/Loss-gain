public class Patient {

  private String name;
  private Disease condition;
  private int urgency;
  private int index;
  private int length;

  public Patient(String str, Disease disease) {
    name = str;
    condition = disease;
    urgency = disease.getUrgencyLevel();
    index = ER.getPatientNumber();
      ER.setPatientNumber(ER.getPatientNumber() + 1);
    length = 0;
  }

  // name getter
  public String getName() {
    return name;
  }

  // urgency getter
  public int getUrgency() {
    return urgency;
  }

  // condition name getter
  public String getCondition() {
    return condition.getConditionName();
  }

  // urgency setter
  public void setUrgency(int num) {
    urgency = num;
  }

  // urgency incrementer
  public void incrementUrgency() {
    urgency++;
  }

  // index getter
  public int getIndex() {
    return index;
  }

  public int getLength() {
    return length;
  }

  public void incrementLength() {
    length++;
  }

}