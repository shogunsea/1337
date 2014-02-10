// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
public class Solution {
    public int maxPoints(Point[] points) {
    	if(points.length==0) return 0;
    	int maxPoints = 0;

    	for(int i = 0; i<points.length; i++){
    		int localMax = 0;
    		HashMap<Double, Integer> slopeCount = new HashMap<Double, Integer>();
    		Point current = points[i];
    		int duplicates = 0;

    		for(int j = 0; j<points.length; j++){
    			if(i==j) continue;
    			Point comparison = points[j];
    			if(current.x == comparison.x && current.y == comparison.y){
    				duplicates++;
    			}else{
    				double slope = (comparison.y - current.y)/((comparison.x - current.x)*1.0);
    				if(slopeCount.containsKey(slope)){
    					slopeCount.put(slope, slopeCount.get(slope)+1);
    				}else{
    					slopeCount.put(slope, 1);
    				}
    			}
    		}
    		int maxSlope = 0;
    		for(int k : slopeCount.values()){
    			if(k>=maxSlope)
    				maxSlope = k;
    		}

    		localMax = maxSlope + duplicates;

    		if(localMax>=maxPoints){
    			maxPoints = localMax;
    		}
    	}
    	return maxPoints+1;
    }
}
