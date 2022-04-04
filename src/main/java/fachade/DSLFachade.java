package fachade;

import ASTMCore.ASTMSource.CompilationUnit;
import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;
import processor.gastgateway.CompUnitTestHandler;
import processor.gastgateway.ICompUnitHandler;
import processor.gastgateway.CompUnitHandler;
import processor.gastgateway.ICompUnitTestHandler;
import processor.gastgateway.visitors.VisitorBase;
import processor.gastgateway.visitors.VisitorDSL;
import processor.testscenarios.*;
import processor.unittests.*;
import utils.IPrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DSLFachade implements IDSLFachade {

    private IPrinter printer;
    private DSLModel model;

    public DSLFachade(IPrinter printer){
        this.printer = printer;
        this.model = new DSLModel();
    }

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {

        createCompilationUnits(unitTestRequest);
        visitCompilationUnits();
        processTestableUnits();
        processTestScenarios();
        processUnitTests();
        processCompilationUnitsTests();
        return null;
    }

    /**
     * Call the compilation units handler in order
     * to generate compilation units based on input path
     *
     * @param unitTestRequest
     * @throws IOException
     * @throws UnsupportedLanguageException
     */
    private void createCompilationUnits(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException {
        ICompUnitHandler handler = new CompUnitHandler(unitTestRequest.getLanguage());

        ArrayList<CompilationUnit> compUnits = handler.createCompilationUnits(unitTestRequest.getPath());

        model.setCompilationUnits(compUnits);
    }

    /**
     *  Create a visitor DSL to visit the entire compilation unit
     *  This method set a list of the compilation unit functions
     */
    private void visitCompilationUnits(){
        for (CompilationUnit compilationUnit : model.getCompilationUnits()) {

            VisitorBase dslVisitor = new VisitorDSL();
            dslVisitor.visitCompilationUnit(compilationUnit);

            Class fileClass = dslVisitor.getFrameDSL().getCompilationUnit();
            model.setClass(fileClass);

            ArrayList<Function> functions = fileClass.getFunctions();

            model.setCompilationUnitFunctions(functions);
        }
    }

    /**
     * Create a transformation dsl for testable units
     * This method filter the functions in order to obtain
     * the valid testable units.
     */
    private void processTestableUnits(){
        ITestableUnitHandler testableUnitHandler = new TestableUnitHandler();

        ArrayList<Function> functions = model.getCompilationUnitFunctions();
        ArrayList<Function> testableUnits = testableUnitHandler.processTestableUnits(functions);

        model.setTestableUnits(testableUnits);
    }

    /**
     * Use a test scenario handler to define
     * the test scenario object representations.
     *
     * @throws ValueTypeNotFoundException
     * @throws AssertNotFoundException
     */
    private void processTestScenarios()throws ValueTypeNotFoundException, AssertNotFoundException {
        //TODO: IMPLEMENT

        IExpectedPrimitive expPrimitive = new ExpectedPrimitiveHandler();
        IExpectedParameterized expParameterized = new ExpectedParameterizedHandler();

        ITestScenarioHandler handler = new TestScenarioHandler(expPrimitive, expParameterized);

//        ArrayList<TestScenarioRun> testScenarioRuns = handler.processTestScenariosRun(dslModel.getTestScenariosPath());
//        ArrayList<TestScenario> testScenarios = handler.processTestScenarios(testScenarioRuns, model.getTestableUnits());
//
//        model.setTestScenarios(testScenarios);
    }

    /**
     * Use the unit test dsl to convert from the
     * test scenarios to the unit test object representations
     *
     * @throws AssertNotFoundException
     */
    private void processUnitTests() throws AssertNotFoundException {
        IUnitTestArrangeHandler arrangeHandler = new UnitTestArrangeHandler();
        IUnitTestActionHandler actionHandler = new UnitTestActionHandler();
        IUnitTestAssertHandler assertHandler = new UnitTestAssertHandler();
        IUnitTestHandler unitTestHandler = new UnitTestHandler(arrangeHandler, actionHandler, assertHandler);

        ArrayList<TestScenario> testScenarios = model.getTestScenarios();
        ArrayList<UnitTest> unitTests = unitTestHandler.processUnitTests(testScenarios);

        model.setUnitTests(unitTests);

        printUnitTests();
    }

    /**
     *
     */
    private void processCompilationUnitsTests(){
        ICompUnitTestHandler compilationUnitTestHandler = new CompUnitTestHandler();

        ArrayList<CompilationUnit> compilationUnitTests = compilationUnitTestHandler.processCompilationUnitTests(model);

        model.setCompilationUnitsTests(compilationUnitTests);
    }

    /**
     * Use the console printer to print unit tests
     * on the console screen.
     */
    private void printUnitTests(){
        for (var ut : model.getUnitTests()){
            printer.printUnitTest(ut);
        }
    }




    @Override
    public UnitTest editUnitTest(String unitTestRequest) {
        return null;
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return null;
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return null;
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return null;
    }

}
