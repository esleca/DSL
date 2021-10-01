package models.entities.unittests.acts;

public class InstanceAct extends Act implements IInstanceActioner {

    private ActNewType actNewType;

    public InstanceAct(ActNewType actNewType, ActExecution actExecution) {
        this.actNewType = actNewType;
        this.actExecution = actExecution;
    }

    @Override
    public ActNewType getActNewType() {
        return actNewType;
    }

}
