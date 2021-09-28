package processor.gastgateway.visitors;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.*;
import ASTMCore.ASTMSyntax.Expression.*;
import ASTMCore.ASTMSyntax.Statement.*;
import ASTMCore.ASTMSyntax.Types.*;
import exceptions.ModifierNotFoundException;
import exceptions.ReturnNotFoundException;

import java.util.List;
import java.util.ArrayList;

public class VisitorDSL extends VisitorBase {

    private boolean WritingReturn;
    private boolean WritingParameterFunction;


    public VisitorDSL(){
        frame = new FrameDSL();
    }

    @Override
    public void visitCompilationUnit(CompilationUnit compilationUnit) {
        // Visit Package
        compilationUnit.getgPackage().accept(this);

        // Visit ProgramScope
        compilationUnit.getOpensScope().accept(this);
    }

    @Override
    public void visitAggregateTypeDefinition(AggregateTypeDefinition aggregateTypeDefinition) {
        aggregateTypeDefinition.getAggregateType().accept(this);
    }

    @Override
    public void visitEnumTypeDefinition(EnumTypeDefinition enumTypeDefinition) {

    }

    @Override
    public void visitEnumLiteralDefinition(EnumLiteralDefinition enumLiteralDefinition) {

    }

    @Override
    public void visitFunctionDefintion(FunctionDefintion functionDefintion) {
        // Create new function
        frame.createFunction();

        // Visit the function modifier
        List<Modifiers> modifiers = functionDefintion.getModifiers();
        for (Modifiers modifier : modifiers){
            if (modifier != null){
                modifier.accept(this);
            }
        }

        // Function name
        String functionName = functionDefintion.getIdentifierName().getNameString();
        frame.writeFunctionName(functionName);

        // Visit the function return
        this.WritingReturn = true;
        functionDefintion.getReturnType().accept(this);
        this.WritingReturn = false;

        // Visit the function parameters
        ArrayList<FormalParameterDefinition> parameters = functionDefintion.getFormalParameters();
        for (FormalParameterDefinition parameterDefinition : parameters){
            if (parameterDefinition != null){
                parameterDefinition.accept(this);
            }
        }

        // Add frame function to frame function list
        frame.writeFunction();
    }

    @Override
    public void visitFormalParameterDefinition(FormalParameterDefinition formalParameterDefinition) {
        // Create new parameter function
        frame.createParameter();

        // Write function parameters
        String parameterName = formalParameterDefinition.getIdentifierName().getNameString();
        frame.writeFunctionParameterName(parameterName);

        // Visit parameter definition type
        this.WritingParameterFunction = true;
        formalParameterDefinition.getDefinitionType().accept(this);
        this.WritingParameterFunction = false;

        // Write parameter to function parameter list
        frame.writeFunctionParameter();
    }

    @Override
    public void visitNameSpaceDefinition(NameSpaceDefinition nameSpaceDefinition) {
        String namespaceDef = nameSpaceDefinition.getNameSpace().getNameString();
        frame.writeFunctionPackage(namespaceDef);
    }

    @Override
    public void visitLabelDefinition(LabelDefinition labelDefinition) {

    }

    @Override
    public void visitImportDeclaration(ImportDeclaration importDeclaration) {

    }

    @Override
    public void visitProgramScope(ProgramScope programScope) {
        ArrayList<DefintionObject> definitionObjects = programScope.getDeclOrDefn();

        for (DefintionObject obj : definitionObjects){
            if (obj != null){
                obj.accept(this);
            }
        }

    }

    @Override
    public void visitAggregateScope(AggregateScope aggregateScope) {
        ArrayList<DefintionObject> definitionObjects = aggregateScope.getDeclOrDefn();

        for (DefintionObject obj : definitionObjects){
            if (obj != null){
                obj.accept(this);
            }
        }

    }

