package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import gestors.GestorModel;

import java.util.ArrayList;

public interface ICompilationUnitTestHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(GestorModel model);
}
