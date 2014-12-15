package org.vicinity.base.IDF;
import org.vicinity.base.*;
import java.util.*;

public class IDFKernelDeriver implements KernelDeriver
{
    public List<Term> deriveKernels(List<Term> terms)
    {
        IDF idfSum = new IDF();
        for(Term term : terms)
        {
            Word w = term.getWord();
            IDF idf = WordIDFDict.getIDF(w);
            idfSum += idf;
        }

        ArrayList<Term> kernels = new ArrayList<Term>();

        for(Term term : terms)
        {
            Word w = term.getWord();
            IDF idf = WordIDFDict.getIDF(w);

            float ratio = idf/idfSum;

            if(ratio >= this.getIDFRatioThreshold())
            {
                kernels.add(term);
            }
        }

        return kernels;
    }

    public float getIDFRatioThreshold()
    {
        return 0.1;
    }
}
