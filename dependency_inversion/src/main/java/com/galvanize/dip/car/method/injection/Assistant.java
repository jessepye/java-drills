package com.galvanize.dip.car.method.injection;

public abstract class Assistant {

    protected Assistable assistable;

    public void connect(Assistable assistable) {
        this.assistable = assistable;
        assistable.addAssistant(this);
    }

    abstract void assist();
}
