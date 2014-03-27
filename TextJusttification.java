// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.
public class Solution {
   public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        // if(words.length==0||L==0){
        // 	return result;
        // }

        ArrayList<String> temp = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

//        temp.add("");

        int count = 0;

        if(words.length==1&&words[0].equals("")){
        	temp.add("");
        	justify(words, result, sb, temp, L, 0);
        }else{
        	// for(String s : words){
        	for(int i = 0; i<words.length; i++){
        		String s = words[i];
	        	if(count>=L||count+s.length()>L){// lenght reaches L
	        		justify(words, result, sb, temp, L, i-1);
	        		sb = new StringBuilder();
	        		temp = new ArrayList<String>();
	        		
	        		count = 0;
	        		if(s.equals("")&&words.length==1){
	        			continue;
	        		}
	//        		if(L==0){
	//        			continue;
	//        		}
	        	}
	        	int nextLength = count + s.length();
	        	if(nextLength == L){
	        		temp.add(s);
	        		count+=s.length();
	        	}else if(nextLength < L ){
	        		temp.add(s);
	        		count += s.length() + 1;// add one space.
	        	}
	        }


	        if(temp.size()>0){
	        	justify(words, result, sb, temp, L, words.length-1);
	        }
        }

        return result;
    }

    public static void justify(String[] words, ArrayList<String> result, StringBuilder sb, ArrayList<String> temp, int L, int index){
    		int count = 0;

    		for(String s: temp){
    			count+=s.length();
    			// sb.append(s);
    			// sb.append(' ');
    		}

    		// only contains one word, left justification.
    		if(temp.size()==1){
    			String s = temp.get(0);
    			if(s.equals("")){
    				for(int i = 0; i<L; i++){
    					sb.append(' ');
    				}
    				result.add(sb.toString());
	    			return;
    			}else{
    				sb.append(s);
    				int padding = L - s.length(); 
	    			for(int i =0; i<padding;i++){
	    				sb.append(' ');
	    			}
	    			result.add(sb.toString());
	    			
	    			return;
    			}
    			
    		}

    		// current list contains last word, left justification.
    		if(index==words.length-1){
    			int slot = temp.size()-1;
    			int padding = L - (count+slot);

    			// append all words but last one.
    			for(int i = 0; i<temp.size()-1; i++){
    				sb.append(temp.get(i));
    				sb.append(' ');
    			}
    			//append last word.
    			sb.append(temp.get(temp.size()-1));
    			//add padding
    			for(int i=0; i<padding; i++){
    				sb.append(' ');
    			}

    			result.add(sb.toString());
    			return;
    		}

    		int slot = temp.size()-1;
    		int space = L - count;

    		if(space%slot==0){
    			// can be evenly distributed.
    			int slot_space = space/slot;
    			for(int i = 0; i<=temp.size()-2; i++){
    				// no not append space after last word.
    				sb.append(temp.get(i));
    				for(int j = 0; j<slot_space; j++){
    					sb.append(' ');
    				}
    			}
    			sb.append(temp.get(temp.size()-1));
    			result.add(sb.toString());
    			return;
    		}else{
    			int[] assign = new int[slot];
    			int slot_space = space/slot;
    			for(int i=0;i<slot; i++){
    				assign[i] = slot_space;
    			}
    			int mod = space%slot;
    			for(int i = 0; i<mod; i++){
    				assign[i] = slot_space +1;
    			}

    			for(int i = 0; i<=slot; i++){
    				sb.append(temp.get(i));
    				for(int j = 0; j<= assign[i]; j++){
    					sb.append(' ');
    				}
    			}
    			sb.append(temp.get(temp.size()-1));

    			// // padding for first string.
    			// sb.append(temp.get(0));
    			// for(int i =0; i<first; i++){
    			// 	sb.append(' ');
    			// }
    			// // padding for middle string.
    			// for(int i = 1; i<=temp.size()-2; i++){
    			// 	sb.append(temp.get(i));
    			// 	for(int j = 0; j<slot_space; j++){
    			// 		sb.append(' ');
    			// 	}
    			// }
    			// // no padding for last string.
    			// sb.append(temp.get(temp.size()-1));

    			result.add(sb.toString());
    			return;
    		}
    		// System.out.println(count+" of 16");
    		// result.add(sb.toString());
    }
}