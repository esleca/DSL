package com.dsl.services.visitor;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.visitors.VisitorBase;
import com.dsl.logic.visitors.VisitorDSL;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import ASTMCore.ASTMSource.CompilationUnit;


@Component
public class VisitorService implements IVisitorService {

	@Override
	public void visitCompilationUnits(DSLModel model) {
		for (CompilationUnit compilationUnit : model.getCompilationUnits()) {
            VisitorBase dslVisitor = new VisitorDSL();
            dslVisitor.visitCompilationUnit(compilationUnit);

            Class fileClass = dslVisitor.getFrameDSL().getCompilationUnit();
            model.setClass(fileClass);

            ArrayList<Function> functions = fileClass.getFunctions();
            model.setCompilationUnitFunctions(functions);
        }
	}
}
