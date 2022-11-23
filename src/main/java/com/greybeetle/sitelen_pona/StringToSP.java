package com.greybeetle.sitelen_pona;
import com.greybeetle.sitelen_pona.sitelen_pona;

import static com.greybeetle.sitelen_pona.sitelen_pona.TokiPonaLatin;
import static com.greybeetle.sitelen_pona.sitelen_pona.TokiPonaSitelen;

public class StringToSP {
    public static String SubstituteSitelen(String OriginalString){
        String newString = String.join("", " ", OriginalString);
        int count = 0;
        for (String s : TokiPonaLatin) {
            if(newString.contains(s)){
                int wordIndex = newString.indexOf(s);
                newString = newString.replace(s, TokiPonaSitelen[count]);
                newString = newString.join("", newString, " ");
                if(wordIndex == 0) {
                    return newString;
                }
                return newString.substring(1);
            }
            count++;
        }

        return OriginalString;
    }

}
