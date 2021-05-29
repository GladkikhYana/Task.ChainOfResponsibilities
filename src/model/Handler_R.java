package model;

public abstract class Handler_R {
    private Handler_R processor;
    public Handler_R(Handler_R processor)
    {
        this.processor = processor;
    }
    public boolean process(Integer request)
    {
        if(processor != null)
            return processor.process(request);
        else
            return true;
    }
}