public class LongestCommonPref {
    public String longestCommonPrefix(String[] strs) {


        for(int i=0; i<strs[0].length(); i++){
            int b=0;
            for(int j=1; j<strs.length; j++){
                //if(strs[j].charAt(i+1))
                if(strs[j].substring(0, i+1).contentEquals(strs[0].substring(0, i+1))){
                    continue;
                }
                else{
                    if(i==0)
                        return "";
                    else
                        return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
