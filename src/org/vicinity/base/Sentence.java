package org.vicinity.base;
import java.util.*;

public class Sentence
{
    public Sentence(String text)
    {
        _sentence = text;
    }

    protected String _sentence;
    protected List<Term> getSegedTerms()
    {
        _terms = this.getWordSegmentor().segSentence(_sentence);
        return _terms;
    }

    protected List<Term> getKernelTerms()
    {
        List<Term> terms = this.getSegedTerms();
        _kernels = this.getKernelDeriver().deriveKernels(terms);

        return _kernels;
    }

    public WordSegmentor getWordSegmentor();
    public KernelDeriver getKernelDeriver();

    protected List<Term> _terms;
    protected List<Term> _kernels;
}


