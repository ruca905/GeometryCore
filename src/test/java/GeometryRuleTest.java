import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GeometryRuleTest {
    @Test
    public void applyModeNamespaceToRuleTest(){
        //Rule
        Point A = new Point();
        A.setAnyObject();
        Point B = new Point();
        B.setAnyObject();
        Point D = new Point();
        D.setAnyObject();
        LineSegment AB = new LineSegment(A, B);
        AB.setAnyObject();
        LineSegment AD = new LineSegment(A, D);
        AD.setAnyObject();

        //Model
        Point A2 = new Point();
        Point B2 = new Point();
        Point D2 = new Point();
        LineSegment AB2 = new LineSegment(A2, B2);
        LineSegment AD2 = new LineSegment(A2, D2);

        GeometryRule geometryRule = new GeometryRule(new LinkedList<>(Arrays.asList(new BelongFact(AB, AD))),
                new LinkedList<>(Arrays.asList(new BelongFact(A, AD), new BelongFact(B, AD))));
        LinkedList<GeometryFact> linkedList = geometryRule.applyModeNamespaceToRule(new LinkedList<>(Arrays.asList(new BelongFact(AB2, AD2))));
        Assert.assertEquals(((BelongFact)linkedList.peek()).object, AB2);
        Assert.assertEquals(((BelongFact)linkedList.peek()).subject, AD2);
    }

    @Test
    public void addNewFactTest(){
        Point A = new Point();
        A.setAnyObject();
        Point B = new Point();
        B.setAnyObject();
        Point D = new Point();
        D.setAnyObject();
        LineSegment AB = new LineSegment(A, B);
        AB.setAnyObject();
        LineSegment AD = new LineSegment(A, D);
        AD.setAnyObject();

        Point A2 = new Point();
        Point B2 = new Point();
        Point D2 = new Point();
        LineSegment AB2 = new LineSegment(A2, B2);
        LineSegment AD2 = new LineSegment(A2, D2);

        GeometryRule geometryRule = new GeometryRule(new LinkedList<>(Arrays.asList(new BelongFact(AB, AD))),
                new LinkedList<>(Arrays.asList(new BelongFact(A, AD), new BelongFact(B, AD))));
        LinkedList<GeometryFact> linkedList = geometryRule.addNewFact(new LinkedList<>(Arrays.asList(new BelongFact(AB2, AD2))));

        System.out.println("HELLO");
    }
}
