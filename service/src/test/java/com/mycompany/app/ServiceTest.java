package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert.*;

/**
 * Unit test for simple App.
 */
public class ServiceTest
    extends TestCase
{
    public static void testSearch(){
      assertNotNull(Service.search("abc"));
    }
}
