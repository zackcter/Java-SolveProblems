
/**
 * Part1 of the Finding a Gene in DNA module of Java Programming:
 * Solving Problems with Software through Coursera
 * 
 * @author Zachary Carter
 * @version 20191217
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        // Find start codon. Return null string if not found.
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        
        // Find stop codon. Return null string if not found.
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        
        // Verify valid codon sequence. Return null string if not found.
        if ((stopIndex - startIndex) % 3 == 0) {
            String gene = dna.substring(startIndex, stopIndex+3);
            return gene;
        } else {
            return "";
        }
        
    }
    
    public void _testHelper(String input) {
        // simple helper function to reduce repeated code in testSimpleGene
        System.out.println("String input: " + input);
        String result = findSimpleGene(input);
        System.out.println("Gene found: " + result);
    }
    
    public void testSimpleGene() {
        // Test case 1: No Start Codon
        String dna1 = "TAATAATAATAA";
        _testHelper(dna1);
        
        // Test case 2: No Stop Codon
        String dna2 = "ATGATGATGATG";
        _testHelper(dna2);
        
        // Test case 3: No Start or Stop Codon
        String dna3 = "FOOOOOOD";
        _testHelper(dna3);
        
        // Test case 4: Valid gene
        String dna4 = "AATATGCCGAGTTAAATT";
        _testHelper(dna4);
        
        // Test case 5: Invalid codons between start and stop
        String dna5 = "AATATGCCGGTTAAATT";
        _testHelper(dna5);
    }
    
}
    
