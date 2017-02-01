package TuesdayProject;

import TuesdayProject.UnitTests.PivotTableTests;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PivotTableTests ptv = new PivotTableTests();
        ptv.ChooseSchemaTest();
    }
}