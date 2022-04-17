package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import fachade.models.DSLModel;

import java.util.ArrayList;

public interface ICompilationUnitTestHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model);
}
