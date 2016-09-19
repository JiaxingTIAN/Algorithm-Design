 /* N - number of cups
 * This will run in O(N) time. You can fetch in O(1) time, as 
 * they are stored in array. Let me know if you see any problem!
 */

public class FillCups {
  private double[][] cups;
  private int rows;
  private double givenWater;
  
  FillCups(int rows, double givenWater){
    this.cups = new double[rows][rows];
    this.givenWater = givenWater;
    this.rows = rows;
    
    fillWaterInCups(0, 0, givenWater);
  }
  
  public void fillWaterInCups(int i, int j, double water) {
    if(i < rows && water > 0){
      cups[i][j] = cups[i][j] + water;
      double remainingWater = cups[i][j] > 1 ? cups[i][j]-1 : water-1;
      
      fillWaterInCups(i+1, j, remainingWater/2);
      cups[i][j] = cups[i][j] > 1 ? 1 : cups[i][j];
      fillWaterInCups(i+1, j+1, remainingWater/2);      
      cups[i][j] = cups[i][j] > 1 ? 1 : cups[i][j];      
    }
  }
  
  public void printWaterInCups(){
    for(int i=0;i<rows;i++) {
      for(int j=0; j<=i; j++){
        System.out.print(cups[i][j]+" ");
      }
      System.out.println();
    }
  }
  
  public double amountOfWaterIn(int row, int col){
    return cups[row][col];
  }
  
  public static void main(String[] args) {
    FillCups fc = new FillCups(10, 12);
    fc.printWaterInCups();
  }
     public static void CalculateWater(int level, int water)
        {
            int count = (level * (level + 1)) / 2;
            float[] arr = new float[count];

            arr[0] = water;
            int counter = 1;
            level = 0;
            for(int i=0; i<count; i++)
            {
                if (counter == i)
                {
                    level++;
                    counter = counter + level +1;
                }
                if (arr[i] > 1)
                {
                    float rem = arr[i] - 1;
                    arr[i] = 1;
                    arr[i + level + 1] += rem / 2;
                    arr[i + level + 2] += rem / 2;
                }
                
            }
        }
}

 
