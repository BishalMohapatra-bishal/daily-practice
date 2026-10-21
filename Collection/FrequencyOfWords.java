package Collection;
import java.util.*;

class SolutionFrequency {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Build the frequency map
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
    
        }

        // Input: words = ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4

        // Step 2: Create a PriorityQueue with custom sorting rules
        PriorityQueue<String> maxHeap = new PriorityQueue<>((w1, w2) -> {
            int freq1 = countMap.get(w1); // it return the value coressponding to the key
            int freq2 = countMap.get(w2);

            // Primary condition: Higher frequency comes first using comparator
            if (freq1 != freq2) {
                return freq2 - freq1;
            }
            // Secondary condition: Alphabetical (lexicographical) order if counts match
            // using comparable interface compareTo method
            return w1.compareTo(w2);
        });

        // Step 3: Add all unique words to the PriorityQueue
        maxHeap.addAll(countMap.keySet());

        // Step 4: Extract top k frequent words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}


public class FrequencyOfWords {
    public static void main(String[] args) {

        SolutionFrequency sf = new SolutionFrequency();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(sf.topKFrequent(words, 4));

        
    }
}
