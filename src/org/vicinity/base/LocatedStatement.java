package org.vicinity.base;
import java.util.*;
public class LocatedStatement
{
    public static class Similarity
    {
        public Similarity(Statement.Similarity sim, Location.Distance dist)
        {
        }
    }

    public Similarity computeSimilarity(LocatedStatement other)
    {
        Statement.Similarity statementSimilarity = this._statement.computeSimilarity(other._statement);
        Location.Distance distance = _location.distance(other._location);
        return new Similarity(statementSimilarity, distance);
    }

    protected StatementId _id;
    protected Location _location;
    protected Statement _statement;
    protected List<Response> _responses;
}


