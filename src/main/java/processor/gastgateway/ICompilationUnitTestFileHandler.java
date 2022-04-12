package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import fachade.GestorModel;

import java.util.ArrayList;

public interface ICompilationUnitTestFileHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(GestorModel model);
}
