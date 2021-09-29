package processor.gastgateway.visitors;

import ASTMCore.visitor.GASTVisitor;

public abstract class VisitorBase implements GASTVisitor {

    protected IFrameDSL frame;
    public IFrameDSL getFrameDSL() {
        return frame;
    }

}
