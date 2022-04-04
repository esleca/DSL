package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import fachade.DSLModel;

import java.util.ArrayList;

public interface ICompUnitTestHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model);
}
