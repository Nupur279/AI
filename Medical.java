import java.util.Calendar;
import java.util.Scanner;

public class Medical {
       public static void main(String[] args) {
              gUser();
              interact();
       }

       private static void gUser() {
              int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
              if (hour >= 0 && hour < 12) {
                     System.out.println("\nGood morning! How can I assist you today?\n");
              } else if (hour >= 12 && hour < 18) {
                     System.out.println("\nGood afternoon! How can I assist you today?\n");
              } else {
                     System.out.println("\nGood evening! How can I assist you today?\n");
              }
       }

       private static void interact() {
              Scanner scanner = new Scanner(System.in);
              System.out.println("\n-----------------------------");
              System.out.println("  Welcome to Medical Chatbot");
              System.out.println("-----------------------------");
              System.out.println("1. Ask about symptoms");
              System.out.println("2. Schedule an appointment");
              System.out.println("3. Get general information");
              System.out.println("4. Prescription Refill Request");
              System.out.println("5. Homecare Services");
              System.out.println("6. Get BMI");
              System.out.println("7. Feedback");
              System.out.println("8. Exit");
              int choice;
                     System.out.print("Enter your choice : ");
                     choice = scanner.nextInt();

                  
                     switch (choice) {
                            case 1:
                                   askAboutSymptoms(scanner);
                                   interact();
                                   break;
                                   
                            case 2:
                                   scheduleAppointment(scanner);
                                   interact();
                                   break;
                            case 3:
                                   getGeneralInformation(scanner);
                                   interact();
                                   break;
                            case 4:
                                   getPrescriptionRefill(scanner);
                                   interact();
                                   break;
                            case 5:
                                   getHomecare(scanner);
                                   interact();
                                   break;
                            case 6:
                                   getBMI(scanner);
                                   interact();
                                   break;
                            case 7:
                                   giveFeedback(scanner);
                                   interact();
                                   break;
                            case 8:
                                   System.out.println("Thank you for using the medical chatbot. Have a great day!");
                                   break;
                            default:
                                   System.out.println("Invalid choice. Please try again.");
                                   interact();
                                   break;
                     }
       }

       private static void askAboutSymptoms(Scanner scanner) {
              System.out.println("\nKnow about your symptoms.");
              int ch = 0;
              while(ch<=6)
              {
                     System.out.println("Symptoms");
                     System.out.println("1. Fever");
                     System.out.println("2. Cold");
                     System.out.println("3. Typhoid");
                     System.out.println("4. Dengue");
                     System.out.println("5. Pneumonia");
                     System.out.println("6. Exit");
                     System.out.print("Enter the number of symptom: ");
                     ch = scanner.nextInt();

                     switch (ch) {
                            case 1:
                                   System.out.println(
                                                 "If you have a fever, you may feel hot and sweaty. You also might shiver because you feel chilled.Weakness, aches, or fatigue could happen. You may have symptoms ofthe illness that caused the fever, like a cough or sore throat.\n");
                                   break;
                            case 2:
                                   System.out.println(
                                                 "Cold symptoms usually start about 2 or 3 days after you came in contact with the virus, although it could take up to a week. Symptoms mostly affect the nose.The most common cold symptoms are:Nasal congestion.Runny nose.Scratchy throat.Sneezing.Adults and older children with colds generally have a low fever or no fever. Young children often run a fever around 100°F to 102°F (37.7°C to 38.8°C).\n");
                                   break;
                            case 3:
                                   System.out.println(
                                                 "Early symptoms include fever, general ill-feeling, and abdominal pain. High fever (103°F, or 39.5°C) or higher and severe diarrhea occur as the disease gets worse. Some people develop a rash called rose spots, which are small red spots on the abdomen and chest.\n");
                                   break;
                            case 4:
                                   System.out.println(
                                                 "Dengue fever causes a high fever — 104 F (40 C) — and any of the following signs and symptoms: Headache,Muscle, bone or joint pain,NauseaVomiting,Pain behind the eyes,Swollen glands,Rash\n");
                                   break;
                            case 5:
                                   System.out.println(
                                                 "Cough, which may produce greenish, yellow or even bloody mucus.Fever, sweating and shaking chills,Shortness of breath,Rapid, shallow breathing,Sharp or stabbing chest pain that gets worse when you breathe deeply or cough,Loss of appetite, low energy, and fatigue.\n");
                                   break;
                            case 6:
                                   interact();
                                   break;
                            default:
                                   System.out.println("Please enter valid choice");
                     }
              } 
       }

       private static void scheduleAppointment(Scanner scanner) {
              System.out.println("\nSure, let's schedule an appointment");
              // Scanner scanner = new Scanner(System.in);
              System.out.println("Chatbot: Please provide your name:");
              String name = scanner.next();

              System.out.println("Chatbot: What date would you like to schedule the appointment?");
              String gdate = scanner.next();

              System.out.println("Chatbot: What time would you prefer?");
              String time = scanner.next();

              System.out.println("Chatbot: Thank you, " + name + "! Your appointment is scheduled for " + gdate + " at "
                            + time + ".");
              // scanner.close();
       }

       private static void getGeneralInformation(Scanner scanner) {
              System.out.println(
                            "\nCertainly, here is some general information.Sahyadri Hospitals is the largest chain of hospitals in Maharashtra.The Sahyadri group has 9 Hospitals with more than 1000+ beds and 200 ICU beds. Currently we have more than 2000+ clinicians along with 2600 supporting staff. Sahyadri Hospitals has touched the lives of more than 50 lakh people by providing quality care. ");
       }

       private static void getPrescriptionRefill(Scanner scanner) {
              System.out.println("Please provide the patient's name:");
              String patientName = scanner.next();

              System.out.println("Thank you, " + patientName
                            + ". Can you provide the patient's ID or medical record number?");
              String patientID = scanner.next();

              System.out.println("Got it. Now, please specify the name of the medication needing a refill:");
              String medicationName = scanner.next();

              System.out.println("And how many day's supply do you need?");
              int daysSupply = scanner.nextInt();

              // Assume prescription refill process here (database interaction, etc.)
              System.out.println("Your request for " + medicationName + " refill for " + patientName + " (ID: "
                            + patientID + ") with " + daysSupply + " day's supply has been received.");

       }

       private static void getHomecare(Scanner scanner) {
              System.out.println("\nHere is some information about homecare services:");
              System.out.println(
                            "- Homecare services provided by hospitals include nursing care, physical therapy, and medical equipment rental.");
              System.out.println(
                            "- Patients can receive these services in the comfort of their own homes, under the supervision of trained medical professionals.");
              System.out.println(
                            "- To avail homecare services, please contact the hospital's homecare department or visit their website for more information.");

       }

       private static void getBMI(Scanner scanner) {
              System.out.print("\nEnter your weight in kilograms: ");
              double weight = scanner.nextDouble();

              System.out.print("Enter your height in meters: ");
              double height = scanner.nextDouble();

              double BMI = weight / (height * height);
              System.out.print("Body Mass Index is: " + BMI);

       }

       private static void giveFeedback(Scanner scanner) {
              System.out.println("\nGive your Feedback:");
              String feedback = scanner.next();
              System.out.println("Thank you for your valuable Feedback! Visit again");

       }
}