    @Override
    public void visitClassType(ClassType classType) {
        // Set class name
        String className = classType.getNameString().getNameString();
        frame.writeFunctionClass(className);

        // Visit class scope
        classType.getOpensScope().accept(this);
    }

    @Override
    public void visitEnumType(EnumType enumType) {

    }

    @Override
    public void visitMemberObject(MemberObject memberObject) {

    }

    @Override
    public void visitVariableDefinition(VariableDefinition variableDefinition) {

    }

    @Override
    public void visitFragment(Fragment fragment) {

    }

    @Override
    public void visitDerivesFrom(DerivesFrom derivesFrom) {

    }

    @Override
    public void visitImplementsTo(ImplementsTo implementsTo) {

    }

    @Override
    public void visitNamedTypeReference(NamedTypeReference namedTypeReference) {
        String typeReference = namedTypeReference.getTypeName().getNameString();

        if (WritingReturn){
            try {
                frame.writeFunctionReturn(typeReference);
            } catch (ReturnNotFoundException e) {
                e.printStackTrace();
            }
        } else if (WritingParameterFunction){
            frame.writeFunctionParameterType(typeReference);
        }
    }

    @Override
    public void visitParameterizedType(ParameterizedType parameterizedType) {

    }

    @Override
    public void visitArrayType(ArrayType arrayType) {

    }

    @Override
    public void visitTypeParameter(TypeParameter typeParameter) {
    }

    @Override
    public void visitBlockStatement(BlockStatement blockStatement) {

    }

    @Override
    public void visitLabeledStatement(LabeledStatement labeledStatement) {

    }

    @Override
    public void visitEmptyStatement(EmptyStatement emptyStatement) {

    }

    @Override
    public void visitIfStatement(IfStatement ifStatement) {

    }

    @Override
    public void visitWhileStatement(WhileStatement whileStatement) {

    }

    @Override
    public void visitDoWhileStatement(DoWhileStatement doWhileStatement) {

    }

    @Override
    public void visitContinueStatement(ContinueStatement continueStatement) {

    }

    @Override
    public void visitBreakStatement(BreakStatement breakStatement) {

    }

    @Override
    public void visitReturnStatement(ReturnStatement returnStatement) {

    }

    @Override
    public void visitThrowStatement(ThrowStatement throwStatement) {

    }

    @Override
    public void visitExpressionStatement(ExpressionStatement expressionStatement) {

    }

    @Override
    public void visitForCheckAfterStatement(ForCheckAfterStatement forCheckAfterStatement) {

    }

    @Override
    public void visitForIterator(ForIterator forIterator) {

    }

    @Override
    public void visitTryStatement(TryStatement tryStatement) {

    }

    @Override
    public void visitCatchBlock(CatchBlock catchBlock) {

    }

    @Override
    public void visitSwitchStatement(SwitchStatement switchStatement) {

    }

    @Override
    public void visitSwitchCase(SwitchCase switchCase) {

    }

    @Override
    public void visitCaseBlock(CaseBlock caseBlock) {

    }

    @Override
    public void visitDefaultBlock(DefaultBlock defaultBlock) {

    }

    @Override
    public void visitAssertStatement(AssertStatement assertStatement) {

    }

    @Override
    public void visitSynchronizedStatement(SynchronizedStatement synchronizedStatement) {

    }

    @Override
    public void visitDeclarationOrDefinitionStatement(DeclarationOrDefinitionStatement declarationOrDefinitionStatement) {
        declarationOrDefinitionStatement.getDeclOrDefn().accept(this);
    }

    @Override
    public void visitSuperInvocation(SuperInvocation superInvocation) {

    }

    @Override
    public void visitCheckedStatement(CheckedStatement checkedStatement) {

    }

    @Override
    public void visitUncheckedStatement(UncheckedStatement uncheckedStatement) {

    }

    @Override
    public void visitBinaryExpression(BinaryExpression binaryExpression) {

    }

    @Override
    public void visitMultiply(Multiply multiply) {

    }

