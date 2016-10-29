/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buff;    //buffer for read4
    private int pos;        //position of globle buffer
    private int count;      //actual size of globle buffer
    
    public Solution(){
        buff = new char[4];
        pos = 0;
        count = 0;
    }
    
    public int read(char[] buf, int n) {
        int pt = 0;     //Character read 
        while(pt < n){
            if(pos == count){   //reach end of buffer
                pos = 0;        //Start over
                count = read4(buff);
            }
            while(pt < n && pos < count){   //Write to ouput buffer
                buf[pt++] = buff[pos++];
            }
            if(count < 4){
                break;  //EOF break
            }
        }
        return pt;
    }
}
