/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    private int buffpt = 0;             //idx of the buff being read
    private int buffcnt = 0;            //count of character read from read4
    private char[]buff = new char[4];   //Destination buff for read4 
    public int read(char[] buf, int n) {
        int pt = 0;
        while(pt < n){
            if(buffpt == 0){    //buff is used up or empty
                buffcnt = read4(buff);  //read to buff
            }
            while(pt < n && buffpt < buffcnt){
                buf[pt++] = buff[buffpt++]; //copy buff content
            }
            if(buffpt == buffcnt){  //all content in buff is read
                buffpt = 0; //restart at zero index
            }
            if(buffcnt < 4){
                break;  //End of file
            }
        }
        return pt;
    }
}