    @Override
    public void visitModulus(Modulus modulus) {

    }

    @Override
    public void visitDivide(Divide divide) {

    }

    @Override
    public void visitAdd(Add add) {

    }

    @Override
    public void visitSubtract(Subtract subtract) {

    }

    @Override
    public void visitBitLeftShift(BitLeftShift bitLeftShift) {

    }

    @Override
    public void visitBitSignedRightShift(BitSignedRightShift bitSignedRightShift) {

    }

    @Override
    public void visitBitUnsignedRightShift(BitUnsignedRightShift bitUnsignedRightShift) {

    }

    @Override
    public void visitLess(Less less) {

    }

    @Override
    public void visitGreater(Greater greater) {

    }

    @Override
    public void visitNotGreater(NotGreater notGreater) {

    }

    @Override
    public void visitNotLess(NotLess notLess) {

    }

    @Override
    public void visitEqual(Equal equal) {

    }

    @Override
    public void visitNotEqual(NotEqual notEqual) {

    }

    @Override
    public void visitBitAnd(BitAnd bitAnd) {

    }

    @Override
    public void visitBitXor(BitXor bitXor) {

    }

    @Override
    public void visitBitOr(BitOr bitOr) {

    }

    @Override
    public void visitAnd(And and) {

    }

    @Override
    public void visitOr(Or or) {

    }

    @Override
    public void visitAssign(Assign assign) {

    }

    @Override
    public void visitAssignMultiply(AssignMultiply assignMultiply) {

    }

    @Override
    public void visitAssignDivide(AssignDivide assignDivide) {

    }

    @Override
    public void visitAssignModulus(AssignModulus assignModulus) {

    }

    @Override
    public void visitAssignAdd(AssignAdd assignAdd) {

    }

    @Override
    public void visitAssignSubtract(AssignSubtract assignSubtract) {

    }

    @Override
    public void visitAssignBitLeftShift(AssignBitLeftShift assignBitLeftShift) {

    }

    @Override
    public void visitAssignBitSignedRightShift(AssignBitSignedRightShift assignBitSignedRightShift) {

    }

    @Override
    public void visitAssignBitUnsignedRightShift(AssignBitUnsignedRightShift assignBitUnsignedRightShift) {

    }

    @Override
    public void visitAssignBitAnd(AssignBitAnd assignBitAnd) {

    }

    @Override
    public void visitAssignBitXor(AssignBitXor assignBitXor) {

    }

    @Override
    public void visitAssignBitOr(AssignBitOr assignBitOr) {

    }

    @Override
    public void visitGenericOperator(GenericOperator genericOperator) {

    }

    @Override
    public void visitInstanceOfExpression(InstanceOfExpression instanceOfExpression) {

    }

    @Override
    public void visitPrefixUnaryExpression(PrefixUnaryExpression prefixUnaryExpression) {

    }

    @Override
    public void visitPostfixUnaryExpression(PostfixUnaryExpression postfixUnaryExpression) {

    }

    @Override
    public void visitPostIncrement(PostIncrement postIncrement) {

    }

    @Override
    public void visitPostDecrement(PostDecrement postDecrement) {

    }

    @Override
    public void visitUnaryPlus(UnaryPlus unaryPlus) {

    }

    @Override
    public void visitUnaryMinus(UnaryMinus unaryMinus) {

    }

    @Override
    public void visitIncrement(Increment increment) {

    }

    @Override
    public void visitDecrement(Decrement decrement) {

    }

    @Override
    public void visitBitNot(BitNot bitNot) {

    }

    @Override
    public void visitNot(Not not) {

    }

    @Override
    public void visitDefaultUnaryOperator(DefaultUnaryOperator defaultUnaryOperator) {

    }

    @Override
    public void visitCastExpression(CastExpression castExpression) {

    }

    @Override
    public void visitBooleanLiteral(BooleanLiteral booleanLiteral) {

    }

