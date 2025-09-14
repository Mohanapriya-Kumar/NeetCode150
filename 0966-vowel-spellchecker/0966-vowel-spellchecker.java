class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        /*Exact Match || lowermatch || vowel replacable match
        T(n) = O((N + M)·L)
        S(n) = O((N + M)·L)*/
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> caseInsensitiveMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();
        for(String word : wordlist){
            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower,word);
            vowelMap.putIfAbsent(devowel(lower),word);
        }
        int n = queries.length;
        String[] res = new String[n];
        for(int i = 0; i < n; i++){
            String query = queries[i];
            if(words.contains(query)){
                res[i] = query;
            }
            else{
                String lower = query.toLowerCase();
                if(caseInsensitiveMap.containsKey(lower)){
                    res[i] = caseInsensitiveMap.get(lower);
                }
                else{
                    String devoweled = devowel(lower);
                    if(vowelMap.containsKey(devoweled)){
                        res[i] = vowelMap.get(devoweled);
                    }
                    else{
                        res[i] = "";
                    }
                }
            }
        }
        return res;
    }
    private String devowel(String word){
        return word.replaceAll("[aeiou]","#");
    }
}