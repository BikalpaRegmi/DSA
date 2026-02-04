public class TowerOfHanoi{
   public static void main(String[] args) {
        TowerOfHanoi TOH= new TowerOfHanoi();

        TOH.solveHanoi(3, 'A', 'B', 'C');
      }
}


class  TowerOfHanoiImplement{
    public void solveHanoi(int n, char source, char temp, char destination) {
        if (n == 1) {
            System.out.println("Moved disk 1 from " + source + " to " + destination );
            return;
        }
        
        solveHanoi(n - 1, source, destination, temp);
        
        System.out.println("Moved disk " + n + " from " + source + " to " + destination );
        
        solveHanoi(n - 1, temp, source, destination);
    }
    
}