    @Override
    public void visitCharLiteral(CharLiteral charLiteral) {

    }

    @Override
    public void visitIntegerLiteral(IntegerLiteral integerLiteral) {

    }

    @Override
    public void visitStringLiteral(StringLiteral stringLiteral) {

    }

    @Override
    public void visitRealLiteral(RealLiteral realLiteral) {

    }

    @Override
    public void visitNullLiteral(NullLiteral nullLiteral) {

    }

    @Override
    public void visitIdentifierReference(IdentifierReference identifierReference) {

    }

    @Override
    public void visitParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {

    }

    @Override
    public void visitFunctionCallExpression(FunctionCallExpression functionCallExpression) {

    }

    @Override
    public void visitActualParameterExpression(ActualParameterExpression actualParameterExpression) {

    }

    @Override
    public void visitSuperMethodInvocation(SuperMethodInvocation superMethodInvocation) {

    }

    @Override
    public void visitArrayCreation(ArrayCreation arrayCreation) {

    }

    @Override
    public void visitCollectionExpression(CollectionExpression collectionExpression) {

    }

    @Override
    public void visitArrayAccess(ArrayAccess arrayAccess) {

    }

    @Override
    public void visitConditionalExpression(ConditionalExpression conditionalExpression) {

    }

    @Override
    public void visitNewExpression(NewExpression newExpression) {

    }

    @Override
    public void visitQualifiedOverData(QualifiedOverData qualifiedOverData) {

    }

    @Override
    public void visitLabelAccess(LabelAccess labelAccess) {

    }

    @Override
    public void visitMemberAccess(MemberAccess memberAccess) {

    }

    @Override
    public void visitSuperMemberAccess(SuperMemberAccess superMemberAccess) {

    }

    @Override
    public void visitVariableExpression(VariableExpression variableExpression) {

    }

    @Override
    public void visitPointerAccess(PointerAccess pointerAccess) {

    }

    @Override
    public void visitCheckedExpression(CheckedExpression checkedExpression) {

    }

    @Override
    public void visitUncheckedExpression(UncheckedExpression uncheckedExpression) {

    }

    @Override
    public void visitName(Name name) {

    }

    @Override
    public void visitAbstractModifier(AbstractModifier abstractModifier) {

    }

    @Override
    public void visitAnnotationModifier(AnnotationModifier annotationModifier) {

    }

    @Override
    public void visitDefaultModifier(DefaultModifier defaultModifier) {

    }

    @Override
    public void visitFinalModifier(FinalModifier finalModifier) {

    }

    @Override
    public void visitNativeModifier(NativeModifier nativeModifier) {

    }

    @Override
    public void visitPrivateModifier(PrivateModifier privateModifier) {
        String functionModifier = privateModifier.getModifier();
        try {
            frame.writeFunctionModifier(functionModifier);
        } catch (ModifierNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitProtectedModifier(ProtectedModifier protectedModifier) {
        String functionModifier = protectedModifier.getModifier();
        try {
            frame.writeFunctionModifier(functionModifier);
        } catch (ModifierNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitPublicModifier(PublicModifier publicModifier) {
        String functionModifier = publicModifier.getModifier();
        try {
            frame.writeFunctionModifier(functionModifier);
        } catch (ModifierNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitStaticModifier(StaticModifier staticModifier) {
        frame.writeStaticFunction();
    }

    @Override
    public void visitSingleMemberAnnotation(SingleMemberAnnotation singleMemberAnnotation) {

    }

    @Override
    public void visitStrictfpModifier(StrictfpModifier strictfpModifier) {

    }

    @Override
    public void visitSynchronizedModifier(SynchronizedModifier synchronizedModifier) {

    }

    @Override
    public void visitTransientModifier(TransientModifier transientModifier) {

    }

    @Override
    public void visitVolatileModifier(VolatileModifier volatileModifier) {

    }

    @Override
    public void visitRefModifier(RefModifier refModifier) {

    }
}
