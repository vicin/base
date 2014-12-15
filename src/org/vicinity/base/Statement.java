package org.vicinity.base;
import java.util.*;
import java.lang.*;

public class Statement
{

    public Statement(String title, String text)
    {
        _title = new Sentence(title);
        _text = new Sentence(_text);
    }

    public static class Similarity
    {
    }

    public Similarity computeSimilarity(Statement other)
    {
    }

    public Sentence getTitle()
    {
        return _title;
    }

    public Sentence getText()
    {
        return _text;
    }

    public List<Response> getResponses()
    {
        return _responses;
    }

    protected Sentence _title;
    protected Sentence _text;

}


