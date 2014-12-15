package org.vicinity.base.ansj;

import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.domain.Term;
import org.vicinity.base.*;

public class AnsjSegmentor implements WordSegmentor
{
    public List<org.vicinity.base.Term> segSentence(String sentence)
    {
        ArrayList<org.vicinity.base.Term> terms = new ArrayList<org.vicinity.base.Term>();

        List<org.ansj.domain.Term> ansjTerms = NlpAnalysis.parse(sentence);
        for(org.ansj.domain.Term term : ansjTerms)
        {
            Word w = new Word(term.getName());
            TermType type = this.mapping(term.nature());

            terms.add(new org.vicinity.base.Term(w, type));
        }

        return terms;
    }

    public TermType mapping(org.ansj.domain.Nature nature)
    {
    }
}
