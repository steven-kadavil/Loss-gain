import java.util.ArrayList;

public class Database
{
  ArrayList<Disease> diseases;

  public Database()
  {
    diseases = new ArrayList<Disease>();
      AddDiseases();
  }

  public Disease findDisease(String name)
  {
    for (int i = 0; i < diseases.size(); i++)
      if (diseases.get(i).getConditionName().equals(name))
        return diseases.get(i);
      return null;
  }
  
  // Index of Diseases
  public void AddDiseases()
  {
    diseases.add(new Disease("Abdominal_Pain", 20, 1));
    diseases.add(new Disease("Respiratory_Infection", 80, 3));
    diseases.add(new Disease("Superficial_Injury", 10, 1));
    diseases.add(new Disease("Back_Problems", 30, 4));
    diseases.add(new Disease("Non-Specific_Chest_Pain", 30, 1));
      
    diseases.add(new Disease("Urinary_Tract_Infection", 40, 2));
    diseases.add(new Disease("Skin_Infection", 30, 1));
    diseases.add(new Disease("Anemia", 70, 1));
    diseases.add(new Disease("Headache", 20, 1));
    diseases.add(new Disease("Pancreatic_Disorder", 60, 1));
      
    diseases.add(new Disease("Epilepsy", 70, 3));
    diseases.add(new Disease("Intestinal_Infection", 50, 1));
    diseases.add(new Disease("Non-Traumatic_Joint_Disorder", 50, 10));
    diseases.add(new Disease("Disorder_of_Teeth_and_Jaws", 40, 4));
    diseases.add(new Disease("Nausea_and_Vomiting", 60, 2));
      
    diseases.add(new Disease("Pregnancy_Complication", 100, 1));
    diseases.add(new Disease("Asthma", 75, 2));
    diseases.add(new Disease("Nervous_System_Disorder", 60, 5));
    diseases.add(new Disease("Allergic_Reaction", 80, 4));
    diseases.add(new Disease("Gastrointestinal_Disorder", 60, 5));
      
    diseases.add(new Disease("Fracture_of_Upper_Limb", 30, 2));
    diseases.add(new Disease("Viral_Infection", 30, 1));
    diseases.add(new Disease("Otitis_Media", 40, 1));
    diseases.add(new Disease("Cataracts", 40, 1));
    diseases.add(new Disease("COVID-19", 69, 420));     
  }
}