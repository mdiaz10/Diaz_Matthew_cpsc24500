import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import java.awt.Container;
import java.awt.BorderLayout;
/**
 * Matthew Diaz
 */
/**
 * Linked hash map
 */
public class CovidPlot {
    public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
        LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
        fsc.nextLine();  
        String Country; 
        String line; 
        String[] parts;
        double[] values;  
        while (fsc.hasNextLine()) {
            line = fsc.nextLine();
            parts = line.split("\\s+");
            parts = line.split("\t");
            Country = parts[0];
            double temp = 0;
            values = new double[parts.length-1];
            for (int i = 1; i < parts.length; i++) {
                values[i-1] = Double.parseDouble(parts[i]) - temp;
                temp=Double.parseDouble(parts[i]);

            }
            
            result.put(Country,values);
        }
        
        return result;
    }
    
    public static double[] getDays(int howMany) {
        final double[] result = new double[howMany];
        for (int i = 0; i < howMany; i++) {
            result[i] = i;
        }
        return result;
        

    }
    /**
     * sets up graph
     */
    public static void setUpAndShowPlot(Plot2DPanel plot) {
        JFrame frm = new JFrame();
        frm.setBounds(100,100,500,500);
        frm.setTitle("Investment Curves");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
        plot.addLegend("SOUTH");
        plot.setAxisLabels("Day","Deaths");
        c.add(plot,BorderLayout.CENTER);
        frm.setVisible(true);
    }
    
    /**
     * Reads file from user
     */
    public static void main(String[] args) throws Exception {
        LinkedHashMap<String,double[]> accounts;
        String inputtedCountries;
        String[] countries;
        final Scanner sc = new Scanner(System.in);
        double[] DeathValues;
        try {
            System.out.print("Enter Name Of The File : ");
            String file = sc.next();
            sc.nextLine();
            final Scanner fsc = new Scanner(new File(file));
            accounts = readData(fsc);
        } catch (Exception ex) {
            accounts = null;  
        }
        if (accounts == null) {
            System.out.println("Couldn't read the file.");
        } else {
            
            do {
                System.out.print("Enter names of Countries separated by commas: ");
                inputtedCountries = sc.nextLine();
                if (!inputtedCountries.equalsIgnoreCase("exit")) {
                    Plot2DPanel plot = new Plot2DPanel();
                    
                    countries = inputtedCountries.split(",");
                    for (String name : countries) {
                        name = name.trim(); 
                        if (!accounts.containsKey(name)) {
                            System.out.printf("%s is not in the data.\n", name);
                        } else {
                            DeathValues = accounts.get(name); 
                            plot.addLinePlot(name, getDays(DeathValues.length), DeathValues);
                        }
                    }
                    
                    setUpAndShowPlot(plot);
                }
            } while (!inputtedCountries.equalsIgnoreCase("exit"));
            System.out.println("Thank you");
        }
    }
}