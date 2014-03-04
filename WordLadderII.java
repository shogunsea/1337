public class Solution{
  public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
  HashMap<String, Integer> level = new HashMap<String, Integer>();
  LinkedList<String> queue = new LinkedList<String>();
  ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
  
  if(start == null || end == null || start.length()!=end.length()) return result;
  
  HashSet<String> path = new HashSet<String>();
  int minLen = Integer.MAX_VALUE;
  visited.put(start, path);//only difference from word ladder I
  level.put(start, 1);
  queue.add(start);
  
  while(!queue.isEmpty()){
   String head = queue.remove();
   char[] chars = head.toCharArray();
   for(int i = 0; i < head.length(); i++){
    char old = chars[i];
    for(char letter = 'a'; letter <= 'z'; letter++){
     chars[i] = letter;
     String nextWord = new String(chars);
     //two possible situations
     //level does not contain nextWord
     //level contains nextWord and near the start
     if(dict.contains(nextWord) && (!level.containsKey(nextWord) || (level.containsKey(nextWord) && level.get(nextWord) > level.get(head)))){
      //we update the path, visited, level
      if(visited.containsKey(nextWord)){
       visited.get(nextWord).add(head);
      }else{
       path = new HashSet<String>();
       path.add(head);
       visited.put(nextWord, path);
       level.put(nextWord, level.get(head) + 1);
       queue.add(nextWord);
      }
     }
      
     if(nextWord.equals(end)){
      if(level.get(head) < minLen){
       ArrayList<String> entry = new ArrayList<String>();
       entry.add(end);
       result.addAll(backtrace(head,visited,entry));
       minLen = level.get(head)+1;
      }else{
       break;
      }
     }
     chars[i] = old;
      
    }
   }
  }
   return result;
 }

 private ArrayList<ArrayList<String>> backtrace(String end,
   HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
  ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
  ArrayList<String> entry = new ArrayList<String>(path);
  entry.add(0,end);
  if(visited.get(end).size()<1){
   result.add(entry);
   return result;
  }
  
  for(String str : visited.get(end)){
   result.addAll(backtrace(str,visited,entry));
  }
  return result;
 }
}