package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import fachade.DSLModel;

import java.util.ArrayList;

public interface ICompilationUnitTestHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model);
}
