/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char []buff = new char[4]; //tmp buff for read 4 character
        boolean eof = false;    //whether reach the end of file
        int read = 0;           //actual character read
        
        while(!eof && read < n){
            int count = read4(buff);    //read 4 character from buffer
            eof = count < 4;    //reach end of file if count smaller than 4
            count = Math.min(count, n - read);  //actual count readed
            for(int i=0; i<count; i++){
                buf[read++] = buff[i];
            }
        }
        return read;
    }
}
