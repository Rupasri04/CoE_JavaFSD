import java.io.*;
import java.util.*;

public class LogFileAnalyzer {
    private Set<String> keywords;
    
    public LogFileAnalyzer(Set<String> keywords) {
        this.keywords = keywords;
    }
    
    public void analyzeLogFile(String inputFile, String outputFile) {
        Map<String, Integer> keywordCounts = new HashMap<>();
        for (String keyword : keywords) {
            keywordCounts.put(keyword, 0);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        keywordCounts.put(keyword, keywordCounts.get(keyword) + 1);
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
            
            
            writer.newLine();
            writer.write("Summary of keyword occurrences:");
            writer.newLine();
            for (Map.Entry<String, Integer> entry : keywordCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        Set<String> keywords = new HashSet<>(Arrays.asList("ERROR", "WARNING"));
        
        
        String inputFile = "C:\\Users\\C.B.Rupa sri\\OneDrive\\Desktop\\java\\source.txt"; 
        String outputFile = "log_analysis.txt";
        
        LogFileAnalyzer analyzer = new LogFileAnalyzer(keywords);
        analyzer.analyzeLogFile(inputFile, outputFile);
        
        System.out.println("Log analysis completed. Check " + outputFile + " for results.");
    }
}
