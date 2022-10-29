// https://www.youtube.com/watch?v=aeKAMmZjvb4
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        List<Seed> plant=new ArrayList<>();
        
        for(int i=0;i<plantTime.length;i++){
            plant.add(new Seed(plantTime[i],growTime[i]));
        }
        
        Collections.sort(plant,(a,b) -> (b.growthTime - a.growthTime));
        
        int time=0;
        int max=0;
        
        for(int i=0;i<plantTime.length;i++){
            time+=plant.get(i).plantTime;
            max=Math.max(max,time+plant.get(i).growthTime);
        }
        
        return max;
        
    }
    
    private class Seed{
        
        int plantTime;
        int growthTime;
        
        public Seed(int p,int g){
            this.plantTime=p;
            this.growthTime=g;
        }
    }
}