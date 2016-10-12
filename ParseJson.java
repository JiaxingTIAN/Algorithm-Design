import java.util.HashSet;
import java.util.Set;

/**
 * Created by jxtain on 10/12/16.
 */
public class ParseJSON {
    public static String parseJson(String json){
        StringBuilder res = new StringBuilder();
        int indent = 0;

        for(char c:json.toCharArray()){

            if(c == '{' || c == '['){
                res.append(c + "\n");
                addIndent(res, ++indent);
            }else if(c == ','){
                res.append(c + "\n");
                addIndent(res, indent);
            }else if(c == '}' || c == ']'){
                res.append("\n");
                addIndent(res, --indent);
                res.append(c);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
    public static void addIndent(StringBuilder str, int indent){
        for(int i=0; i<indent; i++){
            str.append("\t");
        }
    }
}
