package org.vicinity.base.IDF;
import org.vicinity.base.*;
import java.util.*;

public class WordIDFDict
{
    static protected Map<Word, Integer> _wordFreqMap = new HashMap<Word, Integer>();
    static protected Map<Word, IDF> _wordIDFMap = new HashMap<Word, IDF>();
    static void init(String filePath)
    {
        try {
            File fileDir = new File(filePath);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(fileDir), "GB2312"));

            String str;
            // sum of freq of all words
            int freqSum = 0;

            while ((str = in.readLine()) != null) {
                String[] strVec = str.split("\t");
                Word w = new Word(strVec[0]);
                int freq = strVec[1];
                freqSum += freq;

                _wordFreqMap.put(w, new Integer(freq));
            }

            in.close();

            // calculate the value of IDF = freqSum / word_freq;
            for(Map.Entry<Word, Integer> entry : _wordFreqMap.entrySet())
            {
                _wordIDFMap.put(entry.getKey(), (float)freqSum / (float)entry.getValue());
            }
        } 
        catch (UnsupportedEncodingException e) 
        {
            System.out.println(e.getMessage());
        } 
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    static IDF getIDF(Word word)
    {
        return _wordIDFMap.get(word);
    }
}
