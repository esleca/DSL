package gastgateway.visitors;

import ASTMCore.visitor.GASTVisitor;
import gastgateway.IFrameDSL;

public abstract class VisitorBase implements GASTVisitor {

    protected IFrameDSL frame;
    public IFrameDSL getFrameDSL() {
        return frame;
    }

}
