
/**
 * Part2 of the Finding a Gene in DNA module of Java Programming:
 * Solving Problems with Software through Coursera
 * 
 * @author Zachary Carter
 * @version 20191217
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // Find the gene in the given String dna. Takes Strings startCodon and stopCodon. 
        // Figure out case, copy input accordingly.
        String dnaCopy = "";
        
        if (dna.compareTo(dna.toUpperCase()) == 0) {
            // input is all upper case, safe for our analysis
            dnaCopy = dna;
            
        } else if (dna.compareTo(dna.toLowerCase()) == 0) {
            // input is all lowercase. Copy uppercase for our analysis.
            dnaCopy = dna.toUpperCase();
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            // mixed case
            return "";
        }
        
        // Find start codon. Return null string if not found.
        int startIndex = dnaCopy.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }
        
        // Find stop codon. Return null string if not found.
        int stopIndex = dnaCopy.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        
        // Verify valid codon sequence. Return null string if not found.
        // Forming from original string to preserve case
        if ((stopIndex - startIndex) % 3 == 0) {
            String gene = dna.substring(startIndex, stopIndex+3);
            return gene;
        } else {
            return "";
        }
        
    }
    
    public void _testHelper(String dna, String startCodon, String stopCodon) {
        // simple helper function to reduce repeated code in testSimpleGene
        System.out.println("String input: " + dna);
        String result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene found: " + result);
    }
    
    public void testSimpleGene() {
        // Define repeat variables
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        // Test case 1: No Start Codon
        String dna1 = "TAATAATAATAA";
        _testHelper(dna1, startCodon, stopCodon);
        
        // Test case 2: No Stop Codon
        String dna2 = "ATGATGATGATG";
        _testHelper(dna2, startCodon, stopCodon);
        
        // Test case 3: No Start or Stop Codon
        String dna3 = "FOOOOOOD";
        _testHelper(dna3, startCodon, stopCodon);
        
        // Test case 4: Valid gene
        String dna4 = "AATATGCCGAGTTAAATT";
        _testHelper(dna4, startCodon, stopCodon);
        
        // Test case 5: Invalid codons between start and stop
        String dna5 = "AATATGCCGGTTAAATT";
        _testHelper(dna5, startCodon, stopCodon);
        
        // Test case 6: Valid gene, lowercase
        String dna6 = "aatatgccgagttaaatt";
        _testHelper(dna6, "atg", "taa");
        
        // Test case 6: Valid gene, mixed case
        String dna7 = "aatatgccgAgttaaatt";
        _testHelper(dna7, "atg", "taa");
    }
    
}
    
