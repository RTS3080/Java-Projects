
public class test {
    public class Sportscar{
        private int cost;
        private int speedLimit;
        private int milesPerHour;

        public Sportscar(){
            cost=0;
            speedLimit=0;
            milesPerHour=0;
        }

        public Sportscar(int c, int sl, int mph) {
            cost = c;
            speedLimit = sl;
            milesPerHour = mph;
        }

        public void speedUp(int speed){
            milesPerHour+=speed;
        }
        public void slowDown(int speed){
            milesPerHour-=speed;
        }
        public void setSpeedLimit(int speed){
            speedLimit=speed;
        }
        public boolean isSpeeding() {
            return milesPerHour>speedLimit;
        }
        public String toString(){
            return "The cost of the car is: "+cost+"\nThe speed limit is: "+speedLimit+"\nYou are driving: "+milesPerHour;
        }

    }
}

